package pageUIs.admin.nopcommerce;

import org.openqa.selenium.By;

public class ProductSearchNopCommercePageUIs {
	public static final By PRODUCT_NAME_TEXTBOX = By.cssSelector("#SearchProductName");
	public static final By SEARCH_BUTTON = By.cssSelector("button#search-products");
	public static final String EDIT_PRODUCT_DETAIL_BUTTON = "//td[text()='%s']//following-sibling::td/a[text()='Edit']";
	public static final String PRODUCT_UPDATE = "//div[@class = 'alert alert-success alert-dismissable' and contains(string(), '%s')]";
	public static final String PRODUCT_UPDATE_SELECTED = "//td[text() = '%s']/preceding-sibling::td/img[contains(@src,'%s')]";
	public static final String SEARCH_PANEL = "//div[@class='search-text' and text() = 'Search']/parent::div";
	
}
