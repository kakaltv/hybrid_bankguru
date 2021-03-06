package commons;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObject.nopCommerce.Admin.SearchProductPageObject;
import pageObject.nopCommerce.User.MyAccountPageObject;
import pageObject.nopCommerce.User.MyOrderPageObject;
import pageObject.nopCommerce.User.PageGeneratorManager;
import pageObject.nopCommerce.User.SearchPageObject;
import pageUIs.nopCommerce.Admin.BasePageUIAdmin;
import pageUIsnopCommerceUser.BasePageUIUser;

public class BasePage {

	public static BasePage getBasePage() {
		return new BasePage();
	}

	public void openPageUrl(WebDriver driver, String pageUrl) {
		driver.get(pageUrl);
	}

	public String getPageTitle(WebDriver driver) {
		return driver.getTitle();
	}

	public String getPageUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	public String getPageSource(WebDriver driver) {
		return driver.getPageSource();
	}

	public Alert waitForAlertPresence(WebDriver driver) {
		explicitWait = new WebDriverWait(driver, longTimeout);
		return explicitWait.until(ExpectedConditions.alertIsPresent());
	}

	public void acceptAlert(WebDriver driver) {
		alert = waitForAlertPresence(driver);
		alert.accept();
	}

	public void cancelAlert(WebDriver driver) {
		alert = waitForAlertPresence(driver);
		alert.dismiss();
	}

	public void sendKeyToAlert(WebDriver driver, String value) {
		alert = waitForAlertPresence(driver);
		alert.sendKeys(value);
	}

	public String getAlertText(WebDriver driver) {
		alert = waitForAlertPresence(driver);
		return alert.getText();
	}

	public void switchToWindowByID(WebDriver driver, String parentID) {
		// L???y ra t???t c??? ID c???a window/tab ??ang c??
		Set<String> allwindowID = driver.getWindowHandles();

		// Duy???t qua t???ng ID
		for (String windowID : allwindowID) {
			System.out.println(windowID);

			// N???u window n??o c?? ID kh??c v???i parentID th?? nh???y v??o h??m if
			if (!windowID.equals(parentID)) {

				// Switch v??o 1 window/tab theo ID
				driver.switchTo().window(windowID);
				break;
			}
		}
	}

	public void switchToWindowByTitle(WebDriver driver, String expectedWindowTitle) {
		// L???y ra t???t c??? ID c???a window/tab ??ang c??
		Set<String> allwindowID = driver.getWindowHandles();

		// Duy???t qua t???ng ID
		for (String windowID : allwindowID) {

			// Switch v??o t???ng window/tab tr?????c
			driver.switchTo().window(windowID);

			// Get ra title c???a t???ng window/tab
			String actualWindowTitle = driver.getTitle();

			// Ki???m tra n???u c?? window/tab n??o c?? title b???ng v???i title mong mu???n
			if (actualWindowTitle.equals(expectedWindowTitle)) {

				// Tho??t kh???i v??ng l???p
				break;
			}
		}
	}

	public void closeAllWindowExceptParent(WebDriver driver, String parentID) {
		// L???y ra t???t c??? ID c???a window/tab ??ang c??
		Set<String> allwindowID = driver.getWindowHandles();

		// Duy???t qua t???ng ID
		for (String windowID : allwindowID) {

			// N???u window n??o c?? ID kh??c v???i parentID th?? nh???y v??o h??m if
			if (!windowID.equals(parentID)) {

				// Switch v??o 1 window/tab theo ID
				driver.switchTo().window(windowID);

				// ????ng window/tab ??ang active
				driver.close();
				break;
			}

			// N???u ???? ????ng h???t ch??? c??n parent th?? switch sang parent
			if (driver.getWindowHandles().size() == 1) {
				driver.switchTo().window(parentID);
				break;
			}
		}
	}

	public void sleepInSecond(long timeInSecond) {
		try {
			Thread.sleep(timeInSecond * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void sleepInMilisecond(long timeInMilisecond) {
		try {
			Thread.sleep(timeInMilisecond);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void backToPage(WebDriver driver) {
		driver.navigate().back();
	}

	public void forwardToPage(WebDriver driver) {
		driver.navigate().forward();
	}

	public void refreshPage(WebDriver driver) {
		driver.navigate().refresh();
	}

	public WebElement getElement(WebDriver driver, String locator) {
		return driver.findElement(getByXpath(locator));
	}

	public WebElement getElement(WebDriver driver, String locator, String... params) {
		return driver.findElement(getByXpath(getDynamicLocator(locator, params)));
	}

	public List<WebElement> getElements(WebDriver driver, String locator) {
		return driver.findElements(getByXpath(locator));
	}

	public By getByXpath(String locator) {
		return By.xpath(locator);
	}

	public String getDynamicLocator(String locator, String... params) {
		return String.format(locator, (Object[]) params);
	}

	public void clickToElement(WebDriver driver, String locator) {
		getElement(driver, locator).click();
	}

	public void clickToElement(WebDriver driver, String locator, String... params) {
		getElement(driver, getDynamicLocator(locator, params)).click();
	}

	public void sendkeyToElement(WebDriver driver, String locator, String value) {
		getElement(driver, locator).clear();
		getElement(driver, locator).sendKeys(value);
	}

	public void sendkeyToElement(WebDriver driver, String locator, String value, String... params) {
		locator = getDynamicLocator(locator, params);
		getElement(driver, locator).clear();
		getElement(driver, locator).sendKeys(value);
	}

	public int getElementSize(WebDriver driver, String locator) {
		return getElements(driver, locator).size();
	}

	public int getElementSize(WebDriver driver, String locator, String... params) {
		locator = getDynamicLocator(locator, params);
		return getElements(driver, locator).size();
	}

	public void selectDropdownByText(WebDriver driver, String locator, String itemText) {
		select = new Select(getElement(driver, locator));
		select.selectByVisibleText(itemText);
	}

	public String getSelectedItem(WebDriver driver, String locator) {
		select = new Select(getElement(driver, locator));
		return select.getFirstSelectedOption().getText();
	}

	public boolean isDropdownMultiple(WebDriver driver, String locator) {
		select = new Select(getElement(driver, locator));
		return select.isMultiple();
	}

	public void selectItemInCustomDropdown(WebDriver driver, String parentLocator, String childItemLocator, String expectedItem) {
		// 1 - Click v??o th??? cha ????? x??? ra c??c item con
		getElement(driver, parentLocator).click();
		sleepInSecond(1);

		// 2 - Ch??? cho t???t c??? c??c item con ???????c load ra
		explicitWait = new WebDriverWait(driver, longTimeout);
		List<WebElement> allItems = explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByXpath(childItemLocator)));

		for (WebElement item : allItems) {
			if (item.getText().trim().equals(expectedItem)) {
				jsExecutor = (JavascriptExecutor) driver;
				jsExecutor.executeScript("arguments[0].scrollIntoView(true)", item);
				sleepInSecond(1);

				item.click();
				sleepInSecond(1);
				break;
			}
		}
	}

	public String getElementAttribute(WebDriver driver, String locator, String attName) {
		return getElement(driver, locator).getAttribute(attName);

	}

	public String getElementAttribute(WebDriver driver, String locator, String attName, String... params) {
		return getElement(driver, getDynamicLocator(locator, params)).getAttribute(attName);

	}

	public String getElementText(WebDriver driver, String locator) {
		return getElement(driver, locator).getText();

	}

	public String getElementText(WebDriver driver, String locator, String... params) {
		locator = getDynamicLocator(locator, params);
		return getElement(driver, locator).getText();

	}

	public void checkToCheckboxOrRadioBtn(WebDriver driver, String locator) {
		// N???u ch??a ???????c ch???n th?? m???i click
		if (!isElementSelected(driver, locator)) {
			getElement(driver, locator).click();
		}
	}

	public void uncheckToCheckbox(WebDriver driver, String locator) {
		// N???u ??ang ???????c ch???n th?? un-click
		if (isElementSelected(driver, locator)) {
			getElement(driver, locator).click();
		}
	}

	public boolean isElementDisplayed(WebDriver driver, String locator) {
		return getElement(driver, locator).isDisplayed();
	}

	public boolean isElementDisplayed(WebDriver driver, String locator, String... params) {
		locator = getDynamicLocator(locator, params);
		return getElement(driver, locator).isDisplayed();
	}

	public boolean isElementEnable(WebDriver driver, String locator) {
		return getElement(driver, locator).isEnabled();
	}

	public boolean isElementSelected(WebDriver driver, String locator) {
		return getElement(driver, locator).isSelected();
	}

	public WebDriver switchToIFrameByElement(WebDriver driver, String locator) {
		return driver.switchTo().frame(getElement(driver, locator));
	}

	public WebDriver switchToDefaultContent(WebDriver driver) {
		return driver.switchTo().defaultContent();
	}

	public void hoverToElement(WebDriver driver, String locator) {
		action = new Actions(driver);
		action.moveToElement(getElement(driver, locator)).perform();
	}

	public void doubleClickToElement(WebDriver driver, String locator) {
		action = new Actions(driver);
		action.doubleClick(getElement(driver, locator)).perform();
	}

	public void rightClickToElement(WebDriver driver, String locator) {
		action = new Actions(driver);
		action.contextClick(getElement(driver, locator)).perform();
	}

	public void dragAndDropElement(WebDriver driver, String sourceLocator, String targetLocator) {
		action = new Actions(driver);
		action.dragAndDrop(getElement(driver, sourceLocator), getElement(driver, targetLocator)).perform();
	}

	public void pressKeyToElement(WebDriver driver, String locator, Keys key) {
		action = new Actions(driver);
		action.sendKeys(getElement(driver, locator), key).perform();
	}

	public void pressKeyToElement(WebDriver driver, String locator, Keys key, String... params) {
		action = new Actions(driver);
		locator = getDynamicLocator(locator, params);
		action.sendKeys(getElement(driver, locator), key).perform();
	}

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
		String textActual = (String) jsExecutor.executeScript("return document.documentElement.innerText.match('" + textExpected + "')[0]");
		return textActual.equals(textExpected);
	}

	public void scrollToBottomPage(WebDriver driver) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	public void navigateToUrlByJS(WebDriver driver, String url) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.location = '" + url + "'");
	}

	public void highlightElement(WebDriver driver, String locator) {
		jsExecutor = (JavascriptExecutor) driver;
		WebElement element = getElement(driver, locator);
		String originalStyle = element.getAttribute("style");
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", "border: 2px solid red; border-style: dashed;");
		sleepInSecond(1);
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", originalStyle);
	}

	public void clickToElementByJS(WebDriver driver, String locator) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].click();", getElement(driver, locator));
	}

	public void scrollToElement(WebDriver driver, String locator) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getElement(driver, locator));
//		sleepInMilisecond(500);
	}

	public void sendkeyToElementByJS(WebDriver driver, String locator, String value) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].setAttribute('value', '" + value + "')", getElement(driver, locator));
	}

	public void removeAttributeInDOM(WebDriver driver, String locator, String attributeRemove) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", getElement(driver, locator));
	}

	public boolean areJQueryAndJSLoadedSuccess(WebDriver driver) {
		explicitWait = new WebDriverWait(driver, longTimeout);
		jsExecutor = (JavascriptExecutor) driver;

		ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				try {
					return ((Long) jsExecutor.executeScript("return jQuery.active") == 0);
				} catch (Exception e) {
					return true;
				}
			}
		};

		ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return jsExecutor.executeScript("return document.readyState").toString().equals("complete");
			}
		};

		return explicitWait.until(jQueryLoad) && explicitWait.until(jsLoad);
	}

	public String getElementValidationMessage(WebDriver driver, String locator) {
		jsExecutor = (JavascriptExecutor) driver;
		return (String) jsExecutor.executeScript("return arguments[0].validationMessage;", getElement(driver, locator));
	}

	public boolean isImageLoaded(WebDriver driver, String locator) {
		jsExecutor = (JavascriptExecutor) driver;
		boolean status = (boolean) jsExecutor.executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", getElement(driver, locator));
		if (status) {
			return true;
		} else {
			return false;
		}
	}

	public void waitForElementVisible(WebDriver driver, String locator) {
		explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByXpath(locator)));
	}

	public void waitForElementVisible(WebDriver driver, String locator, String... params) {
		locator = getDynamicLocator(locator, params);
		explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByXpath(locator)));
	}

	public void waitForAllElementsVisible(WebDriver driver, String locator) {
		explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByXpath(locator)));
	}

	public void waitForElementClickable(WebDriver driver, String locator) {
		explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.elementToBeClickable(getByXpath(locator)));
	}

	public void waitForElementClickable(WebDriver driver, String locator, String... params) {
		locator = getDynamicLocator(locator, params);
		explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.elementToBeClickable(getByXpath(locator)));
	}

	public void waitForElementInvisible(WebDriver driver, String locator) {
		explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByXpath(locator)));
	}

	private Alert alert;
	private Select select;
	private Actions action;
	private long longTimeout = GlobalConstants.LONG_TIMEOUT;
	private long shortTimeout = GlobalConstants.SHORT_TIMEOUT;
	private WebDriverWait explicitWait;
	private JavascriptExecutor jsExecutor;

	public SearchPageObject openSearchPage(WebDriver driver) {
		waitForElementVisible(driver, BasePageUIUser.SEARCH_PAGE_FOOTER_LINK);
		clickToElement(driver, BasePageUIUser.SEARCH_PAGE_FOOTER_LINK);
		return PageGeneratorManager.getSearchPage(driver);
	}

	public MyAccountPageObject openMyAccountPage(WebDriver driver) {
		waitForElementVisible(driver, BasePageUIUser.MY_ACCOUNT_PAGE_FOOTER_LINK);
		clickToElement(driver, BasePageUIUser.MY_ACCOUNT_PAGE_FOOTER_LINK);
		return PageGeneratorManager.getMyAccountPage(driver);
	}

	public MyOrderPageObject openMyOrderPage(WebDriver driver) {
		waitForElementVisible(driver, BasePageUIUser.MY_ORDER_PAGE_FOOTER_LINK);
		clickToElement(driver, BasePageUIUser.MY_ORDER_PAGE_FOOTER_LINK);
		return PageGeneratorManager.getMyOrderPage(driver);
	}

	// 1 h??m cho 20 pages s??? d???ng dynamic locator
	// Case 1: S??? page < 10
	public BasePage getFooterPageByPageName(WebDriver driver, String pageName) {
		waitForElementVisible(driver, BasePageUIUser.DYNAMIC_PAGE_FOOTER_LINK, pageName);
		clickToElement(driver, BasePageUIUser.DYNAMIC_PAGE_FOOTER_LINK, pageName);
		switch (pageName) {
		case "Search":
			return PageGeneratorManager.getSearchPage(driver);
		case "Orders":
			return PageGeneratorManager.getMyOrderPage(driver);
		case "My account":
			return PageGeneratorManager.getMyAccountPage(driver);
		default:
			return PageGeneratorManager.getHomePage(driver);
		}
	}

	// Case 2: Multiple Pages
	public void openFooterPageByPageName(WebDriver driver, String pageName) {
		waitForElementVisible(driver, BasePageUIUser.DYNAMIC_PAGE_FOOTER_LINK, pageName);
		clickToElement(driver, BasePageUIUser.DYNAMIC_PAGE_FOOTER_LINK, pageName);

	}

	// nop-commerce admin
	public void openSubMenuPage(WebDriver driver, String menuPageName, String subMenuPageName) {
		waitForElementVisible(driver, BasePageUIAdmin.MENU_LINK_BY_NAME, menuPageName);
		clickToElement(driver, BasePageUIAdmin.MENU_LINK_BY_NAME, menuPageName);
		waitForElementVisible(driver, BasePageUIAdmin.SUB_MENU_LINK_BY_NAME,subMenuPageName);
		clickToElement(driver, BasePageUIAdmin.SUB_MENU_LINK_BY_NAME,subMenuPageName);
	}

	public void uploadFilesByCardName(WebDriver driver, String cardName, String... fileNames) {
		String filePath = GlobalConstants.UPLOAD_FOLDER_PATH;
		String fullFileName = "";
		for (String file : fileNames) {
			fullFileName = fullFileName + filePath + file + "\n";
		}
		fullFileName = fullFileName.trim();
		System.out.println(fullFileName);
		getElement(driver, BasePageUIAdmin.UPLOAD_PRODUCT_BY_CARD_NAME, cardName).sendKeys(fullFileName);
	}

}
