package pageObject.nopCommerce.User;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
	private static HomePageObject homePage;
	private static LoginPageObject loginPage;
	private static RegisterPageObject registerPage;
	private static SearchPageObject searchPage;
	private static MyAccountPageObject myAccountPage;
	private static MyOrderPageObject myOrderPage;

	private PageGeneratorManager() {

	}

	public static HomePageObject getHomePage(WebDriver driver) {
		if (homePage == null) {
			homePage = new HomePageObject(driver);
		}
		return homePage;
	}

	public static LoginPageObject getLoginPage(WebDriver driver) {
		if (loginPage == null) {
			loginPage = new LoginPageObject(driver);
		}
		return loginPage;
	}

	public static RegisterPageObject getRegisterPage(WebDriver driver) {
		if (registerPage == null) {
			registerPage = new RegisterPageObject(driver);
		}
		return registerPage;
	}
	
	public static SearchPageObject getSearchPage(WebDriver driver) {
		if (searchPage == null) {
			searchPage = new SearchPageObject(driver);
		}
		return searchPage;
	}
	
	public static MyAccountPageObject getMyAccountPage(WebDriver driver) {
		if (myAccountPage == null) {
			myAccountPage = new MyAccountPageObject(driver);
		}
		return myAccountPage;
	}
	
	public static MyOrderPageObject getMyOrderPage(WebDriver driver) {
		if (myOrderPage == null) {
			myOrderPage = new MyOrderPageObject(driver);
		}
		return myOrderPage;
	}

}
