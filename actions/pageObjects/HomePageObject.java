package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUls.HomePageUI;

public class HomePageObject extends BasePage {
	private WebDriver driver;
	
	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickRegisterURL() {
		waitForElementVisible(driver, HomePageUI.REGISTER_LINK);
		click(driver, HomePageUI.REGISTER_LINK);
	}

	public boolean isHomePageLogoDisplayed() {
		waitForElementVisible(driver, HomePageUI.HOME_PAGE_SLIDER);
		return isDisplay(driver, HomePageUI.HOME_PAGE_SLIDER);		
	}

	public void clickLoginURL() {
		waitForElementVisible(driver, HomePageUI.LOGIN_LINK);
		click(driver, HomePageUI.LOGIN_LINK);		
	}

}
