package pageObject.admin.nopcommerce;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.admin.nopcommerce.ProductDetailNopCommercePageUIs;

public class ProductDetailNopCommercePO extends BasePage {
	private WebDriver driver;
	private Alert alert;

	public ProductDetailNopCommercePO(WebDriver driver) {
		this.driver = driver;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void clickToExpandByName(String cardTitle) {
		By cardTitleBy = getDynamicBy(driver, ProductDetailNopCommercePageUIs.CARD_TITLE, cardTitle);
		scrollToElement(driver, cardTitleBy);
		By cardTitleExpandedBy = getDynamicBy(driver, ProductDetailNopCommercePageUIs.CARD_TITLE_EXPANDED, cardTitle);
		String toogleIconStatus = getAttribute(driver, cardTitleExpandedBy, "class");
		if (toogleIconStatus.contains("plus")) {
			click(driver, cardTitleExpandedBy);
		}
	}

	public void uploadPictureByFileName(String cardTitle, String... pictures) {
		By selectBtnBy = getDynamicBy(driver, ProductDetailNopCommercePageUIs.SELECT_FILE_BUTTON, cardTitle);
		waitForElementPresence(driver, selectBtnBy);
		uploadMultipleFiles(driver, selectBtnBy, pictures);
	}

	public boolean isPictureUploadedSuccessByFile(String picture) {
		picture = picture.split("\\.")[0];
		By pictureBy = getDynamicBy(driver, ProductDetailNopCommercePageUIs.PICTURE_CHECKED_BEFORE_UPLOADED, picture);
		waitForElementVisible(driver, pictureBy);
		return isDisplay(driver, pictureBy);
	}

	public void inputToAltTextbox(String alt) {
		waitForElementVisible(driver, ProductDetailNopCommercePageUIs.ALT_TEXTBOX);
		sendkey(driver, ProductDetailNopCommercePageUIs.ALT_TEXTBOX, alt);
	}

	public void inputToDisplayOrderTextbox(String orderNo) {
		//scrollToElement(driver, ProductDetailNopCommercePageUIs.DISPLAY_ORDER_TEXTBOX);
		//sendkeyToElementByJS(driver, ProductDetailNopCommercePageUIs.DISPLAY_ORDER_TEXTBOX, orderNo);
		//sleepInSecond(2);
		click(driver, ProductDetailNopCommercePageUIs.DISPLAY_ORDER_TEXTBOX);
		waitForElementVisible(driver, ProductDetailNopCommercePageUIs.DISPLAY_ORDER_TEXTBOX);
		sendkey(driver, ProductDetailNopCommercePageUIs.DISPLAY_ORDER_TEXTBOX, orderNo);
	}

	public void inputToTitleTextbox(String title) {
		waitForElementVisible(driver, ProductDetailNopCommercePageUIs.TITLE_TEXTBOX);
		sendkey(driver, ProductDetailNopCommercePageUIs.TITLE_TEXTBOX, title);
	}

	public void clickToAddProductPictureButton() {
		waitForElementVisible(driver, ProductDetailNopCommercePageUIs.ADD_PRODUCT_PICTURE_BUTTON);
		click(driver, ProductDetailNopCommercePageUIs.ADD_PRODUCT_PICTURE_BUTTON);
	}

	public boolean isPictureDisplay(String productName, String orderNo, String alt, String title) {
		productName = productName.replace(" ", "-").toLowerCase();
		By tableImageUploaded = getDynamicBy(driver,
				ProductDetailNopCommercePageUIs.PICTURE_IMAGE_BY_PIC_ORDER_ALT_TITLE, productName, orderNo, alt, title);
		return isDisplay(driver, tableImageUploaded);		
	}

	public ProductSearchNopCommercePO clickToSaveButton() {
		scrollToElement(driver, ProductDetailNopCommercePageUIs.SAVE_BUTTON);
		sleepInSecond(2);
		//waitForElementVisible(driver, ProductDetailNopCommercePageUIs.SAVE_BUTTON);
		click(driver, ProductDetailNopCommercePageUIs.SAVE_BUTTON);
		return PONopCommerceGeneratorManage.getProductSearchPage(driver);
	}

	public void clickToDeleteButtonByTitle(String title) {
		By deleteBtnBy = getDynamicBy(driver, ProductDetailNopCommercePageUIs.DELETE_IMAGE_BUTTON_BY_TITLE, title);
		click(driver, deleteBtnBy);
	}

	public void clickDeleteAlert(String buttonName) {
		alert = waitForAlertPresence(driver);
		if (buttonName.equals("OK")) {
			alert.accept();
		} else {
			alert.dismiss();
		}
	}
}
