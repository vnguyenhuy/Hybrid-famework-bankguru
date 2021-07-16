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

public class Level_04_Login_LiveGuru_Page_Object extends BaseTest{
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
	
	//@Test
	public void Login_01_Switch_Page() {
		homePage = PageObjectLiveGuruGeneratorManager.getHomePage(driver);
		
		ordersReturnsPage = homePage.openOrdersAndReturnsLiveGuru(driver);
		
		searchTermsPage = ordersReturnsPage.openSearchTermsLiveGuru(driver);
		
		siteMapPage = searchTermsPage.openSiteMapLiveGuru(driver);				
	}
	
	@Test
	public void Login_02_Switch_Page_Dynamic_Locator() {
		homePage = PageObjectLiveGuruGeneratorManager.getHomePage(driver);
		
		ordersReturnsPage = (OrdersAndReturnsLiveGuruObject) homePage.openFooterPageByName(driver, "Orders and Returns");
		
		searchTermsPage = (SearchTermsLiveGuruObject) ordersReturnsPage.openFooterPageByName(driver, "Search Terms");
		
		siteMapPage = (SiteMapLiveGuruObject) searchTermsPage.openFooterPageByName(driver, "Site Map");				
	}
	
	@Test
	public void Login_03_Switch_Page_Dynamic_Locator() {
		homePage = PageObjectLiveGuruGeneratorManager.getHomePage(driver);
		
		homePage.getFooterPageByName(driver, "Orders and Returns");
		ordersReturnsPage = PageObjectLiveGuruGeneratorManager.getOrdersAndReturnsLiveGuru(driver);
		
		ordersReturnsPage.getFooterPageByName(driver, "Search Terms");
		searchTermsPage = PageObjectLiveGuruGeneratorManager.getSearchTermsLiveGuru(driver);
		
		searchTermsPage.openFooterPageByName(driver, "Site Map");
		siteMapPage = PageObjectLiveGuruGeneratorManager.getSiteMapLiveGuru(driver);
	}
	
	public String generateEmail(String username) {
		Random ran = new Random();
		ran.ints(0, 10000);
		return username + ran.nextInt() + "@gmail.com";
	}
}
