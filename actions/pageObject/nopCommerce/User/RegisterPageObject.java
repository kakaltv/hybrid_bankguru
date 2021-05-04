package pageObject.nopCommerce.User;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIsnopCommerceUser.RegisterPageUI;

public class RegisterPageObject extends BasePage{
	private WebDriver driver;

	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToGenderMaleRadioButton() {
		waitForElementClickable(driver, RegisterPageUI.REGISTER_GENDER_MALE_RADIO_BUTTON);
		clickToElement(driver,RegisterPageUI.REGISTER_GENDER_MALE_RADIO_BUTTON);
		
	}

	public void enterToFirstnameTextbox(String firstName) {
		waitForElementVisible(driver, RegisterPageUI.REGISTER_FIRSTNAME_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.REGISTER_FIRSTNAME_TEXTBOX, firstName);
	}

	public void enterToLastnameTextbox(String lastName) {
		waitForElementVisible(driver, RegisterPageUI.REGISTER_LASTNAME_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.REGISTER_LASTNAME_TEXTBOX, lastName);
		
	}

	public void enterToEmailTextbox(String email) {
		waitForElementVisible(driver, RegisterPageUI.REGISTER_EMAIL_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.REGISTER_EMAIL_TEXTBOX, email);
	
	}

	public void enterToPasswordTextbox(String password) {
		waitForElementVisible(driver, RegisterPageUI.REGISTER_PASSWORD_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.REGISTER_PASSWORD_TEXTBOX, password);
		
	}

	public void enterToConfirmPasswordTextbox(String confirmPassword) {
		waitForElementVisible(driver, RegisterPageUI.REGISTER_CONFIRM_PASSWORD);
		sendkeyToElement(driver, RegisterPageUI.REGISTER_CONFIRM_PASSWORD, confirmPassword);
		
	}

	public void clickToRegisterButton() {
		waitForElementClickable(driver, RegisterPageUI.REGISTER_REGISTER_BUTTON);
		clickToElement(driver,RegisterPageUI.REGISTER_REGISTER_BUTTON);
	
	}

	public boolean isSuccessMessageDisplayed() {
		waitForElementVisible(driver, RegisterPageUI.REGISTER_SUCCESS_MESSAGE);
		return isElementDisplayed(driver, RegisterPageUI.REGISTER_SUCCESS_MESSAGE);
	}

	public HomePageObject clickToLogoutPage() {
		waitForElementClickable(driver, RegisterPageUI.REGISTER_LOGOUT_LINK);
		clickToElement(driver,RegisterPageUI.REGISTER_LOGOUT_LINK);
		return PageGeneratorManager.getHomePage(driver);
	}

}
