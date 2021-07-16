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

public class Level_01_Register_Login_Repeat_Yourself {
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

		click(By.xpath("//a[text() = 'here']"));
		sleepInSeond(2);
		sendKey(By.cssSelector("input[name='emailid']"), email);
		click(By.cssSelector("input[name='btnLogin']"));
		sleepInSeond(2);
		userID = getText(By.xpath("//td[text() = 'User ID :']/following-sibling::td"));
		password = getText(By.xpath("//td[text() = 'Password :']/following-sibling::td"));
	}
	
	@Test
	public void TC_02_Login_To_System() {
		driver.get(loginURL);
		sleepInSeond(3);
		sendKey(By.cssSelector("input[name = 'uid']"), userID);
		sendKey(By.cssSelector("input[name = 'password']"), password);
		click(By.cssSelector("input[name = 'btnLogin']"));
		sleepInSeond(2);
		Assert.assertEquals(getText(By.cssSelector("marquee.heading3")), "Welcome To Manager's Page of Guru99 Bank");
	}
	
	public void click(By by) {
		driver.findElement(by).click();
	}

	public void sendKey(By by, String string) {
		driver.findElement(by).sendKeys(string);
	}

	public void clear(By by) {
		driver.findElement(by).clear();
	}

	public boolean isEnabled(By by) {
		if (driver.findElement(by).isEnabled()) {
			System.out.println("The element is enable");
			return true;
		} else {
			System.out.println("The element is enable");
			return false;
		}
	}

	public boolean isDisplayed(By by) {
		if (driver.findElement(by).isDisplayed()) {
			System.out.println("The element is displayed");
			return true;
		} else {
			System.out.println("The element is displayed");
			return false;
		}
	}

	public boolean isSelected(By by) {
		if (driver.findElement(by).isSelected()) {
			System.out.println("The element is selected");
			return true;
		} else {
			System.out.println("The element is selected");
			return false;
		}
	}

	public String getText(By by) {
		return driver.findElement(by).getText();
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
