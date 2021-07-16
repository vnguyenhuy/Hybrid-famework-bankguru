package com.liveguru.login;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.liveguru.HomePageLiveGuruObject;
import pageObjects.liveguru.LoginPageLiveGuruObject;
import pageObjects.liveguru.MyDashboardLiveGuruObject;
import pageObjects.liveguru.OrdersAndReturnsLiveGuruObject;
import pageObjects.liveguru.PageObjectLiveGuruGeneratorManager;
import pageObjects.liveguru.SearchTermsLiveGuruObject;
import pageObjects.liveguru.SiteMapLiveGuruObject;

public class Level_03_Login_LiveGuru_Page_Object extends BaseTest{
	WebDriver driver;
	HomePageLiveGuruObject homePage;
	LoginPageLiveGuruObject loginPage;
	MyDashboardLiveGuruObject myDashboard;
	OrdersAndReturnsLiveGuruObject ordersReturnsPage;
	SearchTermsLiveGuruObject searchTermsPage;
	SiteMapLiveGuruObject siteMapPage;
	
	String email, password;
	
	@Parameters({"browser", "testingURL"})
	@BeforeClass
	public void beforeClass(String browser, String testingURL) {
		driver = getBrowserDriver(browser, testingURL);
		email = generateEmail("milk");
		password = "123123";
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	
	@Test
	public void Login_01_Empty_Email_And_Password() {
		homePage = PageObjectLiveGuruGeneratorManager.getHomePage(driver);
		
		loginPage = homePage.clickMyAccountLink();												
		
		loginPage.enterEmailTextbox("");
		
		loginPage.enterPasswordTextbox("");
		
		loginPage.clickLoginButton();
		
		Assert.assertEquals(loginPage.getEmptyEmailErrorMsg(), "This is a required field.");
		Assert.assertEquals(loginPage.getEmptyPasswordErrorMsg(), "This is a required field.");
	}
	
	@Test
	public void Login_02_Invalid_Email() {
		homePage = PageObjectLiveGuruGeneratorManager.getHomePage(driver);
		
		loginPage = homePage.clickMyAccountLink();												
		
		loginPage.enterEmailTextbox("123@123.789");
		
		loginPage.enterPasswordTextbox("123123");
		
		loginPage.clickLoginButton();
		
		Assert.assertEquals(loginPage.getInvalidEmailErrorMsg(), "Please enter a valid email address. For example johndoe@domain.com.");		
	}
	
	@Test
	public void Login_03_Invalid_Password() {
		homePage = PageObjectLiveGuruGeneratorManager.getHomePage(driver);
		
		loginPage = homePage.clickMyAccountLink();												
		
		loginPage.enterEmailTextbox("abc@gmail.com");
		
		loginPage.enterPasswordTextbox("123");
		
		loginPage.clickLoginButton();
		
		Assert.assertEquals(loginPage.getInvalidPasswordErrorMsg(), "Please enter 6 or more characters without leading or trailing spaces.");
	}
	
	@Test
	public void Login_04_Incorrect_Email() {
		homePage = PageObjectLiveGuruGeneratorManager.getHomePage(driver);
		
		loginPage = homePage.clickMyAccountLink();
		
		loginPage.enterEmailTextbox(generateEmail("alaba"));
		
		loginPage.enterPasswordTextbox("123123");
		
		loginPage.clickLoginButton();
		
		Assert.assertEquals(loginPage.getInvalidEmailOrPasswordErrorMsg(), "Invalid login or password.");
	}
	
	@Test
	public void Login_05_Incorrect_Password() {
		homePage = PageObjectLiveGuruGeneratorManager.getHomePage(driver);
		
		loginPage = homePage.clickMyAccountLink();
		
		loginPage.enterEmailTextbox("huyvo@gmail.com");
		
		loginPage.enterPasswordTextbox("123456");
		
		loginPage.clickLoginButton();
		
		Assert.assertEquals(loginPage.getInvalidEmailOrPasswordErrorMsg(), "Invalid login or password.");
	}
	
	@Test
	public void Login_06_Valid_Email_And_Password() {
		homePage = PageObjectLiveGuruGeneratorManager.getHomePage(driver);
		
		loginPage = homePage.clickMyAccountLink();
		
		loginPage.enterEmailTextbox("huyvo@gmail.com");
		
		loginPage.enterPasswordTextbox("123123");
		
		myDashboard = loginPage.clickLoginButton();				
		
		Assert.assertTrue(myDashboard.isMyHeaderDashboardDisplayed());
		
		homePage = myDashboard.clickLogOut();
		
		Assert.assertTrue(homePage.isDisplayHomePage());
	}
	
	@Test
	public void Login_07_Switch_Page() {
		homePage = PageObjectLiveGuruGeneratorManager.getHomePage(driver);
		
		ordersReturnsPage = homePage.openOrdersAndReturnsLiveGuru(driver);
		
		searchTermsPage = ordersReturnsPage.openSearchTermsLiveGuru(driver);
		
		siteMapPage = searchTermsPage.openSiteMapLiveGuru(driver);				
	}
	
	public String generateEmail(String username) {
		Random ran = new Random();
		ran.ints(0, 10000);
		return username + ran.nextInt() + "@gmail.com";
	}
}
