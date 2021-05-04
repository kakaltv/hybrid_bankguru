package javaTester;

public class Dynamic_Locator {

	public static void main(String[] args) {
		String SEARCH_PAGE_FOOTER_LINK = "//div[@class='footer']//a[text()='Search']";
		String MY_ACCOUNT_PAGE_FOOTER_LINK = "//div[@class='footer']//a[text()='My account']";
		String MY_ORDER_PAGE_FOOTER_LINK = "//div[@class='footer']//a[text()='Orders']";
		String dynamic = "//div[@class='footer']//a[text()='%s']";
		String dynamic2 = "//div[@id='%s']//a[text()='%s']";

		System.out.println(String.format(dynamic, "abc"));
		System.out.println(String.format(dynamic2, "abc", "xyz"));
	}

}
