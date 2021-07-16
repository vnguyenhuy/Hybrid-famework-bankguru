package pageUIs.admin.nopcommerce;

import org.openqa.selenium.By;

public class ProductDetailNopCommercePageUIs {
	public static final String CARD_TITLE = "//div[@class='card-title' and text()='%s']";
	public static final String CARD_TITLE_EXPANDED = "//div[@class='card-title' and text()='%s']//following-sibling::div//i";
	public static final String SELECT_FILE_BUTTON = "//div[contains(@id, '%s')]//input[@type='file']";
	public static final String SELECTED_FILE = "//div[@class='upload-picture-block']//img[contains(@src,'%s')]";
	public static final String PICTURE_IMAGE_BY_PIC_ORDER_ALT_TITLE = "//a[contains(@href, '%s')]/parent::td//following-sibling::td[@data-columnname='DisplayOrder' and text()='%s']/following-sibling::td[@data-columnname='OverrideAltAttribute' and text()='%s']/following-sibling::td[@data-columnname='OverrideTitleAttribute' and text() = '%s']";
	public static final String DELETE_IMAGE_BUTTON_BY_TITLE = "//td[text() ='%s']//following-sibling::td//a[text() = 'Delete']";
	public static final String PICTURE_CHECKED_BEFORE_UPLOADED = "//div[@class='upload-picture-block']//img[contains(@src, '%s')]";
	public static final By ALT_TEXTBOX = By.cssSelector("input#AddPictureModel_OverrideAltAttribute");
	public static final By TITLE_TEXTBOX = By.cssSelector("input#AddPictureModel_OverrideTitleAttribute");
//	public static final By DISPLAY_ORDER_TEXTBOX = By.xpath("//label[text() = 'Display order']/ancestor::div[@class='form-group row']//input[@class='k-formatted-value k-input']");
	public static final By DISPLAY_ORDER_TEXTBOX = By.xpath("//input[@id='AddPictureModel_DisplayOrder']/preceding-sibling::input");
	public static final By ADD_PRODUCT_PICTURE_BUTTON = By.cssSelector("button#addProductPicture");	
	public static final By SAVE_BUTTON = By.xpath("//button[@name='save']");	
	
}
