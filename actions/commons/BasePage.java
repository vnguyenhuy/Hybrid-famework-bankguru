package commons;

import java.io.File;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObject.admin.nopcommerce.PONopCommerceGeneratorManage;
import pageObjects.liveguru.LoginPageLiveGuruObject;
import pageObjects.liveguru.OrdersAndReturnsLiveGuruObject;
import pageObjects.liveguru.PageObjectLiveGuruGeneratorManager;
import pageObjects.liveguru.SearchTermsLiveGuruObject;
import pageObjects.liveguru.SiteMapLiveGuruObject;
import pageUIs.admin.nopcommerce.BasePageNopCommerceUIs;
import pageUIs.liveguru.BasePageLiveGuruUIs;

public class BasePage {	
	private Alert alert;
	private Select select;
	private Actions action;
	private WebDriverWait explicitWait;
	private JavascriptExecutor jsExecutor;
	private int explicitTimeout = GlobalConstant.LONG_TIMEOUT;
	
	public static BasePage getBasePage() {
		return new BasePage();
	}
	public void getPageUrl(WebDriver driver, String pageUrl) {
		driver.get(pageUrl);
	}
	
	public String getPageTitle(WebDriver driver) {
		return driver.getTitle();
	}
	
	public int getElementSize(WebDriver driver, By locator) {
		List<WebElement> elements = getElements(driver, locator);
		return elements.size();
	}

	public By getByXpath(WebDriver driver, String xpath) {
		return By.xpath(xpath);
	}
	
	public By getByCss(WebDriver driver, String css) {
		return By.cssSelector(css);
	}
	
	public By convertStringToBy(WebDriver driver, String locator) {
		if(locator.contains("//")) {
			return getByXpath(driver, locator);
		}
		else {
			return getByCss(driver, locator);
		}
	}
	
	public String getDynamicLocator(WebDriver driver, String locator, String... elements) {
		return String.format(locator, (Object[]) elements);
	}
	
	public By getDynamicBy(WebDriver driver, String locator, String... elements) {
		String dynamicLocator = getDynamicLocator(driver, locator, elements);		
		return convertStringToBy(driver, dynamicLocator);
	}
	
	public WebElement getElement(WebDriver driver, By by) {		
		return driver.findElement(by);
	}
	
	public List<WebElement> getElements(WebDriver driver, By by) {
		return driver.findElements(by);
	}
	
	public void click(WebDriver driver, By by) {
		getElement(driver, by).click();		
	}
	
	public void click(WebDriver driver, String locator, String... params) {
		By dynamicElement = getDynamicBy(driver, locator, params);
		getElement(driver, dynamicElement).click();		
	}
	
	public void sendkey(WebDriver driver, By by, String text) {
		getElement(driver, by).clear();
		getElement(driver, by).sendKeys(text);
	}
	
	public void sendkeyWithoutClear(WebDriver driver, By by, String text) {
		getElement(driver, by).sendKeys(text);
	}
	
	public void sendkey(WebDriver driver, String locator, String text, String... params) {
		By dynamicElement = getDynamicBy(driver, locator, params);
		getElement(driver, dynamicElement).clear();
		getElement(driver, dynamicElement).sendKeys(text);
	}
	
	public boolean isSelected(WebDriver driver, By by) {
		return getElement(driver, by).isSelected();
	}
	
	public boolean isEnable(WebDriver driver, By by) {
		return getElement(driver, by).isEnabled();
	}
	
	public boolean isDisplay(WebDriver driver, By by) {
		
		try {
			return getElement(driver, by).isDisplayed();	
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
	public boolean isUndisplayed(WebDriver driver, By by) {
		overrideGlobalTimeout(driver, GlobalConstant.SHORT_TIMEOUT);
		List<WebElement> elements = getElements(driver, by);
		overrideGlobalTimeout(driver, GlobalConstant.LONG_TIMEOUT);
		
		if(elements.size() == 0) {
			System.out.println("Element not in DOM and not visible");
			return true;
		} 
		else if(elements.size() > 0 && !elements.get(0).isDisplayed()) {
			System.out.println("Element in DOM but not visible");
			return true;
		} 
		else {
			System.out.println("Element in DOM and visible");
			return false;
		}
	}
	
	public void overrideGlobalTimeout(WebDriver driver, int timeout) {
		driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
	} 
	
	public String getText(WebDriver driver, By by) {
		return getElement(driver, by).getText();
	}
	public boolean isSelected(WebDriver driver, String locator, String... params) {
		By dynamicElement = getDynamicBy(driver, locator, params);
		return getElement(driver, dynamicElement).isSelected();
	}

	public boolean isEnable(WebDriver driver, String locator, String... params) {
		By dynamicElement = getDynamicBy(driver, locator, params);
		return getElement(driver, dynamicElement).isEnabled();
	}

	public boolean isDisplay(WebDriver driver, String locator, String... params) {
		By dynamicElement = getDynamicBy(driver, locator, params);
		return getElement(driver, dynamicElement).isDisplayed();
	}
	
	public String getText(WebDriver driver, String locator, String... params) {
		By dynamicElement = getDynamicBy(driver, locator, params);
		return getElement(driver, dynamicElement).getText();
	}
	
	public String getAttribute(WebDriver driver, By by, String attribute) {
		return getElement(driver, by).getAttribute(attribute);
	}
	
	public void refresh(WebDriver driver) {
		driver.navigate().refresh();
	}
	
	public void back(WebDriver driver) {
		driver.navigate().back();
	}
	
	public void forward(WebDriver driver) {
		driver.navigate().forward();
	}	
	
	public String getPageSource(WebDriver driver) {
		return driver.getPageSource();
	}
	
	public Alert waitForAlertPresence(WebDriver driver) {
		explicitWait = new WebDriverWait(driver, explicitTimeout);
		return explicitWait.until(ExpectedConditions.alertIsPresent());
	}
	
	public void acceptAlert(WebDriver driver) {
		alert = driver.switchTo().alert();
		alert.accept();
	}
	
	public void cancelAlert(WebDriver driver) {
		alert = driver.switchTo().alert();
		alert.dismiss();
	}
	
	public void sendKeyToAlert(WebDriver driver, String value) {
		alert = driver.switchTo().alert();
		alert.sendKeys(value);
	}
	
	public String getAlertText(WebDriver driver) {
		alert = driver.switchTo().alert();
		return alert.getText();
	}
	
	public void closeAllWindowExceptParent(WebDriver driver, String parentID) {
		Set<String> windowIDs = driver.getWindowHandles();
		
		for(String windowID: windowIDs) {
			if(!windowID.equals(parentID)) {
				driver.switchTo().window(windowID);
				driver.close();
				sleepInSecond(1);
			}
			
			if(windowIDs.size() == 1) {
				driver.switchTo().window(parentID);
				break;
			}
		}
	}
	
	public void switchToWindowByTitle(WebDriver driver, String expectedWindowTitle) {
		Set<String> windowIDs = driver.getWindowHandles();
		
		for(String windowID : windowIDs) {
			String currentTitle = driver.switchTo().window(windowID).getTitle();
			if(currentTitle.equals(expectedWindowTitle)) {
				break;
			}
		}
	}
	
	public void swithcToWindowByID(WebDriver driver, String expectedID) {
		Set<String> windowIDs = driver.getWindowHandles();
		
		for(String windowID : windowIDs) {
			if(windowID.equals(expectedID)) {
				driver.switchTo().window(windowID);
				break;
			}
		}
	}

	public void selectDropDownByText(WebDriver driver, By locator, String expectedItem) {
		select = new Select(getElement(driver, locator));
		select.selectByVisibleText(expectedItem);
	}
	
	public void selectItemCustomDropDown(WebDriver driver, By parentLocator, By childrenLocator, String expectedItem) {
		click(driver, parentLocator);
		
		explicitWait = new WebDriverWait(driver, explicitTimeout);
		List<WebElement> childItems = explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(childrenLocator));				
		
		jsExecutor = (JavascriptExecutor) driver;
		for (WebElement childItem : childItems) {
			if(childItem.getText().trim().equals(expectedItem)) {
				jsExecutor.executeScript("arguments[0].scrollIntoView(true);", childItem);
				sleepInSecond(2);
				childItem.click();
				sleepInSecond(1);
				break;
			}
		}
	}
	
	public String getSelectedDropDownItem(WebDriver driver, By locator) {
		select = new Select(getElement(driver, locator));
		return select.getFirstSelectedOption().getText();
	}
	
	public boolean isDropDownMultiple(WebDriver driver, By locator) {
		select = new Select(getElement(driver, locator));
		return select.isMultiple();
	}
	
	public void checkToCheckboxOrRadio(WebDriver driver, By locator) {
		if(!isSelected(driver, locator)) {
			click(driver, locator);
		}
	}
	
	public void checkToCheckboxOrRadio(WebDriver driver, String locator, String... params) {
		if(!isSelected(driver, locator, params)) {
			click(driver, locator);
		}
	}
	
	public void unCheckToCheckbox(WebDriver driver, By locator) {
		if(isSelected(driver, locator)) {
			click(driver, locator);
		}
	}
	
	public void unCheckToCheckbox(WebDriver driver, String locator, String... params) {
		if(isSelected(driver, locator, params)) {
			click(driver, locator);
		}
	}

	public WebDriver switchToFrameByElement(WebDriver driver, By locator) {
		return driver.switchTo().frame(getElement(driver, locator));
	}
	
	public WebDriver switchToDefaultContentByElement(WebDriver driver, By locator) {
		return driver.switchTo().defaultContent();
	}
	
	public void hoverToElement(WebDriver driver, By locator) {
		action = new Actions(driver);
		action.moveToElement(getElement(driver, locator)).perform();
	}
	
	public void doubleClickToElement(WebDriver driver, By locator) {
		action = new Actions(driver);
		action.doubleClick(getElement(driver, locator)).perform();
	}
	
	public void rightClickToElement(WebDriver driver, By locator) {
		action = new Actions(driver);
		action.contextClick(getElement(driver, locator)).perform();
	}
	
	public void drapAndDropElement(WebDriver driver, By sourceLocator, By targetLocator) {
		action = new Actions(driver);
		action.dragAndDrop(getElement(driver, sourceLocator), getElement(driver, targetLocator)).perform();
	}
	
	public void pressKeyToElement(WebDriver driver, By locator, Keys key) {
		action = new Actions(driver);
		action.sendKeys(getElement(driver, locator), key).perform();
	}
	
	public void uploadMultipleFiles(WebDriver driver, By locator, String... files) {
		String fulFiles = "";
		for (int i = 0; i < files.length; i++) {
			
			fulFiles = fulFiles + GlobalConstant.UPLOAD_DIR + File.separator + files[i];
			if(i < files.length - 1) {
				fulFiles = fulFiles + "\n";
			}
		}
		fulFiles.trim().replace("\n", "");
		sendkeyWithoutClear(driver, locator, fulFiles);		
	}
	
	/*Java Script executor*/
	
	public Object executeForBrowser(WebDriver driver, String javaScript) {
		jsExecutor = (JavascriptExecutor) driver;
		return jsExecutor.executeScript(javaScript);
	}

	public String getInnerText(WebDriver driver) {
		jsExecutor = (JavascriptExecutor) driver;
		return (String) jsExecutor.executeScript("return document.documentElement.innerText;");
	}

	public boolean areExpectedTextInInnerText(WebDriver driver, String textExpected) {
		jsExecutor = (JavascriptExecutor) driver;
		String textActual = (String) jsExecutor.executeScript("return document.documentElement.innerText.match('" + textExpected + "')[0];");
		return textActual.equals(textExpected);
	}

	//useful
	public void scrollToBottomPage(WebDriver driver) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	public void navigateToUrlByJS(WebDriver driver, String url) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.location = '" + url + "'");
	}

	//useful
	public void highlightElement(WebDriver driver, By locator) {
		jsExecutor = (JavascriptExecutor) driver;
		WebElement element = getElement(driver, locator);
		String originalStyle = element.getAttribute("style");
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", "border: 2px solid red; border-style: dashed;");
		sleepInSecond(1);
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", originalStyle);
	}

	//useful
	public void clickToElementByJS(WebDriver driver, By locator) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].click();", getElement(driver, locator));
	}

	//useful
	public void scrollToElement(WebDriver driver, By locator) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getElement(driver, locator));
	}
	
	public void scrollToElement(WebDriver driver, String locator, String... params) {
		By dynamicLocator = getDynamicBy(driver, locator, params);
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getElement(driver, dynamicLocator));
	}

	public void sendkeyToElementByJS(WebDriver driver, By locator, String value) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].value = " + '"' + value + '"' + ';', getElement(driver, locator));
		sleepInSecond(1);
	}

	
	public String getTextByJS(WebDriver driver, By locator) {
		  jsExecutor = (JavascriptExecutor) driver;
		  String text = jsExecutor.executeScript("return arguments[0].innerText;", getElement(driver, locator)).toString();
		  return text;
	  }	 
	
	public void removeAttributeInDOM(WebDriver driver, By locator, String attributeRemove) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", getElement(driver, locator));
	}

	//useful
	public String getElementValidationMessage(WebDriver driver, By locator) {
		jsExecutor = (JavascriptExecutor) driver;
		return (String) jsExecutor.executeScript("return arguments[0].validationMessage;", getElement(driver, locator));
	}

	//useful
	public boolean isImageLoaded(WebDriver driver, By locator) {
		jsExecutor = (JavascriptExecutor) driver;
		boolean status = (boolean) jsExecutor.executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", getElement(driver, locator));
		if (status) {
			return true;
		} else {
			return false;
		}
	}
	
	/*Wait*/
	
	public void waitForElementPresence(WebDriver driver, By locator) {
		explicitWait = new WebDriverWait(driver, explicitTimeout);
		explicitWait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	
	public void waitForElementVisible(WebDriver driver, By locator) {
		explicitWait = new WebDriverWait(driver, explicitTimeout);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	public void waitForElementVisible(WebDriver driver, String locator, String... params) {
		By dynamicLocator = getDynamicBy(driver, locator, params);
		explicitWait = new WebDriverWait(driver, explicitTimeout);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(dynamicLocator));
	}
	
	public void waitForElementInvisible(WebDriver driver, By locator) {
		explicitWait = new WebDriverWait(driver, GlobalConstant.SHORT_TIMEOUT);
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
	}
	
	public void waitForElementInvisible(WebDriver driver, String locator, String... params) {
		By dynamicLocator = getDynamicBy(driver, locator, params);
		explicitWait = new WebDriverWait(driver, GlobalConstant.SHORT_TIMEOUT);
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(dynamicLocator));
	}
	
	public void waitForAllElementVisible(WebDriver driver, By locator) {
		explicitWait = new WebDriverWait(driver, explicitTimeout);
		explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	}		
	
	public void waitForAllElementVisible(WebDriver driver, String locator, String... params) {
		By dynamicLocator = getDynamicBy(driver, locator, params);
		explicitWait = new WebDriverWait(driver, explicitTimeout);
		explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(dynamicLocator));
	}		
	
	public void waitForElementClickable(WebDriver driver, By locator) {
		explicitWait = new WebDriverWait(driver, explicitTimeout);
		explicitWait.until(ExpectedConditions.elementToBeClickable(locator));
	}
	
	public void waitForElementClickable(WebDriver driver, String locator, String... params) {
		By dynamicLocator = getDynamicBy(driver, locator, params);
		explicitWait = new WebDriverWait(driver, explicitTimeout);
		explicitWait.until(ExpectedConditions.elementToBeClickable(dynamicLocator));
	}
	
	public void sleepInSecond(long timeInSecond) {
		try {
			Thread.sleep(timeInSecond*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/*Common Live Guru pages*/
	
	public LoginPageLiveGuruObject openLoginPageLiveGuru(WebDriver driver) {
		scrollToElement(driver, BasePageLiveGuruUIs.MY_ACCOUNT_FOOTER);
		waitForElementClickable(driver, BasePageLiveGuruUIs.MY_ACCOUNT_FOOTER);
		click(driver, BasePageLiveGuruUIs.MY_ACCOUNT_FOOTER);
		return PageObjectLiveGuruGeneratorManager.getLoginPage(driver);
	}
	
	public SearchTermsLiveGuruObject openSearchTermsLiveGuru(WebDriver driver) {
		scrollToElement(driver, BasePageLiveGuruUIs.SEARCH_TERMS_FOOTER);
		waitForElementClickable(driver, BasePageLiveGuruUIs.SEARCH_TERMS_FOOTER);
		click(driver, BasePageLiveGuruUIs.SEARCH_TERMS_FOOTER);
		return PageObjectLiveGuruGeneratorManager.getSearchTermsLiveGuru(driver);
	}
	
	public OrdersAndReturnsLiveGuruObject openOrdersAndReturnsLiveGuru(WebDriver driver) {
		scrollToElement(driver, BasePageLiveGuruUIs.ORDERS_AND_RETURNS_FOOTER);
		waitForElementClickable(driver, BasePageLiveGuruUIs.ORDERS_AND_RETURNS_FOOTER);
		click(driver, BasePageLiveGuruUIs.ORDERS_AND_RETURNS_FOOTER);
		return PageObjectLiveGuruGeneratorManager.getOrdersAndReturnsLiveGuru(driver);
	}
	
	public SiteMapLiveGuruObject openSiteMapLiveGuru(WebDriver driver) {
		scrollToElement(driver, BasePageLiveGuruUIs.SITE_MAP_FOOTER);
		waitForElementClickable(driver, BasePageLiveGuruUIs.SITE_MAP_FOOTER);
		click(driver, BasePageLiveGuruUIs.SITE_MAP_FOOTER);
		return PageObjectLiveGuruGeneratorManager.getSiteMapLiveGuru(driver);
	}			
	
	/*Dynamic Locator Footer LiveGuru*/	
	public void getFooterPageByName(WebDriver driver, String pageName) {
		waitForElementClickable(driver, BasePageLiveGuruUIs.DYNAMIC_PAGE_FOOTER, pageName);
		click(driver, BasePageLiveGuruUIs.DYNAMIC_PAGE_FOOTER, pageName);
	}
	
	public BasePage openFooterPageByName(WebDriver driver, String pageName) {
		waitForElementClickable(driver, BasePageLiveGuruUIs.DYNAMIC_PAGE_FOOTER, pageName);
		click(driver, BasePageLiveGuruUIs.DYNAMIC_PAGE_FOOTER, pageName);
		
		switch (pageName) {
		case "My Account":
			return PageObjectLiveGuruGeneratorManager.getLoginPage(driver);			
		case "Search Terms":
			return PageObjectLiveGuruGeneratorManager.getSearchTermsLiveGuru(driver);			
		case "Orders and Returns":
			return PageObjectLiveGuruGeneratorManager.getOrdersAndReturnsLiveGuru(driver);			
		case "Site Map":
			return PageObjectLiveGuruGeneratorManager.getSiteMapLiveGuru(driver);
		default:
			throw new RuntimeException("the page's name is wrong");
			
		}
	}
	
	/*Dynamic locator sideMenu admin Nop commerce*/
	
	public BasePage openSubMenuByName(WebDriver driver, String MenuItem, String subItem) {
		By MenuItemBy = getDynamicBy(driver, BasePageNopCommerceUIs.SIDE_MENU_OPENED, MenuItem);
		waitForElementVisible(driver, MenuItemBy);
		click(driver, MenuItemBy);
		
		By subItemBy = getDynamicBy(driver, BasePageNopCommerceUIs.SUB_MENU_ITEM, subItem);
		waitForElementVisible(driver, subItemBy);
		click(driver, subItemBy);		
		
		switch (subItem) {
		case "Products":
			return PONopCommerceGeneratorManage.getProductSearchPage(driver);			
		default:
			throw new RuntimeException("the page's name is wrong");
		}				
	}
}