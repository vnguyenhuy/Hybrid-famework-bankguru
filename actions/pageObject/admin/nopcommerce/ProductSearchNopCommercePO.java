package pageObject.admin.nopcommerce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.admin.nopcommerce.ProductDetailNopCommercePageUIs;
import pageUIs.admin.nopcommerce.ProductSearchNopCommercePageUIs;

public class ProductSearchNopCommercePO extends BasePage{	
	private WebDriver driver;
	
	public ProductSearchNopCommercePO(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebDriver getDriver() {
		return driver;
	}

	public void enterToProductNameTextBox(String productName) {
		waitForElementVisible(driver, ProductSearchNopCommercePageUIs.PRODUCT_NAME_TEXTBOX);
		sendkey(driver, ProductSearchNopCommercePageUIs.PRODUCT_NAME_TEXTBOX, productName);		
	}

	public void clickToSearchButton() {
		waitForElementVisible(driver, ProductSearchNopCommercePageUIs.SEARCH_BUTTON);
		click(driver, ProductSearchNopCommercePageUIs.SEARCH_BUTTON);		
	}

	public ProductDetailNopCommercePO clickToEditButtonByProductName(String productName) {
		By editBtnBy = getDynamicBy(driver, ProductSearchNopCommercePageUIs.EDIT_PRODUCT_DETAIL_BUTTON, productName);
		waitForElementVisible(driver, editBtnBy);
		click(driver, editBtnBy);	
		return PONopCommerceGeneratorManage.getProductDetailPage(driver);
	}

	public boolean isSuccessfulMessageDisplayed(String message) {
		By messageBy = getDynamicBy(driver, ProductSearchNopCommercePageUIs.PRODUCT_UPDATE, message);
		waitForElementVisible(driver, messageBy);
		return isDisplay(driver, messageBy);
	}

	public boolean isPictureImageUpdated(String productName, String productConfig) {
		//productConfig = productName.replace(" ", "-").toLowerCase();
		By productSelectedBy = getDynamicBy(driver, ProductSearchNopCommercePageUIs.PRODUCT_UPDATE_SELECTED, productName, productConfig);
		scrollToElement(driver, productSelectedBy);
		sleepInSecond(2);
		
		return isDisplay(driver, productSelectedBy);
	}

	public void clickToExpandByName(String search) {
		By cardTitleBy = getDynamicBy(driver, ProductSearchNopCommercePageUIs.SEARCH_PANEL);
		String toogleIconStatus = getAttribute(driver, cardTitleBy, "class");
		if (!toogleIconStatus.contains("opened")) {
			click(driver, cardTitleBy);
		}
	}
}
