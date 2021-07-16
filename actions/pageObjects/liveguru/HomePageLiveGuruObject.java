package pageObjects.liveguru;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.liveguru.HomePageLiveGuruUIs;

public class HomePageLiveGuruObject extends BasePage {

	private WebDriver driver;
	
	public HomePageLiveGuruObject(WebDriver driver) {
		this.driver = driver;
	}		
	
	public WebDriver getDriver() {
		return driver;
	}


	public LoginPageLiveGuruObject clickMyAccountLink() {
		waitForElementVisible(driver, HomePageLiveGuruUIs.MY_ACCOUNT_ITEM);
		click(driver, HomePageLiveGuruUIs.MY_ACCOUNT_ITEM);
		return PageObjectLiveGuruGeneratorManager.getLoginPage(driver);
	}

	public boolean isDisplayHomePage() {
		waitForElementVisible(driver, HomePageLiveGuruUIs.LOGO);
		return isDisplay(driver, HomePageLiveGuruUIs.LOGO);
	}
}
