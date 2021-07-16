package pageObjects.liveguru;

import org.openqa.selenium.WebDriver;

public class PageObjectLiveGuruGeneratorManager {
	private static HomePageLiveGuruObject homePage;
	private static LoginPageLiveGuruObject loginPage;
	private static MyDashboardLiveGuruObject myDashboard;
	private static SearchTermsLiveGuruObject searchTerms;
	private static OrdersAndReturnsLiveGuruObject ordersAndReturns;
	private static SiteMapLiveGuruObject siteMap;
	
	public static HomePageLiveGuruObject getHomePage(WebDriver driver) {
		if(homePage == null || !homePage.getDriver().equals(driver)) {
			homePage = new HomePageLiveGuruObject(driver);
		}
		return homePage;
	}
	
	public static LoginPageLiveGuruObject getLoginPage(WebDriver driver) {
		if(loginPage == null || !loginPage.getDriver().equals(driver)) {
			loginPage = new LoginPageLiveGuruObject(driver);
		}
		return loginPage;
	}
	
	public static MyDashboardLiveGuruObject getDashboardPage(WebDriver driver) {
		if(myDashboard == null || !myDashboard.getDriver().equals(driver)) {
			myDashboard = new MyDashboardLiveGuruObject(driver);
		}
		return myDashboard;
	}
	
	public static SearchTermsLiveGuruObject getSearchTermsLiveGuru(WebDriver driver) {
		if(searchTerms == null || !searchTerms.getDriver().equals(driver)) {
			searchTerms = new SearchTermsLiveGuruObject(driver);
		}
		return searchTerms;
	}
	
	public static OrdersAndReturnsLiveGuruObject getOrdersAndReturnsLiveGuru(WebDriver driver) {
		if(ordersAndReturns == null || !ordersAndReturns.getDriver().equals(driver)) {
			ordersAndReturns = new OrdersAndReturnsLiveGuruObject(driver);
		}
		return ordersAndReturns;
	}
	
	public static SiteMapLiveGuruObject getSiteMapLiveGuru(WebDriver driver) {
		if(siteMap == null || !siteMap.getDriver().equals(driver)) {
			siteMap = new SiteMapLiveGuruObject(driver);
		}
		return siteMap;
	}
}
