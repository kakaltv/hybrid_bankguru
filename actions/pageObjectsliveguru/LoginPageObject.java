package pageObjectsliveguru;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIsliveguru.*;

public class LoginPageObject extends BasePage {
	private WebDriver driver;

	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void enterToEmailTextbox(String email) {
		waitForElementVisible(driver, LoginPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.EMAIL_TEXTBOX, email);
	}

	public void enterToPasswordTextbox(String password) {
		waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
	}

	public void clickToLoginButton() {
		waitForElementVisible(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
	}

	public String getEmptyEmailErrorMessage() {
		return getElementText(driver, LoginPageUI.EMPTY_EMAIL_ERROR_MESSAGE);

	}

	public String getEmptyPasswordErrorMessage() {
		return getElementText(driver, LoginPageUI.EMPTY_PASSWORD_ERROR_MESSAGE);
	}

	public String getInvalidEmailErrorMessage() {
		return getElementText(driver, LoginPageUI.INVALID_EMAIL_ERROR_MESSAGE);
	}

	public String getInvalidPasswordErrorMessage() {
		return getElementText(driver, LoginPageUI.INVALID_PASSWORD_ERROR_MESSAGE);
	}

	public String getInvalidEmailOrPasswordErrorMessage() {
		return getElementText(driver, LoginPageUI.INVALID_EMAIL_OR_PASSWORD_ERROR_MESSAGE);
	}

}
