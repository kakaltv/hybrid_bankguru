package pageObject.nopCommerce.Admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.Admin.ProductDetailsPageUI;
import pageUIs.nopCommerce.Admin.SearchProductPageUI;

public class SearchProductPageObject extends BasePage {
	private WebDriver driver;
	
	public SearchProductPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void enterToProductNameTextbox(String productName) {
		waitForElementVisible(driver, SearchProductPageUI.PRODUCT_NAME_TEXTBOX);
		sendkeyToElement(driver, SearchProductPageUI.PRODUCT_NAME_TEXTBOX, productName);

	}

	public void clickToSearchButton() {
		waitForElementClickable(driver, SearchProductPageUI.SEARCH_BUTTON);
		clickToElement(driver, SearchProductPageUI.SEARCH_BUTTON);
	
	}

	public ProductDetailsPageObject clickToEditButtonByProducName(String productName) {
		waitForElementVisible(driver, SearchProductPageUI.EDIT_BUTTON_BY_NAME, productName);
		clickToElement(driver, SearchProductPageUI.EDIT_BUTTON_BY_NAME, productName);
	
		return PageGeneratorManager.getProductDetailsPage(driver);
	}

	public boolean isSuccessMessageDisplayed(String successMessage) {
		waitForElementVisible(driver, SearchProductPageUI.SUCCESS_MESSAGE_NAME, successMessage);
		return isElementDisplayed(driver, SearchProductPageUI.SUCCESS_MESSAGE_NAME, successMessage);
	}

	
	public boolean isPictureImageUpdated(String productName1, String productName2) {
		productName2 = productName2.replace(" ", "-").toLowerCase();
		waitForElementVisible(driver, SearchProductPageUI.PRODUCT_IMAGE_BY_PRODUCT_NAME, productName1, productName2);
		return isElementDisplayed(driver, SearchProductPageUI.PRODUCT_IMAGE_BY_PRODUCT_NAME, productName1, productName2);
	}

	
}
