package pageObject.nopCommerce.Admin;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
	private static DashBoardPageObject dashboardPage;
	private static LoginPageObject loginPage;
	private static ProductDetailsPageObject productDetailsPage;
	private static SearchProductPageObject searchProductPage;
	

	private PageGeneratorManager() {

	}
	
	public static DashBoardPageObject getDashboardPage(WebDriver driver) {
		if (dashboardPage == null) {
			dashboardPage = new DashBoardPageObject(driver);
		}
		return dashboardPage;
	}
	
	public static LoginPageObject getLoginPage(WebDriver driver) {
		if (loginPage == null) {
			loginPage = new LoginPageObject(driver);
		}
		return loginPage;
	}
	
	public static ProductDetailsPageObject getProductDetailsPage(WebDriver driver) {
		if (productDetailsPage == null) {
			productDetailsPage = new ProductDetailsPageObject(driver);
		}
		return productDetailsPage;
	}

	public static SearchProductPageObject getSearchProductPage(WebDriver driver) {
		if (searchProductPage == null) {
			searchProductPage = new SearchProductPageObject(driver);
		}
		return searchProductPage;
	}


}
