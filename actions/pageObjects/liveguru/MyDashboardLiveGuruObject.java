package pageObjects.liveguru;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.liveguru.MyDashboardUIs;

public class MyDashboardLiveGuruObject extends BasePage{
	WebDriver driver;
	
	public MyDashboardLiveGuruObject(WebDriver driver) {
		this.driver = driver;
	}

	public WebDriver getDriver() {
		return driver;
	}
	
	public boolean isMyHeaderDashboardDisplayed() {
		waitForElementVisible(driver, MyDashboardUIs.MY_DASHBOARD_HEADER_TEXT);
		return isDisplay(driver, MyDashboardUIs.MY_DASHBOARD_HEADER_TEXT);
	}
	
	public HomePageLiveGuruObject clickLogOut() {
		waitForElementClickable(driver, MyDashboardUIs.ACCOUNT_HEADER_TEXT);
		click(driver, MyDashboardUIs.ACCOUNT_HEADER_TEXT);
		waitForElementClickable(driver, MyDashboardUIs.LOGOUT_TEXT);
		click(driver, MyDashboardUIs.LOGOUT_TEXT);
		return PageObjectLiveGuruGeneratorManager.getHomePage(driver);
	}
}
