package pageObjects.liveguru;

import org.openqa.selenium.WebDriver;

import commons.BasePage;

public class SearchTermsLiveGuruObject extends BasePage{
	private WebDriver driver;
	
	public SearchTermsLiveGuruObject(WebDriver driver) {
		this.driver = driver;
	}

	public WebDriver getDriver() {
		// TODO Auto-generated method stub
		return driver;
	}
}
