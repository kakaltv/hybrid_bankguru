package pageFactoryNopcommerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commons.BasePageFactory;

public class HomePageObject extends BasePageFactory {
	private WebDriver driver;

	@FindBy(id = "nivo-slider")
	WebElement homePageSlider;
	
	@FindBy(className = "ico-register")
	WebElement registerLink;
	
	@FindBy(className = "ico-login")
	WebElement loginLink;
	
	public HomePageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean isHomePageSliderDisplayed() {
		waitForElementVisible(driver, homePageSlider);
		return isElementDisplayed(driver, homePageSlider);
	}

	public void clickToRegisterLink() {
		waitForElementVisible(driver, registerLink);
		clickToElement(driver, registerLink);
	}

	public void clickToLoginLink() {
		waitForElementVisible(driver, loginLink);
		clickToElement(driver, loginLink);
	}

}
