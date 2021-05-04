package com.nopcommerce.admin;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObject.nopCommerce.Admin.DashBoardPageObject;
import pageObject.nopCommerce.Admin.LoginPageObject;
import pageObject.nopCommerce.Admin.PageGeneratorManager;
import pageObject.nopCommerce.Admin.ProductDetailsPageObject;
import pageObject.nopCommerce.Admin.SearchProductPageObject;

public class Level_10_Admin_Upload_File extends BaseTest{
	WebDriver driver;
	LoginPageObject loginPage;
	DashBoardPageObject dashboardPage;
	SearchProductPageObject searchProductPage;
	ProductDetailsPageObject productDetailsPage;
	
	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		driver = getBrowser(browserName, url);

		loginPage = PageGeneratorManager.getLoginPage(driver);
		loginPage.enterToEmailTextbox("");
		loginPage.enterToPasswordTextbox("");
		dashboardPage = loginPage.clickToLoginButton();
		
		searchProductPage = dashboardPage.openProductPage();
		searchProductPage.enterToProductNameTextbox("Adobe Photoshop CS4");
		searchProductPage.clickToSearchButton();
		productDetailsPage = searchProductPage.clickToEditButtonByProducName("Adobe Photoshop CS4");
	}

	@Test
	public void Admin_01_Upload_File() {
		productDetailsPage.clickToExpandPanelByName("");
		productDetailsPage.uploadPictureByFileName("");
		productDetailsPage.isPictureUploadedSuccessByFilename("");
		
		productDetailsPage.enterToAltTextbox("");
		productDetailsPage.enterToTitleTextbox("");
		productDetailsPage.enterToDisplayOrderTextbox("");
		productDetailsPage.clickToAddProductPictureButton();
		
		Assert.assertTrue(productDetailsPage.isPictureImageDisplayed("","","",""));
		productDetailsPage.clickToSaveButton();
		Assert.assertTrue(isSuccessMessageDisplayed("The product has been updated successfully."));
		
		searchProductPage.enterToProductNameTextbox("Adobe Photoshop CS4");
		searchProductPage.clickToSearchButton();
		Assert.assertTrue(productDetailsPage.isPictureImageUpdated("","Adobe Photoshop CS4"));
	}


	@AfterClass
	public void cleanBrowser() {
		driver.quit();
	}

}
