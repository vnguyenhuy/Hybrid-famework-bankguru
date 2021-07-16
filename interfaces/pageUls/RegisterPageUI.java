package pageUls;

import org.openqa.selenium.By;

public class RegisterPageUI {
	public static final By GENDER_MALE_RADIO_BUTTON = By.cssSelector("#gender-male");
	public static final By FIRST_NAME_TEXT_BOX = By.cssSelector("#FirstName");
	public static final By LAST_NAME_TEXT_BOX = By.cssSelector("#LastName");
	public static final By EMAIL_TEXT_BOX = By.cssSelector("#Email");
	public static final By PASSWORD_TEXT_BOX = By.cssSelector("#Password");
	public static final By CONFIRM_TEXT_BOX = By.cssSelector("#ConfirmPassword");
	public static final By REGISTER_BUTTON = By.cssSelector("#register-button");
	public static final By SUCCESS_MESSAGE = By.xpath("//div[text() = 'Your registration completed']");
	public static final By LOGOUT_LINK = By.cssSelector(".ico-logout");
}
