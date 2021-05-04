package com.nopcommerce.login;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObject.nopCommerce.User.HomePageObject;
import pageObject.nopCommerce.User.LoginPageObject;
import pageObject.nopCommerce.User.MyAccountPageObject;
import pageObject.nopCommerce.User.MyOrderPageObject;
import pageObject.nopCommerce.User.PageGeneratorManager;
import pageObject.nopCommerce.User.RegisterPageObject;
import pageObject.nopCommerce.User.SearchPageObject;

public class Level_05_Register_Login_Switch_Page extends BaseTest{
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String email, password;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		driver = getBrowser(browserName, url);

		email = getRandomEmail();
		password = "123456";
	}

	@Test
	public void Login_01_Register() {
		// Step 1: Mở URL -> Home page
		homePage = PageGeneratorManager.getHomePage(driver);
		System.out.println(homePage.hashCode());
		
		// Step 2: Verify Home Page Slider displayed
		Assert.assertTrue(homePage.isHomePageSliderDisplayed());

		// Step 3: Click to register link -> Register Page
		registerPage = homePage.clickToRegisterLink();

		// Step 4: Click to Gender male radio btn
		registerPage.clickToGenderMaleRadioButton();

		// Step 5: Input Firstname
		registerPage.enterToFirstnameTextbox("Kim");

		// Step 6: Input Lastname
		registerPage.enterToLastnameTextbox("Anh");

		// Step 7: Input Email
		registerPage.enterToEmailTextbox(email);

		// Step 8: Input Password
		registerPage.enterToPasswordTextbox(password);

		// Step 9: Input Confirm password
		registerPage.enterToConfirmPasswordTextbox(password);

		// Step 10: Click to Register button
		registerPage.clickToRegisterButton();

		// Step 11: Verify success message dispalyed
		Assert.assertTrue(registerPage.isSuccessMessageDisplayed());

		// Step 12: Click to Logout link -> Home page
		homePage = registerPage.clickToLogoutPage();
		System.out.println(homePage.hashCode());

	}

	@Test
	public void Login_02_Login() {
		// Step 1: Click to Login link
		loginPage=homePage.clickToLoginLink();

		// Step 2: enter to email textbox
		loginPage.enterToEmailTextbox(email);

		// Step 3: enter to password textbox
		loginPage.enterToPasswordTextbox(password);

		// Step 4: click to Login button -> Home page
		homePage=loginPage.clickToLoginButton();
		System.out.println(homePage.hashCode());

		// Step 5: Verify Homepage logo displayed
		Assert.assertTrue(homePage.isHomePageSliderDisplayed());

	}

	@Test
	public void Login_03_Switch_Page_At_Footer() {
		// Home Page -> Search Page
		searchPage = homePage.openSearchPage(driver);
		
		// Search Page -> My Account Page
		myAccountPage = searchPage.openMyAccountPage(driver);
		
		// My Account Page -> My Order Page
		myOrderPage = myAccountPage.openMyOrderPage(driver);
		
		// My Order Page -> My Account Page
		myAccountPage = myOrderPage.openMyAccountPage(driver);
		
		// My Account Page -> Search Page
		searchPage = myAccountPage.openSearchPage(driver);
	}
	
	public String getRandomEmail() {
		Random ran = new Random();
		return "test" + ran.nextInt() + "@mail.com";
	}

	@AfterClass
	public void cleanBrowser() {
		driver.quit();
	}

	HomePageObject homePage;
	LoginPageObject loginPage;
	RegisterPageObject registerPage;
	SearchPageObject searchPage;
	MyAccountPageObject myAccountPage;
	MyOrderPageObject myOrderPage;

}
