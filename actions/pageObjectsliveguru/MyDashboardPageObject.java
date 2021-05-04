package pageObjectsliveguru;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIsliveguru.MyDashboardPageUI;

public class MyDashboardPageObject extends BasePage{
	private WebDriver driver;

	public MyDashboardPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isMyDashboardHeaderDisplayed() {
		return isElementDisplayed(driver, MyDashboardPageUI.MY_DASHBOARD_TEXT);
	}
	
	
}
