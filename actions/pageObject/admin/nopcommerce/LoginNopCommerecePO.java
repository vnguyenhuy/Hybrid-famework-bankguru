package pageObject.admin.nopcommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.admin.nopcommerce.LoginNopCommercePageUIs;

public class LoginNopCommerecePO extends BasePage{
	private WebDriver driver;
	
	public LoginNopCommerecePO(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebDriver getDriver() {
		return driver;
	}

	public void inputToEmailTextbox(String email) {
		waitForElementVisible(driver, LoginNopCommercePageUIs.EMAIL_TEXTBOX);
		sendkey(driver, LoginNopCommercePageUIs.EMAIL_TEXTBOX, email);
	}

	public void inputToPasswordTextbox(String password) {
		waitForElementVisible(driver, LoginNopCommercePageUIs.PASSWORD_TEXTBOX);
		sendkey(driver, LoginNopCommercePageUIs.PASSWORD_TEXTBOX, password);
		
	}

	public DashboardNopCommercePO clickToLoginButton() {
		waitForElementVisible(driver, LoginNopCommercePageUIs.LOGIN_BUTTON);
		click(driver, LoginNopCommercePageUIs.LOGIN_BUTTON);
		return PONopCommerceGeneratorManage.getDashboardPage(driver);
	}
}
