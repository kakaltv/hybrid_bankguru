package com.liveguru.login;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commons.BasePage;
import pageObjectsliveguru.HomePageObject;
import pageObjectsliveguru.LoginPageObject;
import pageObjectsliveguru.MyDashboardPageObject;

public class Level_01_Register_Login_BasePage {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String username, password, loginPageUrl;

	@BeforeClass
	public void initBrowser() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://live.demoguru99.com/v4/index.php");
	}

	@Test
	public void Login_01_Empty_Email_And_Password() {
		homePage = new HomePageObject(driver);

		// Click vào My Account -> Login page
		homePage.clickToMyAccountFooterLink();
		loginPage = new LoginPageObject(driver);

		// Enter to email
		loginPage.enterToEmailTextbox("");
		loginPage.enterToPasswordTextbox("");
		loginPage.clickToLoginButton();

		Assert.assertEquals(loginPage.getEmptyEmailErrorMessage(), "This is a required field.");
		Assert.assertEquals(loginPage.getEmptyPasswordErrorMessage(), "This is a required field.");

	}

	@Test
	public void Login_02_Invalid_Email() {
		loginPage.refreshPage(driver);

		loginPage.enterToEmailTextbox("anh@mailcomrrrrrr");
		loginPage.enterToPasswordTextbox("231231");
		loginPage.clickToLoginButton();

		Assert.assertEquals(loginPage.getInvalidEmailErrorMessage(), "Please enter a valid email address. For example johndoe@domain.com.");

	}

	@Test
	public void Login_03_Valid_Email_And_Password() {
		loginPage.refreshPage(driver);

		loginPage.enterToEmailTextbox("dam@gmail.com");
		loginPage.enterToPasswordTextbox("123123");
		loginPage.clickToLoginButton();

		myDashboardPage = new MyDashboardPageObject(driver);
		Assert.assertTrue(myDashboardPage.isMyDashboardHeaderDisplayed(), "Please enter a valid email address. For example johndoe@domain.com.");

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
	MyDashboardPageObject myDashboardPage;
}
