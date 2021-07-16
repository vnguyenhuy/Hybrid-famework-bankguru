package pageUIs.liveguru;

import org.openqa.selenium.By;

public class MyDashboardUIs {
	public static final By MY_DASHBOARD_HEADER_TEXT = By.xpath("//h1[text() = 'My Dashboard']");
	public static final By ACCOUNT_HEADER_TEXT = By.xpath("//header[@id='header']//span[text() = 'Account']");
	public static final By LOGOUT_TEXT = By.xpath("//header[@id='header']//a[text() = 'Log Out']");
	
}
