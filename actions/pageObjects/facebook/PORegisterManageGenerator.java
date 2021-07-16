package pageObjects.facebook;

import org.openqa.selenium.WebDriver;

public class PORegisterManageGenerator {
	
	private static RegisterPO registerPage;
	
	public static RegisterPO getRegisterPO(WebDriver driver) {
		if(registerPage == null || !registerPage.getDriver().equals(driver)) {
			registerPage = new RegisterPO(driver);
		}
		return registerPage;				
	}
}
