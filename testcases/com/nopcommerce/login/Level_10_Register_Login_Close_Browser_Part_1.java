package com.nopcommerce.login;

import java.util.Random;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.common.Common_01_Register_New_User;
import com.nopcommerce.common.Common_02_Cookies;

import commons.BaseTest;
import pageObject.nopCommerce.User.HomePageObject;
import pageObject.nopCommerce.User.LoginPageObject;
import pageObject.nopCommerce.User.MyAccountPageObject;
import pageObject.nopCommerce.User.MyOrderPageObject;
import pageObject.nopCommerce.User.PageGeneratorManager;
import pageObject.nopCommerce.User.RegisterPageObject;
import pageObject.nopCommerce.User.SearchPageObject;

public class Level_10_Register_Login_Close_Browser_Part_1 extends BaseTest {
	WebDriver driver;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		driver = getBrowser(browserName, url);
		homePage = PageGeneratorManager.getHomePage(driver);
		homePage = new HomePageObject(driver);

		for(Cookie cookie : Common_02_Cookies.allCookies) {
			driver.manage().addCookie(cookie);
		}
		
		homePage.refreshPage(driver);
		
		// Step 5: Verify Homepage logo displayed
		Assert.assertTrue(homePage.isHomePageSliderDisplayed());
	}

	@Test
	public void TC_01_Sort_Product_By_Name() {

	}

	@Test
	public void TC_02_Sort_Product_By_Sub_Category() {

	}

	@Test
	public void TC_03_Sort_Product_By_Price() {

	}

	public String getRandomEmail() {
		Random ran = new Random();
		return "test" + ran.nextInt() + "@mail.com";
	}

	// Luon luon chay after de close browser, tiet kiem bo nho
	@AfterClass (alwaysRun = true)
	public void cleanBrowser() {
		closeBrowserAndDriver(driver);
	}

	HomePageObject homePage;
	LoginPageObject loginPage;
	RegisterPageObject registerPage;
	SearchPageObject searchPage;
	MyAccountPageObject myAccountPage;
	MyOrderPageObject myOrderPage;

}
