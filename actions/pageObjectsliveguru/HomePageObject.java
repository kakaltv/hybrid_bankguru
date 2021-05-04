package pageObjectsliveguru;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIsliveguru.HomePageUI;

public class HomePageObject extends BasePage{
	private WebDriver driver;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToMyAccountFooterLink() {
		waitForElementVisible(driver, HomePageUI.MY_ACCOUNT_FOOTER);
		clickToElement(driver, HomePageUI.MY_ACCOUNT_FOOTER);
	}
	
	
}
