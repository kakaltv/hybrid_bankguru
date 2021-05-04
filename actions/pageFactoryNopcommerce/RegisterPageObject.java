package pageFactoryNopcommerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commons.BasePageFactory;

public class RegisterPageObject extends BasePageFactory {
	private WebDriver driver;

	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "gender-male")
	WebElement gender_mail;

	@FindBy(id = "FirstName")
	WebElement firstNameTxt;

	@FindBy(id = "LastName")
	WebElement lastNameTxt;

	@FindBy(id = "Email")
	WebElement emailTxt;

	@FindBy(id = "Password")
	WebElement passwordTxt;

	@FindBy(id = "ConfirmPassword")
	WebElement confirmPasswordTxt;

	@FindBy(id = "register-button")
	WebElement registerButton;

	@FindBy(xpath = "//div[@class='result' and text()='Your registration completed']")
	WebElement successMessage;

	@FindBy(className = "ico-logout")
	WebElement logoutLink;

	public void clickToGenderMaleRadioButton() {
		waitForElementVisible(driver, gender_mail);
		clickToElement(driver, gender_mail);
	}

	public void enterToFirstnameTextbox(String firstName) {
		sendkeyToElement(driver, firstNameTxt, firstName);
	}

	public void enterToLastnameTextbox(String lastName) {
		sendkeyToElement(driver, lastNameTxt, lastName);
	}

	public void enterToEmailTextbox(String email) {
		sendkeyToElement(driver, emailTxt, email);
	}

	public void enterToPasswordTextbox(String password) {
		sendkeyToElement(driver, passwordTxt, password);
	}

	public void enterToConfirmPasswordTextbox(String confirmPassword) {
		sendkeyToElement(driver, confirmPasswordTxt, confirmPassword);
	}

	public void clickToRegisterButton() {
		clickToElement(driver, registerButton);
	}

	public boolean isSuccessMessageDisplayed() {
		waitForElementVisible(driver, successMessage);
		return isElementDisplayed(driver, successMessage);
	}

	public void clickToLogoutPage() {
		clickToElement(driver, logoutLink);
	}

}
