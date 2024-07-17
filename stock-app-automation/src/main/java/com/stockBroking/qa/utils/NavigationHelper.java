package com.stockBroking.qa.utils;

import com.stockBroking.qa.pages.Notification.NotificationPage;
import com.stockBroking.qa.pages.PortFolio.PortfolioPage;
import com.stockBroking.qa.pages.WealthBasketPage.WealthBasketPage;
import com.stockBroking.qa.pages.commonNavigationPages.NavigationObjects;
import com.stockBroking.qa.pages.discover.DiscoverPage;
import com.stockBroking.qa.pages.homepage.MarketPage;
import com.stockBroking.qa.pages.profile.ProfilePage;
import com.stockBroking.qa.pages.searchPage.SearchPage;
import com.stockBroking.qa.pages.watchlist.WatchListPage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import utilities.EnvironmentVariable;
import static listner.ThreadCreator.getLocalDriver;

public class NavigationHelper {

    private final NavigationObjects navigationObjects;
    private final TestUtils utils;

    public NavigationHelper() {
        this.navigationObjects = new NavigationObjects();
        utils = new TestUtils();
    }

    public WatchListPage goToWatchList() {
        utils.loadUntilElementFound(navigationObjects.watchList);
        navigationObjects.watchList.setElementSync(true);
        navigationObjects.watchList.click();
        return new WatchListPage();
    }

    public WealthBasketPage goToWealthBasket() {
        navigationObjects.wealthBasket.setElementSync(true);
        navigationObjects.wealthBasket.click();
        return new WealthBasketPage();
    }

    public PortfolioPage goToPortFolio() {
        navigationObjects.portfolio.setElementSync(true);
        navigationObjects.portfolio.click();
        return new PortfolioPage();
    }

    public ProfilePage goToProfile() {
        goToDiscoverPage();
        navigationObjects.profile.setElementSync(true);
        if(EnvironmentVariable.getAvailableInstance().isIos()){
            utils.performSingleTap(16, 58);
        }else {
            navigationObjects.profile.click();
        }
        return new ProfilePage();
    }

    public SearchPage goToSearchPage() {
        goToMarketPage();
        navigationObjects.search.setElementSync(true);
        navigationObjects.search.click();
        return new SearchPage();
    }

    public NotificationPage goToNotificationPage() {
        navigationObjects.notification.setElementSync(true);
        navigationObjects.notification.click();
        return new NotificationPage();
    }

    public MarketPage goToMarketPage() {
        navigationObjects.market.setElementSync(true);
        navigationObjects.market.click();
        return new MarketPage();
    }

    public DiscoverPage goToDiscoverPage() {
        navigationObjects.discover.setElementSync(true);
        navigationObjects.discover.click();
        return new DiscoverPage();
    }
    public static void deviceBackKey() {
        ((AndroidDriver) getLocalDriver()).pressKey(new KeyEvent(AndroidKey.BACK));
    }


}
