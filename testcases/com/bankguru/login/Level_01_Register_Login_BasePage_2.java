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

public class Level_01_Register_Login_BasePage_2 extends BasePage{
	WebDriver driver;
	String userDir = System.getProperty("user.dir");
	String loginURL = "http://demo.guru99.com/v4";
	String email;
	String userID;
	String password;		
	
	@BeforeClass
	public void initBrowser() {
		System.setProperty("webdriver.chrome.driver", userDir + "\\browserDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(loginURL);		
	}
	
	@Test
	public void TC_01_Register_To_System() {
		email = generalEmail("william");

		click(driver, By.xpath("//a[text() = 'here']"));
		sleepInSeond(2);
		sendkey(driver, By.cssSelector("input[name='emailid']"), email);
		click(driver, By.cssSelector("input[name='btnLogin']"));
		sleepInSeond(2);
		userID = getText(driver, By.xpath("//td[text() = 'User ID :']/following-sibling::td"));
		password = getText(driver, By.xpath("//td[text() = 'Password :']/following-sibling::td"));
	}
	
	@Test
	public void TC_02_Login_To_System() {
		getPageUrl(driver, loginURL);
		sleepInSeond(3);
		sendkey(driver, By.cssSelector("input[name = 'uid']"), userID);
		sendkey(driver, By.cssSelector("input[name = 'password']"), password);
		click(driver, By.cssSelector("input[name = 'btnLogin']"));
		sleepInSeond(2);
		Assert.assertEquals(getText(driver, By.cssSelector("marquee.heading3")), "Welcome To Manager's Page of Guru99 Bank");
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
