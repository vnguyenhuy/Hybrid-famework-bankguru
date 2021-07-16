package com.facebook.register;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.facebook.PORegisterManageGenerator;
import pageObjects.facebook.RegisterPO;

public class Level_06_Register_Login_Element_Undisplayed extends BaseTest{
	private WebDriver driver;
	RegisterPO registerPage;
	
	@Parameters({"browser", "testingURL"})
	@BeforeClass
	public void initBrowser(String browser, String testingURL) {
		driver = getBrowserDriver(browser, testingURL);
		registerPage = PORegisterManageGenerator.getRegisterPO(driver);		
	}
	
	@AfterClass
	public void beforeClass() {
		driver.quit();
	}
	
	//@Test
	public void Login_01_Element_Displayed() {
		Assert.assertTrue(registerPage.isEmailTextboxDisplay());
		
		registerPage.inputToEmailTextbox("vnhuy@gmail.com");
		registerPage.sleepInSecond(3);
		
		Assert.assertTrue(registerPage.isConfirmEmailTextboxDisplay());
	}
	
	//@Test
	public void Login_02_Element_Undisplayed_In_DOM() {
		registerPage.inputToEmailTextbox("");
		registerPage.sleepInSecond(3);
		
		Assert.assertFalse(registerPage.isConfirmEmailTextboxDisplay());
		
		Assert.assertTrue(registerPage.isConfirmEmailTextboxUndisplay());
	}
	
	//@Test
	public void Login_03_Element_Undisplayed_Not_In_DOM() {
		Assert.assertFalse(registerPage.isLoginButtonDisplayed());
		//Assert.assertTrue(registerPage.isLoginButtonUnisplayed());
	}
	
	//@Test
	public void Login_04_Element_Undisplayed_Not_In_DOM() {
		Assert.assertTrue(registerPage.isLoginButtonUnisplayed());
	}
	
	@Test
	public void Login_05_Register_01_Verify() {
		verifyTrue(registerPage.isEmailTextboxDisplay());
		
		log.info("Login - Step 1: Input email into the textbox");
		registerPage.inputToEmailTextbox("vnhuy@gmail.com");
		registerPage.sleepInSecond(3);
		
		verifyTrue(registerPage.isConfirmEmailTextboxDisplay());
		
		log.info("Login - Step 2: clear the email textbox");
		registerPage.inputToEmailTextbox("");
		registerPage.sleepInSecond(3);
		
		verifyFalse(registerPage.isConfirmEmailTextboxDisplay());
		
		verifyTrue(registerPage.isConfirmEmailTextboxUndisplay());
		
		verifyTrue(registerPage.isLoginButtonUnisplayed());
	}
}
