package pageUIs.liveguru;

import org.openqa.selenium.By;

public class LoginPageLiveGuruUIs {
	public static final By EMAIL_TEXT_BOX = By.cssSelector("#email");
	public static final By PASSWORD_TEXT_BOX = By.cssSelector("#pass");
	public static final By LOGIN_BUTTON = By.cssSelector("#send2");
	public static final By EMPTY_EMAIL_ERROR_MSG = By.cssSelector("#advice-required-entry-email");
	public static final By EMPTY_PASSWORD_ERROR_MSG = By.cssSelector("#advice-required-entry-pass");
	public static final By INVALID_EMAIL_ERROR_MSG = By.cssSelector("#advice-validate-email-email");
	public static final By INVALID_PASSWORD_ERROR_MSG = By.cssSelector("#advice-validate-password-pass");
	public static final By INVALID_EMAIL_OR_PASSWORD_ERROR_MSG = By.cssSelector(".error-msg span");
	
}
