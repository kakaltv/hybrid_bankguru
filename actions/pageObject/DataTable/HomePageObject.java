package pageObject.DataTable;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.DataTable.HomePageUI;

public class HomePageObject extends BasePage {
	private WebDriver driver;

	// Khi new 1 class thì nó sẽ nhảy vào hàm khởi tạo đầu tiên cùng tên với class, ko có kiểu trả v�?, 1 class có thể có nhi�?u hàm khởi tạo -> đa hình
	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void openPageByNumber(String pageNumber) {
		waitForElementVisible(driver, HomePageUI.PAGING_BY_NUMBER, pageNumber);
		clickToElement(driver, HomePageUI.PAGING_BY_NUMBER, pageNumber);
	}

	public boolean isPageActivedNyNumberDisplayed(String pageNumber) {

		return isElementDisplayed(driver, HomePageUI.PAGING_BY_NUMBER_ACTIVE, pageNumber);
	}

	public void inputToHeaderByName(String headerName, String value) {
		waitForElementVisible(driver, HomePageUI.HEADER_TEXTBOX_BY_NAME, headerName);
		sendkeyToElement(driver, HomePageUI.HEADER_TEXTBOX_BY_NAME, value, headerName);
		pressKeyToElement(driver, HomePageUI.HEADER_TEXTBOX_BY_NAME, Keys.ENTER, headerName);

	}

	public void clickToIconByCountryName(String countryName, String iconAction) {
		waitForElementVisible(driver, HomePageUI.ICON_BY_COUNTRY_NAME, countryName, iconAction);
		clickToElement(driver, HomePageUI.ICON_BY_COUNTRY_NAME, countryName, iconAction);

	}

	public boolean isRowValueDisplayed(String females, String country, String males, String total) {
		waitForElementVisible(driver, HomePageUI.ROW_VALUE, females, country, males, total);
		return isElementDisplayed(driver, HomePageUI.ROW_VALUE, females, country, males, total);

	}

	public void inputToTextboxByRowNumber(String headerName, String rowIndex, String value) {
		int columnIndex = getElementSize(driver, HomePageUI.HEADER_NAME_INDEX, headerName) + 1;
		waitForElementVisible(driver, HomePageUI.HEADER_NAME_INDEX, headerName);
		sendkeyToElement(driver, HomePageUI.TEXTBOX_BY_COLUMN_ROW_INDEX, value, rowIndex, String.valueOf(columnIndex));
		
	}

	public void clickToIconByRowNumber(String rowNumber, String buttonTitle) {
		waitForElementVisible(driver, HomePageUI.ACTION_BUTTON_BY_ROW_INDEX, rowNumber, buttonTitle);
		clickToElement(driver,  HomePageUI.ACTION_BUTTON_BY_ROW_INDEX, rowNumber, buttonTitle);
		
		
		
	}

}
