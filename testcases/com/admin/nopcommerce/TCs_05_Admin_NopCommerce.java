package com.admin.nopcommerce;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObject.admin.nopcommerce.DashboardNopCommercePO;
import pageObject.admin.nopcommerce.LoginNopCommerecePO;
import pageObject.admin.nopcommerce.PONopCommerceGeneratorManage;
import pageObject.admin.nopcommerce.ProductDetailNopCommercePO;
import pageObject.admin.nopcommerce.ProductSearchNopCommercePO;

public class TCs_05_Admin_NopCommerce extends BaseTest{
	private WebDriver driver;
	private DashboardNopCommercePO dashboardPage;
	private LoginNopCommerecePO loginPage;
	private ProductDetailNopCommercePO productDetailPage;
	private ProductSearchNopCommercePO productSearchPage;
	private String productName = "Adobe Photoshop CS4";
	private String productConfigName = "adobe-photoshop-cs4";
	private String uploadedFile = "03.png";
	private String alt = "pandaAlt";
	private String title = "pandaTitle";
	private String order = "0";
	private String panic = "Pictures";
	private String search = "Search";	
	
	@Parameters({"browser", "testingURL"})
	@BeforeClass
	public void initBrowser(String browser, String testingURL) {
		driver = getBrowserDriver(browser, testingURL);
		
		loginPage = PONopCommerceGeneratorManage.getLoginPage(driver);
		
		loginPage.inputToEmailTextbox("admin@yourstore.com");
		loginPage.inputToPasswordTextbox("admin");
		dashboardPage = loginPage.clickToLoginButton();
		
		productSearchPage = (ProductSearchNopCommercePO) dashboardPage.openSubMenuByName(driver, "Catalog", "Products");
		productSearchPage.clickToExpandByName(search);
		productSearchPage.enterToProductNameTextBox("Adobe PhotoShop CS4");
		productSearchPage.clickToSearchButton();
		productDetailPage = productSearchPage.clickToEditButtonByProductName(productName);
	}
	
	@Test
	public void TC_01_Upload_File() {
		productDetailPage.clickToExpandByName(panic);
		productDetailPage.uploadPictureByFileName("pictures", uploadedFile);
		Assert.assertTrue(productDetailPage.isPictureUploadedSuccessByFile(uploadedFile));
		
		productDetailPage.inputToAltTextbox(alt);
		productDetailPage.inputToTitleTextbox(title);
		//productDetailPage.inputToDisplayOrderTextbox(order);
		
		productDetailPage.clickToAddProductPictureButton();
		Assert.assertTrue(productDetailPage.isPictureDisplay(productName, order, alt, title));
		
		productSearchPage = productDetailPage.clickToSaveButton();		
		Assert.assertTrue(productSearchPage.isSuccessfulMessageDisplayed("The product has been updated successfully."));
		
		productSearchPage.enterToProductNameTextBox("Adobe PhotoShop CS4");
		productSearchPage.clickToSearchButton();
		Assert.assertTrue(productSearchPage.isPictureImageUpdated(productName, productConfigName));
		
		productDetailPage = productSearchPage.clickToEditButtonByProductName(productName);
		
		
		productDetailPage.clickToExpandByName(panic);
		productDetailPage.clickToDeleteButtonByTitle(title);
		productDetailPage.clickDeleteAlert("OK");
		//Assert.assertTrue(productDetailPage.isMessageDisplayInTable("No data available in table"));
		
		productSearchPage = productDetailPage.clickToSaveButton();
		productSearchPage.enterToProductNameTextBox(productName);
		productSearchPage.clickToSearchButton();
		Assert.assertTrue(productSearchPage.isPictureImageUpdated(productName, productConfigName));		
		
		
	}
}
