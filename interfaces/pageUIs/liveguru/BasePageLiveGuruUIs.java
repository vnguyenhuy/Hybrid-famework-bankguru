package pageUIs.liveguru;

import org.openqa.selenium.By;

public class BasePageLiveGuruUIs {
	public static final By MY_ACCOUNT_FOOTER = By.xpath("//div[@class='footer']//a[text() = 'My Account']");
	public static final By SEARCH_TERMS_FOOTER = By.xpath("//div[@class='footer']//a[text() = 'Search Terms']");
	public static final By ORDERS_AND_RETURNS_FOOTER = By.xpath("//div[@class='footer']//a[text() = 'Orders and Returns']");
	public static final By SITE_MAP_FOOTER = By.xpath("//div[@class='footer']//a[text() = 'Site Map']");
	public static final String DYNAMIC_PAGE_FOOTER = "//div[@class='footer']//a[text() = '%s']";
}