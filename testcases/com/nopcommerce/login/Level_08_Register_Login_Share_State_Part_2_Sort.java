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

public class Level_08_Register_Login_Share_State_Part_2_Sort extends BaseTest {
	WebDriver driver;
	String email, password;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		driver = getBrowser(browserName, url);

		email = getRandomEmail();
		password = "123456";

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

	}
	
	@Test
	public void TC_01_Sort_Name_ASC() {
		
	}
	
	@Test
	public void TC_02_Sort_Name_DESC() {
		
	}
	
	@Test
	public void TC_03_Sort_Price_ASC() {
		
	}

	@Test
	public void TC_04_Sort_Price_DESC() {

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
