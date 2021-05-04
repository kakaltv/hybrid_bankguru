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

public class Level_04_Register_Login_BasePage_extend extends BasePage{
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String username, password, loginPageUrl;

	@BeforeClass
	public void initBrowser() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://demo.guru99.com/v4/index.php");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@Test
	public void Login_01_Register() {
		loginPageUrl = getPageUrl(driver);
		clickToElement(driver, "//a[text()='here']");
		sendkeyToElement(driver, "//input[@name='emailid']", getRandomEmail());
		clickToElement(driver, "//input[@name='btnLogin']");
		username = getElementText(driver, "//td[text()='User ID :']/following-sibling::td");
		password = getElementText(driver, "//td[text()='Password :']/following-sibling::td");

	}

	@Test
	public void Login_02_Login() {
		openPageUrl(driver, loginPageUrl);
		sendkeyToElement(driver, "//input[@name='uid']", username);
		sendkeyToElement(driver, "//input[@name='password']", password);
		clickToElement(driver, "//input[@name='btnLogin']");
		String welcomeMessage = getElementText(driver, "//marquee[@class='heading3']");
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
