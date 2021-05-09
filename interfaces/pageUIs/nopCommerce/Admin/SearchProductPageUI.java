package pageUIs.nopCommerce.Admin;

public class SearchProductPageUI {
	public static final String PRODUCT_NAME_TEXTBOX = "//input[@id='SearchProductName']";
	public static final String SEARCH_BUTTON = "//button[@id='search-products']";
	public static final String EDIT_BUTTON_BY_NAME = "//td[text()='%s']/following-sibling::td/a[text()='Edit']";
	public static final String SUCCESS_MESSAGE_NAME = "//div[contains(@class,'alert-success') and contains(string(),'%s')]";
	public static final String PRODUCT_IMAGE_BY_PRODUCT_NAME = "//td[text()='%s']/preceding-sibling::td/img[contains(@src,'%s')]";
	
}
