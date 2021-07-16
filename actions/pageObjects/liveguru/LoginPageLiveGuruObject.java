package pageObjects.liveguru;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.liveguru.LoginPageLiveGuruUIs;

public class LoginPageLiveGuruObject extends BasePage {

	private WebDriver driver;		
	
	public WebDriver getDriver() {
		return driver;
	}
	
	public LoginPageLiveGuruObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public void enterEmailTextbox(String email) {
		waitForElementVisible(driver, LoginPageLiveGuruUIs.EMAIL_TEXT_BOX);
		sendkey(driver, LoginPageLiveGuruUIs.EMAIL_TEXT_BOX, email);
	}

	public void enterPasswordTextbox(String password) {
		waitForElementVisible(driver, LoginPageLiveGuruUIs.PASSWORD_TEXT_BOX);
		sendkey(driver, LoginPageLiveGuruUIs.PASSWORD_TEXT_BOX, password);
	}

	public MyDashboardLiveGuruObject clickLoginButton() {
		waitForElementClickable(driver, LoginPageLiveGuruUIs.LOGIN_BUTTON);
		click(driver, LoginPageLiveGuruUIs.LOGIN_BUTTON);
		return PageObjectLiveGuruGeneratorManager.getDashboardPage(driver);
	}

	public String getEmptyEmailErrorMsg() {
		waitForElementVisible(driver, LoginPageLiveGuruUIs.EMPTY_EMAIL_ERROR_MSG);
		return getText(driver, LoginPageLiveGuruUIs.EMPTY_EMAIL_ERROR_MSG);
	}

	public String getEmptyPasswordErrorMsg() {
		waitForElementVisible(driver, LoginPageLiveGuruUIs.EMPTY_PASSWORD_ERROR_MSG);
		return getText(driver, LoginPageLiveGuruUIs.EMPTY_PASSWORD_ERROR_MSG);
	}

	public String getInvalidEmailErrorMsg() {
		waitForElementVisible(driver, LoginPageLiveGuruUIs.INVALID_EMAIL_ERROR_MSG);
		return getText(driver, LoginPageLiveGuruUIs.INVALID_EMAIL_ERROR_MSG);
	}

	public String getInvalidPasswordErrorMsg() {
		waitForElementVisible(driver, LoginPageLiveGuruUIs.INVALID_PASSWORD_ERROR_MSG);
		return getText(driver, LoginPageLiveGuruUIs.INVALID_PASSWORD_ERROR_MSG);
	}

	public String getInvalidEmailOrPasswordErrorMsg() {
		waitForElementVisible(driver, LoginPageLiveGuruUIs.INVALID_EMAIL_OR_PASSWORD_ERROR_MSG);
		return getText(driver, LoginPageLiveGuruUIs.INVALID_EMAIL_OR_PASSWORD_ERROR_MSG);
	}

}
