package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUls.RegisterPageUI;

public class RegisterPageObject extends BasePage{
	private WebDriver driver;
	
	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickToGenderMaleRadioBtn() {
		waitForElementVisible(driver, RegisterPageUI.GENDER_MALE_RADIO_BUTTON);
		click(driver, RegisterPageUI.GENDER_MALE_RADIO_BUTTON);
	}

	public void inputFirstNameTextbox(String firstName) {
		waitForElementVisible(driver, RegisterPageUI.FIRST_NAME_TEXT_BOX);
		sendkey(driver, RegisterPageUI.FIRST_NAME_TEXT_BOX, firstName);
	}

	public void inputLastNameTextbox(String lastName) {
		waitForElementVisible(driver, RegisterPageUI.LAST_NAME_TEXT_BOX);
		sendkey(driver, RegisterPageUI.LAST_NAME_TEXT_BOX, lastName);
	}

	public void inputEmailTextbox(String email) {
		waitForElementVisible(driver, RegisterPageUI.EMAIL_TEXT_BOX);
		sendkey(driver, RegisterPageUI.EMAIL_TEXT_BOX, email);
	}

	public void inputPasswordTextbox(String password) {
		waitForElementVisible(driver, RegisterPageUI.PASSWORD_TEXT_BOX);
		sendkey(driver, RegisterPageUI.PASSWORD_TEXT_BOX, password);
	}

	public void inputConfirmTextbox(String confirmPassword) {
		waitForElementVisible(driver, RegisterPageUI.CONFIRM_TEXT_BOX);
		sendkey(driver, RegisterPageUI.CONFIRM_TEXT_BOX, confirmPassword);
	}

	public boolean isSuccessMessageDisplayed() {
		waitForElementVisible(driver, RegisterPageUI.SUCCESS_MESSAGE);
		return isDisplay(driver, RegisterPageUI.SUCCESS_MESSAGE);
	}

	public void clickLogoutURL() {
		waitForElementVisible(driver, RegisterPageUI.LOGOUT_LINK);
		click(driver, RegisterPageUI.LOGOUT_LINK);
	}

	public void clickRegisterButton() {
		waitForElementVisible(driver, RegisterPageUI.REGISTER_BUTTON);
		click(driver, RegisterPageUI.REGISTER_BUTTON);
		
	}

}
