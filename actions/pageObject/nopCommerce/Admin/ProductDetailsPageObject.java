package pageObject.nopCommerce.Admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import io.qameta.allure.Step;
import pageUIs.nopCommerce.Admin.ProductDetailsPageUI;
import pageUIs.nopCommerce.Admin.SearchProductPageUI;

public class ProductDetailsPageObject extends BasePage {
	private WebDriver driver;

	public ProductDetailsPageObject(WebDriver driver) {
		this.driver = driver;
	}

	@Step("1. Click to expand panel by name: {0}")
	public void clickToExpandPanelByName(String panelName) {
		// 1. Get tag i attribute
		waitForElementClickable(driver, ProductDetailsPageUI.TOOGLE_ICON_BY_CARD_NAME, panelName);
		String toogleIconStatus = getElementAttribute(driver, ProductDetailsPageUI.TOOGLE_ICON_BY_CARD_NAME, "class", panelName);
		// 2. if contain fa-plus -> click
		if (toogleIconStatus.contains("fa-plus")) {
			clickToElement(driver, ProductDetailsPageUI.TOOGLE_ICON_BY_CARD_NAME, panelName);
		}

		// 3. if not contain fa-plus -> ko lam j

	}

	@Step("Verify Picture Uploaded success by file name {0}")
	public boolean isPictureUploadedSuccessByFilename(String fileName) {
		fileName = fileName.split("\\.")[0];
		waitForElementVisible(driver, ProductDetailsPageUI.PRODUCT_IMAGE_ADD_NEW_BY_FILE_NAME, fileName);

		return isElementDisplayed(driver, ProductDetailsPageUI.PRODUCT_IMAGE_ADD_NEW_BY_FILE_NAME, fileName);
	}

	@Step("Enter to Alt textbox {0}")
	public void enterToAltTextbox(String alt) {
		waitForElementVisible(driver, ProductDetailsPageUI.ALT_TEXTBOX_ADD_NEW);
		sendkeyToElement(driver, ProductDetailsPageUI.ALT_TEXTBOX_ADD_NEW, alt);

	}

	@Step("Enter to Title textbox {0}")
	public void enterToTitleTextbox(String title) {
		waitForElementVisible(driver, ProductDetailsPageUI.TITLE_TEXTBOX_ADD_NEW);
		sendkeyToElement(driver, ProductDetailsPageUI.TITLE_TEXTBOX_ADD_NEW, title);

	}

	@Step("Enter to Oder textbox {0}")
	public void enterToDisplayOrderTextbox(String order) {
		waitForElementVisible(driver, ProductDetailsPageUI.DISPLAY_ORDER_ADD_NEW);
		getElement(driver, ProductDetailsPageUI.DISPLAY_ORDER_ADD_NEW).sendKeys(order);

	}

	@Step("Click to Add Product Picture button")
	public void clickToAddProductPictureButton() {
		waitForElementVisible(driver, ProductDetailsPageUI.ADD_PRODUCT_PICTURE_BUTTON_ADD_NEW);
		clickToElement(driver, ProductDetailsPageUI.ADD_PRODUCT_PICTURE_BUTTON_ADD_NEW);

	}

	public boolean isPictureImageDisplayed(String imgName, String imgOrder, String imgAlt, String imgTitle) {
		imgName = imgName.replace(" ", "-").toLowerCase();
		System.out.println(getElement(driver, ProductDetailsPageUI.PICTURE_TABLE_BY_NAME_ALT_TITLE, imgName, imgOrder, imgAlt, imgTitle));
		waitForElementVisible(driver, ProductDetailsPageUI.PICTURE_TABLE_BY_NAME_ALT_TITLE, imgName, imgOrder, imgAlt, imgTitle);
		return isElementDisplayed(driver, ProductDetailsPageUI.PICTURE_TABLE_BY_NAME_ALT_TITLE, imgName, imgOrder, imgAlt, imgTitle);
	}

	public SearchProductPageObject clickToSaveButton() {
		waitForElementClickable(driver, ProductDetailsPageUI.SAVE_BUTTON);
		clickToElement(driver, ProductDetailsPageUI.SAVE_BUTTON);
		return PageGeneratorManager.getSearchProductPage(driver);

	}

	public void clickToDeleteButtonAtProductTitle(String imgTitle) {
		waitForElementVisible(driver, ProductDetailsPageUI.DELETE_PICTURE_BUTTON_BY_IMAGE_TITLE, imgTitle);
		clickToElement(driver, ProductDetailsPageUI.DELETE_PICTURE_BUTTON_BY_IMAGE_TITLE, imgTitle);
		acceptAlert(driver);
	}

	public boolean isNoDataMessageDisplayedInTable(String tableName) {
		waitForElementVisible(driver, ProductDetailsPageUI.NO_DATA_MESSAGE_BY_TABLE_NAME, tableName);
		return isElementDisplayed(driver, ProductDetailsPageUI.NO_DATA_MESSAGE_BY_TABLE_NAME, tableName);
	}

}
