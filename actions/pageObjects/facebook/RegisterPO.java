package pageObjects.facebook;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.facebook.RegisterFBPageUIs;

public class RegisterPO extends BasePage{
	private WebDriver driver;
	
	public RegisterPO(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebDriver getDriver() {
		return driver;
	}

	public boolean isEmailTextboxDisplay() {
		return isDisplay(driver, RegisterFBPageUIs.EMAIL_TEXBOX);		
	}

	public void inputToEmailTextbox(String email) {
		sendkey(driver, RegisterFBPageUIs.EMAIL_TEXBOX, email);
	}

	public boolean isConfirmEmailTextboxDisplay() {
		return isDisplay(driver, RegisterFBPageUIs.CONFIRM_EMAIL_TEXBOX);
	}

	public boolean isLoginButtonDisplayed() {		
		return isDisplay(driver, RegisterFBPageUIs.LOGIN_BUTTON);
	}

	public boolean isLoginButtonUnisplayed() {
		return isUndisplayed(driver, RegisterFBPageUIs.LOGIN_BUTTON);
	}

	public boolean isConfirmEmailTextboxUndisplay() {
		return isUndisplayed(driver, RegisterFBPageUIs.CONFIRM_EMAIL_TEXBOX);
	}
}
