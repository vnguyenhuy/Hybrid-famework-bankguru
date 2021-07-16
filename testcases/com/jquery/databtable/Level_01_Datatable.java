package com.jquery.databtable;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Sleeper;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjectsJQuery.HomePageJQueryObject;
import pageObjectsJQuery.PageObjectJQueryGeneratorManager;

public class Level_01_Datatable extends BaseTest{
	WebDriver driver;
	HomePageJQueryObject homePage;
	
	@Parameters({"browser", "testingURL"})
	@BeforeClass
	public void initBrowser(String browser, String testingURL) {
		driver = getBrowserDriver(browser, testingURL);
		homePage = PageObjectJQueryGeneratorManager.getHomePageJQueryObject(driver);
	}
	
	@AfterClass
	public void beforeClass() {
		driver.quit();
	}
	
	//@Test
	public void Test_01_Paging() {
		homePage.openDataTablePage("4");
		Assert.assertTrue(homePage.isPageDataSelected("4"));
		sleepInSeconds(3);
		
		homePage.openDataTablePage("10");
		Assert.assertTrue(homePage.isPageDataSelected("10"));
		sleepInSeconds(3);
		
		homePage.openDataTablePage("15");
		Assert.assertTrue(homePage.isPageDataSelected("15"));
		sleepInSeconds(3);
	}
	
	//@Test
	public void TC_02_Actions() {
		homePage.inputHeaderTextBox("Females", "777");
		sleepInSeconds(2);
		homePage.refresh(driver);
		
		homePage.inputHeaderTextBox("Country", "Armenia");
		sleepInSeconds(2);
		homePage.refresh(driver);
		
		homePage.inputHeaderTextBox("Males", "276472");
		sleepInSeconds(2);
		homePage.refresh(driver);
		
		homePage.inputHeaderTextBox("Total", "49397");
		sleepInSeconds(2);
		homePage.refresh(driver);
	}
	
	//@Test
	public void TC_03_Click_Icon() {
		homePage.clickToIconByCountryName("Argentina", "remove");
		sleepInSeconds(2);
		
		homePage.clickToIconByCountryName("Angola", "edit");		
		sleepInSeconds(2);		
		homePage.refresh(driver);
		
		homePage.clickToIconByCountryName("Albania", "remove");
		sleepInSeconds(2);		
		
		homePage.clickToIconByCountryName("Aruba", "edit");
		sleepInSeconds(2);		
		homePage.refresh(driver);
	}
	
	//@Test
	public void TC_04_Verify_Row_Values() {
		homePage.inputHeaderTextBox("Country", "Angola");
		Assert.assertTrue(homePage.isRowValueDisplayed("276880", "Angola", "276472", "553353"));
		sleepInSeconds(2);
		
		homePage.inputHeaderTextBox("Country", "Arab Rep of Egypt");
		Assert.assertTrue(homePage.isRowValueDisplayed("764956", "Arab Rep of Egypt", "802948", "1567904"));
		sleepInSeconds(2);
	}
	
	//@Test
	public void TC_05_InputToRowTextbox() {
		driver.get("https://www.jqueryscript.net/demo/jQuery-Dynamic-Data-Grid-Plugin-appendGrid/");
		homePage.inputTextBoxByRowIndex("Contact Person", 2, "Wiliam Vo");
		sleepInSeconds(2);
		
		homePage.inputTextBoxByRowIndex("Order Placed", 1, "5");
		sleepInSeconds(2);
		
		homePage.inputTextBoxByRowIndex("Company", 2, "Apple");
		sleepInSeconds(2);
		
	}
	
	@Test
	public void TC_06_ClickIconAtRow() {
		driver.get("https://www.jqueryscript.net/demo/jQuery-Dynamic-Data-Grid-Plugin-appendGrid/");
		homePage.clickToIconByRowNumber(2, "Move Up");
		sleepInSeconds(2);
		
		homePage.clickToIconByRowNumber(3, "Move Down");
		sleepInSeconds(2);
		
		homePage.clickToIconByRowNumber(1, "Insert Row Above");
		sleepInSeconds(2);
		
		homePage.clickToIconByRowNumber(1, "Remove Current Row");
		sleepInSeconds(2);
	}
	
	public void sleepInSeconds(int seconds) {
		try {
			Thread.sleep(seconds*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
