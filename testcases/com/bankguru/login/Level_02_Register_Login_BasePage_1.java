package com.bankguru.login;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commons.BasePage;

public class Level_02_Register_Login_BasePage_1 {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String username, password, loginPageUrl;
	BasePage basePage;

	@BeforeClass
	public void initBrowser() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://demo.guru99.com/v4/index.php");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		basePage = new BasePage();
	}

	@Test
	public void Login_01_Register() {
		loginPageUrl = basePage.getPageUrl(driver);
		basePage.clickToElement(driver, "//a[text()='here']");
		basePage.sendkeyToElement(driver, "//input[@name='emailid']", getRandomEmail());
		basePage.clickToElement(driver, "//input[@name='btnLogin']");
		username = basePage.getElementText(driver, "//td[text()='User ID :']/following-sibling::td");
		password = basePage.getElementText(driver, "//td[text()='Password :']/following-sibling::td");

	}

	@Test
	public void Login_02_Login() {
		basePage.openPageUrl(driver, loginPageUrl);
		basePage.sendkeyToElement(driver, "//input[@name='uid']", username);
		basePage.sendkeyToElement(driver, "//input[@name='password']", password);
		basePage.clickToElement(driver, "//input[@name='btnLogin']");
		String welcomeMessage = basePage.getElementText(driver, "//marquee[@class='heading3']");
		Assert.assertEquals(welcomeMessage, "Welcome To Manager's Page of Guru99 Bank");

	}

	public String getRandomEmail() {
		Random ran = new Random();
		return "test" + ran.nextInt() + "@mail.com";
	}

	@AfterClass
	public void cleanBrowser() {
		driver.quit();
	}

}
