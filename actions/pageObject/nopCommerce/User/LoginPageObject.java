package pageObject.nopCommerce.User;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIsnopCommerceUser.LoginPageUI;

public class LoginPageObject extends BasePage {
	private WebDriver driver;
	
	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void enterToEmailTextbox(String email) {
		waitForElementVisible(driver, LoginPageUI.LOGIN_EMAIL_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.LOGIN_EMAIL_TEXTBOX, email);
		
	}

	public void enterToPasswordTextbox(String password) {
		waitForElementVisible(driver, LoginPageUI.LOGIN_PASSWORD_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.LOGIN_PASSWORD_TEXTBOX, password);
		
	}

	public HomePageObject clickToLoginButton() {
		waitForElementClickable(driver, LoginPageUI.LOGIN_LOGIN_BUTTON);
		clickToElement(driver,LoginPageUI.LOGIN_LOGIN_BUTTON);
		return PageGeneratorManager.getHomePage(driver);
	}

}
