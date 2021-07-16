package com.nopcommerce.login;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.RegisterPageObject;

public class Level_03_Register_Page_Object {

	WebDriver driver;
	HomePageObject homePageObject;
	LoginPageObject loginPageObject;
	RegisterPageObject registerPageObject;
	String email, password;
	
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\browserDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://demo.nopcommerce.com/");	
		email = generateEmail("milk");
		password = "123123";
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	
	@Test
	public void Login_01_Register_To_System() {
		homePageObject = new HomePageObject(driver);
		
		homePageObject.clickRegisterURL();
		
		registerPageObject = new RegisterPageObject(driver);
		
		registerPageObject.clickToGenderMaleRadioBtn();
		
		registerPageObject.inputFirstNameTextbox("Milk");

		registerPageObject.inputLastNameTextbox("Nguyen");
		
		registerPageObject.inputEmailTextbox(email);
		
		registerPageObject.inputPasswordTextbox(password);
		
		registerPageObject.inputConfirmTextbox(password);
		
		registerPageObject.clickRegisterButton();
		
		Assert.assertTrue(registerPageObject.isSuccessMessageDisplayed());
		
		registerPageObject.clickLogoutURL();
		
		Assert.assertTrue(homePageObject.isHomePageLogoDisplayed());
	}
	//@Test
	
	@Test
	public void Login_02_Login_To_System() {
		homePageObject = new HomePageObject(driver);
		
		homePageObject.clickLoginURL();
		
		loginPageObject = new LoginPageObject(driver);
		
		loginPageObject.inputEmailTextbox(email);
		
		loginPageObject.inputPasswordTextbox(password);
		
		loginPageObject.clickLoginButton();
		
		homePageObject = new HomePageObject(driver);
		
		Assert.assertTrue(homePageObject.isHomePageLogoDisplayed());
	}
	
	public String generateEmail(String username) {
		Random ran = new Random();
		ran.ints(0, 10000);
		return username + ran.nextInt() + "@gmail.com";
	}
}
