package pageObjectsJQuery;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageJQueryUIs.HomePageJQueryUIs;

public class HomePageJQueryObject extends BasePage {
	WebDriver driver;
	
	public HomePageJQueryObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebDriver getDriver() {
		return driver;
	}
	
	/*Datatable/Grid*/
	
	public void openDataTablePage(String pageNumber) {
		scrollToElement(driver, HomePageJQueryUIs.PAGING_NUMBER, pageNumber);
		By dynamicLocator = getDynamicBy(driver, HomePageJQueryUIs.PAGING_NUMBER, pageNumber);
		click(driver, dynamicLocator);
	}

	public boolean isPageDataSelected(String pageNumber) {
		By dynamicLocator = getDynamicBy(driver, HomePageJQueryUIs.PAGING_NUMBER_ACTIVE, pageNumber);
		return isDisplay(driver, dynamicLocator);
	}

	public void inputHeaderTextBox(String headerName, String value) {
		By dynamicLocator = getDynamicBy(driver, HomePageJQueryUIs.HEADER_TEXTBOX, headerName);
		waitForElementVisible(driver, dynamicLocator);
		sendkey(driver, dynamicLocator, value);
		pressKeyToElement(driver, dynamicLocator, Keys.ENTER);
	}

	public void clickToIconByCountryName(String country, String action) {		
		By dynamicLocator = getDynamicBy(driver, HomePageJQueryUIs.ICON_COUNTRY, country, action);
		waitForAllElementVisible(driver, dynamicLocator);
		click(driver, dynamicLocator);
	}

	public boolean isRowValueDisplayed(String female, String country, String male, String total) {
		By dynamicLocator = getDynamicBy(driver, HomePageJQueryUIs.ROW_VALUE_BY_MALE_COUNTRY_FEMALE_TOTAL, female, country, male, total);
		
		return isDisplay(driver, dynamicLocator);
	}

	public void inputTextBoxByRowIndex(String headeName, int rowIndex, String value) {
		By headerBy = getDynamicBy(driver, HomePageJQueryUIs.HEADER_NAME_INDEX, headeName);
		int headerIndex = getElementSize(driver, headerBy) + 1;
		By cellBy = getDynamicBy(driver, HomePageJQueryUIs.TEXTBOX_BY_COLUMN_BY_INDEX, String.valueOf(rowIndex), String.valueOf(headerIndex));
		waitForElementVisible(driver, cellBy);
		sendkey(driver, cellBy, value);
		
	}

	public void clickToIconByRowNumber(int i, String iconAction) {
		By icon = getDynamicBy(driver, HomePageJQueryUIs.ACTION_BUTTON_BY_ROW_INDEX, String.valueOf(i), iconAction);
		waitForElementVisible(driver, icon);
		click(driver, icon);
	}

	
}
