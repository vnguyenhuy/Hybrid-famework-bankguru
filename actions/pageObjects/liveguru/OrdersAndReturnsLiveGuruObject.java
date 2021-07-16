package pageObjects.liveguru;

import org.openqa.selenium.WebDriver;

import commons.BasePage;

public class OrdersAndReturnsLiveGuruObject extends BasePage{

	private WebDriver driver;
	public OrdersAndReturnsLiveGuruObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebDriver getDriver() {
		return driver;
	}
}
