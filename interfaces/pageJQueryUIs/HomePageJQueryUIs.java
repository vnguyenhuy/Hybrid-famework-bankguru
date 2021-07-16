package pageJQueryUIs;

public class HomePageJQueryUIs {
	public static final String PAGING_NUMBER = "//li[@class='qgrd-pagination-page']/a[text() = '%s']";
	public static final String PAGING_NUMBER_ACTIVE = "//li[@class='qgrd-pagination-page']/a[@class = 'qgrd-pagination-page-link active' and text() = '%s']";
	public static final String HEADER_TEXTBOX = "//div[text() = '%s']/parent::div/following-sibling::input";
	public static final String ICON_COUNTRY = "//td[text()='%s']/preceding-sibling::td[@class='qgrd-actions']/button[@class='qgrd-%s-row-btn']";
	public static final String ROW_VALUE_BY_MALE_COUNTRY_FEMALE_TOTAL = "//td[@data-key='females' and text()='%s']/following-sibling::td[@data-key='country' and text()='%s']/following-sibling::td[@data-key='males' and text() ='%s']/following-sibling::td[@data-key='total' and text() = '%s']";
	public static final String HEADER_NAME_INDEX = "//th[text() = '%s']/preceding-sibling::th";
	public static final String TEXTBOX_BY_COLUMN_BY_INDEX = "//tr[%s]/td[%s]/input";
	public static final String ACTION_BUTTON_BY_ROW_INDEX = "//tr[@id][%s]//button[@title='%s']";
	
}
