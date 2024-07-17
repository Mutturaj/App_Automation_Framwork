package com.stockBroking.qa.testRail;

import logger.LogController;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
/**
 * @author kuldeep.yadav
 * @date 18/02/24
 * @package testRail
 */
public class TestRailClient {

    private final LogController logger = new LogController(TestRailClient.class);
    private final String m_url;


    public TestRailClient(String base_url) {
        if (!base_url.endsWith("/")) {
            base_url += "/";
        }
        this.m_url = base_url;
    }

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    public String  authToken;


    public Object sendGet(String uri, String data)
            throws IOException, APIException {
        return this.sendRequest("GET", uri, data);
    }

    public Object sendGet(String uri)
            throws IOException, APIException {
        return this.sendRequest("GET", uri, null);
    }

    public Object sendPost(String uri, Object data)
            throws IOException, APIException {
        return this.sendRequest("POST", uri, data);

    }

    private Object sendRequest(String method, String uri, Object data)
            throws IOException, APIException {
        URL url = new URL(this.m_url + uri);
        HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
        conn.setHostnameVerifier(getHostnameVerifier());
        conn.addRequestProperty("Authorization", "Basic "+this.getAuthToken());

        if (method.equals("POST")) {
            conn.setRequestMethod("POST");
            if (data != null) {
                if (uri.startsWith("add_attachment")){
                    String boundary = "TestRailAPIAttachmentBoundary";
                    File uploadFile = new File((String) data);
                    conn.setDoOutput(true);
                    conn.addRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);
                    OutputStream oStreamBody = conn.getOutputStream();
                    BufferedWriter bodyWriter = new BufferedWriter(new OutputStreamWriter(oStreamBody));
                    bodyWriter.write("\n\n--" + boundary + "\r\n");
                    bodyWriter.write("Content-Disposition: form-data; name=\"attachment\"; filename=\""
                            + uploadFile.getName() + "\"");
                    bodyWriter.write("\r\n\r\n");
                    bodyWriter.flush();
                    InputStream istreamFile = new FileInputStream(uploadFile);
                    int bytesRead;
                    byte[] dataBuffer = new byte[1024];
                    while ((bytesRead = istreamFile.read(dataBuffer)) != -1) {
                        oStreamBody.write(dataBuffer, 0, bytesRead);
                    }
                    oStreamBody.flush();
                    bodyWriter.write("\r\n--" + boundary + "--\r\n");
                    bodyWriter.flush();
                    istreamFile.close();
                    oStreamBody.close();
                    bodyWriter.close();
                } else {
                    conn.addRequestProperty("Content-Type", "application/json");
                    byte[] block = JSONValue.toJSONString(data).
                            getBytes(StandardCharsets.UTF_8);

                    conn.setDoOutput(true);
                    System.out.println(conn.getOutputStream()); // delete after debug
                    OutputStream oStream = conn.getOutputStream();
                    oStream.write(block);
                    oStream.close();
                }
            }
        } else {
            conn.addRequestProperty("Content-Type", "application/json");
        }
        int status = conn.getResponseCode();
        InputStream istream;
        if (status != 200) {
            istream = conn.getErrorStream();
            if (istream == null) {
                throw new APIException(
                        "TestRail API return HTTP " + status +
                                " (No additional error message received)"
                );
            }
        } else {
            istream = conn.getInputStream();
        }
        if ((istream != null)
                && (uri.startsWith("get_attachment/"))) {
            assert data != null;
            FileOutputStream outputStream = new FileOutputStream((String) data);

            int bytesRead = 0;
            byte[] buffer = new byte[1024];
            while ((bytesRead = istream.read(buffer)) > 0) {
                outputStream.write(buffer, 0, bytesRead);
            }

            outputStream.close();
            istream.close();
            return (String) data;
        }
        StringBuilder text = new StringBuilder();
        if (istream != null) {
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(
                            istream,
                            StandardCharsets.UTF_8
                    )
            );
            String line;
            while ((line = reader.readLine()) != null) {
                text.append(line);
                text.append(System.getProperty("line.separator"));
            }

            reader.close();
        }
        Object result;
        if (!text.toString().equals("")) {
            result = JSONValue.parse(text.toString());
        } else {
            result = new JSONObject();
        }
        if (status != 200) {
            String error = "No additional error message received";
            if (result instanceof JSONObject) {
                JSONObject obj = (JSONObject) result;
                if (obj.containsKey("error")) {
                    error = '"' + (String) obj.get("error") + '"';
                }
            }

            throw new APIException(
                    "TestRail API returned HTTP " + status +
                            "(" + error + ")"
            );
        }

        return result;
    }

    private static String getAuthorization(String user, String password) {
        try {
            return new String(Base64.getEncoder().encode((user + ":" + password).getBytes()));
        } catch (IllegalArgumentException e) {
            // Not thrown
        }
        return "";
    }

    private HostnameVerifier getHostnameVerifier() {
        return (hostname, session) -> {
            HostnameVerifier hv =
                    HttpsURLConnection.getDefaultHostnameVerifier();
            return hv.verify("https://testrail.drove.qaperf.phonepe.mh1/", session);
       };
}

        }