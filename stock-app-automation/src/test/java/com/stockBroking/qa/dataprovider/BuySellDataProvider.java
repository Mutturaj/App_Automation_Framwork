package com.stockBroking.qa.dataprovider;

import com.stockBroking.qa.model.BuySell;
import org.testng.annotations.DataProvider;

public class BuySellDataProvider extends BuySell {

    @DataProvider(name = "BuySellData")
    public Object[][] getOrderData() {
        String searchData = "ITC Ltd.";
        return new Object[][]{
                {searchData}
        };
    }
}
