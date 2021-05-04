package pageObject.nopCommerce.User;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIsnopCommerceUser.HomePageUI;

public class HomePageObject extends BasePage{
	private WebDriver driver;
	
	// Khi new 1 class thì nó sẽ nhảy vào hàm khởi tạo đầu tiên cùng tên với class, ko có kiểu trả v�?, 1 class có thể có nhi�?u hàm khởi tạo -> đa hình
	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public boolean isHomePageSliderDisplayed() {
		waitForElementVisible(driver, HomePageUI.HOME_PAGE_SLIDER);
		return isElementDisplayed(driver, HomePageUI.HOME_PAGE_SLIDER);
	}

	public RegisterPageObject clickToRegisterLink() {
		waitForElementClickable(driver, HomePageUI.HOME_PAGE_REGISTER_LINK);
		clickToElement(driver, HomePageUI.HOME_PAGE_REGISTER_LINK);
		return PageGeneratorManager.getRegisterPage(driver);
		
	}

	public LoginPageObject clickToLoginLink() {
		waitForElementClickable(driver, HomePageUI.HOME_PAGE_LOGIN_LINK);
		clickToElement(driver, HomePageUI.HOME_PAGE_LOGIN_LINK);
		return PageGeneratorManager.getLoginPage(driver);
	}


}
