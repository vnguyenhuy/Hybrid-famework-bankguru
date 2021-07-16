package pageObject.admin.nopcommerce;

import org.openqa.selenium.WebDriver;

public class PONopCommerceGeneratorManage {
	private static LoginNopCommerecePO loginPage;
	private static DashboardNopCommercePO dashboardPage;
	private static ProductSearchNopCommercePO productSearchPage;
	private static ProductDetailNopCommercePO productDetailPage;
	
	public static LoginNopCommerecePO getLoginPage(WebDriver driver) {
		if(loginPage == null || !loginPage.getDriver().equals(driver)) {
			loginPage = new LoginNopCommerecePO(driver);
		}
		return loginPage;
	}
	
	public static DashboardNopCommercePO getDashboardPage(WebDriver driver) {
		if(dashboardPage == null || !dashboardPage.getDriver().equals(driver)) {
			dashboardPage = new DashboardNopCommercePO(driver);
		}
		return dashboardPage;
	}
	
	public static ProductSearchNopCommercePO getProductSearchPage(WebDriver driver) {
		if(productSearchPage == null || !productSearchPage.getDriver().equals(driver)) {
			productSearchPage = new ProductSearchNopCommercePO(driver);
		}
		return productSearchPage;
	}
	
	public static ProductDetailNopCommercePO getProductDetailPage(WebDriver driver) {
		if(productDetailPage == null || !productDetailPage.getDriver().equals(driver)) {
			productDetailPage = new ProductDetailNopCommercePO(driver);
		}
		return productDetailPage;
	}
	
	
}
