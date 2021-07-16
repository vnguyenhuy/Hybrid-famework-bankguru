package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUls.LoginPageUI;

public class LoginPageObject extends BasePage {
	private WebDriver driver;
	
	public LoginPageObject(WebDriver driver) {
		this.driver  = driver;
	}

	public void inputEmailTextbox(String email) {
		waitForElementVisible(driver, LoginPageUI.EMAIL_TEXTBOX);
		sendkey(driver, LoginPageUI.EMAIL_TEXTBOX, email);		
	}

	public void inputPasswordTextbox(String password) {
		waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		sendkey(driver, LoginPageUI.PASSWORD_TEXTBOX, password);		
		
	}

	public void clickLoginButton() {		
		waitForElementVisible(driver, LoginPageUI.LOGIN_BUTTON);
		click(driver, LoginPageUI.LOGIN_BUTTON);	
	}

}
