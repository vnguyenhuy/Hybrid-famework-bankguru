package pageObjects.liveguru;

import org.openqa.selenium.WebDriver;

import commons.BasePage;

public class SiteMapLiveGuruObject extends BasePage{

	private WebDriver driver;
	
	public SiteMapLiveGuruObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebDriver getDriver() {
		return driver;
	}
}
