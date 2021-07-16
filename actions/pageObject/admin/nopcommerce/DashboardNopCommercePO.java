package pageObject.admin.nopcommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;

public class DashboardNopCommercePO extends BasePage{
	private WebDriver driver;
	
	public DashboardNopCommercePO(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebDriver getDriver() {
		return driver;
	}	
}
