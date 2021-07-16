package com.bankguru.login;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commons.BasePage;

public class Level_01_Register_Login_BasePage_1 {
	WebDriver driver;
	String userDir = System.getProperty("user.dir");
	String loginURL = "http://demo.guru99.com/v4";
	String email;
	String userID;
	String password;	
	BasePage basePage;
	
	@BeforeClass
	public void initBrowser() {
		System.setProperty("webdriver.chrome.driver", userDir + "\\browserDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(loginURL);
		basePage = BasePage.getBasePage();
	}
	
	@Test
	public void TC_01_Register_To_System() {
		email = generalEmail("william");

		basePage.click(driver, By.xpath("//a[text() = 'here']"));
		sleepInSeond(2);
		basePage.sendkey(driver, By.cssSelector("input[name='emailid']"), email);
		basePage.click(driver, By.cssSelector("input[name='btnLogin']"));
		sleepInSeond(2);
		userID = basePage.getText(driver, By.xpath("//td[text() = 'User ID :']/following-sibling::td"));
		password = basePage.getText(driver, By.xpath("//td[text() = 'Password :']/following-sibling::td"));
	}
	
	@Test
	public void TC_02_Login_To_System() {
		basePage.getPageUrl(driver, loginURL);
		sleepInSeond(3);
		basePage.sendkey(driver, By.cssSelector("input[name = 'uid']"), userID);
		basePage.sendkey(driver, By.cssSelector("input[name = 'password']"), password);
		basePage.click(driver, By.cssSelector("input[name = 'btnLogin']"));
		sleepInSeond(2);
		Assert.assertEquals(basePage.getText(driver, By.cssSelector("marquee.heading3")), "Welcome To Manager's Page of Guru99 Bank");
	}	

	public void sleepInSeond(long timeInSecond) {
		try {
			Thread.sleep(timeInSecond * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public String generalEmail(String name) {
		Random rand = new Random();
		int num = rand.nextInt(9999);
		return name + num + "@hotmail.com";
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
