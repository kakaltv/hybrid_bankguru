package pageUIsnopCommerceUser;

public class BasePageUI {
	// 20 pages in footer
	public static final String SEARCH_PAGE_FOOTER_LINK = "//div[@class='footer']//a[text()='Search']";
	public static final String MY_ACCOUNT_PAGE_FOOTER_LINK = "//div[@class='footer']//a[text()='My account']";
	public static final String MY_ORDER_PAGE_FOOTER_LINK = "//div[@class='footer']//a[text()='Orders']";

	// 1 locator dynamic ~ 20 pages
	public static final String DYNAMIC_PAGE_FOOTER_LINK = "//div[@class='footer']//a[text()='%s']";

	
}
