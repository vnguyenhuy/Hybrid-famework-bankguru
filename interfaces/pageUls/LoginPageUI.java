package pageUls;

import org.openqa.selenium.By;

public class LoginPageUI {
	public static final By EMAIL_TEXTBOX = By.cssSelector("#Email");
	public static final By PASSWORD_TEXTBOX = By.cssSelector("#Password");
	public static final By LOGIN_BUTTON = By.xpath("//button[text() = 'Log in']");
}
