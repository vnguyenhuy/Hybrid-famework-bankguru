package pageObjectsJQuery;

import org.openqa.selenium.WebDriver;

public class PageObjectJQueryGeneratorManager {
	
	private static HomePageJQueryObject homePage;
	
	public static HomePageJQueryObject getHomePageJQueryObject(WebDriver driver) {
		if(homePage == null || !homePage.getDriver().equals(driver)) {
			homePage = new HomePageJQueryObject(driver);
		}		
		return homePage;
	}
}
