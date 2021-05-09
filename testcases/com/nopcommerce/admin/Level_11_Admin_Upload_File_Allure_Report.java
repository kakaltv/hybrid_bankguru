package com.nopcommerce.admin;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

import pageObject.nopCommerce.Admin.DashBoardPageObject;
import pageObject.nopCommerce.Admin.LoginPageObject;
import pageObject.nopCommerce.Admin.PageGeneratorManager;
import pageObject.nopCommerce.Admin.ProductDetailsPageObject;
import pageObject.nopCommerce.Admin.SearchProductPageObject;

@Epic("Upload File")
public class Level_11_Admin_Upload_File_Allure_Report extends BaseTest{
	WebDriver driver;
	
	String productName = "Adobe Photoshop CS4";
	String productImg = "IMG_0037.JPG";
	String productAlt = "Img Alt";
	String productTitle = "Img Title";
	String productDisplayOrder = "1";
	String tableName = "productpictures";
	
	LoginPageObject loginPage;
	DashBoardPageObject dashboardPage;
	SearchProductPageObject searchProductPage;
	ProductDetailsPageObject productDetailsPage;
	
	
	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		driver = getBrowser(browserName, url);
		loginPage = PageGeneratorManager.getLoginPage(driver);
		
		log.info("Login - 1. Enter email");
		loginPage.enterToEmailTextbox("admin@yourstore.com");
		
		log.info("Login - 2. Enter Password");
		loginPage.enterToPasswordTextbox("admin");
		
		log.info("Login - 3. Click Login button");
		dashboardPage = loginPage.clickToLoginButton();
		
		log.info("Login - 4. Open sub menu");
		dashboardPage.openSubMenuPage(driver,"Catalog", "Products");
		searchProductPage = PageGeneratorManager.getSearchProductPage(driver); 
		
		log.info("Search Product - 5. Enter product name: " + productName);
		searchProductPage.enterToProductNameTextbox(productName);
		
		log.info("Search Product - 6. Click Search button");
		searchProductPage.clickToSearchButton();
		
		log.info("Search Product - 7. Click Edit button");
		productDetailsPage = searchProductPage.clickToEditButtonByProducName(productName);
	}

	@Description("Upload file 01 - Product Image File Upload")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void Admin_01_Upload_File() {
		
		log.info("Product Details - 8. Click expand panal by name");
		productDetailsPage.clickToExpandPanelByName("Pictures");
		
		log.info("Product Details - 9. Upload File by card name");
		productDetailsPage.uploadFilesByCardName(driver, "pictures", productImg);
		
		log.info("Product Details - 10. Verify Picture upload successfully");
		productDetailsPage.isPictureUploadedSuccessByFilename(productImg);
		
		log.info("Product Details - 11. Enter to alt textbox: " + productAlt);
		productDetailsPage.enterToAltTextbox(productAlt);
		
		log.info("Product Details - 12. Enter to Title textbox: " + productTitle);
		productDetailsPage.enterToTitleTextbox(productTitle);
		
		log.info("Product Details - 13. Enter Order textbox: " + productDisplayOrder);
		productDetailsPage.enterToDisplayOrderTextbox(productDisplayOrder);
		
		log.info("Product Details - 14. Click Add Product Button");
		productDetailsPage.clickToAddProductPictureButton();
		
		log.info("Product Details - 15. Verify Image uploaded");
		Assert.assertTrue(productDetailsPage.isPictureImageDisplayed(productName, productDisplayOrder, productAlt, productTitle));
		
		log.info("Product Details - 16. Click Save button");
		productDetailsPage.clickToSaveButton();
		
		log.info("Product Details - 17. Verify success message displayed");
		Assert.assertTrue(searchProductPage.isSuccessMessageDisplayed("The product has been updated successfully."));
		
		log.info("Search Product - 18. Enter product name: " + productName );
		searchProductPage.enterToProductNameTextbox(productName);
		
		log.info("Search Product - 19. Click to Search button ");
		searchProductPage.clickToSearchButton();
		
		log.info("Search Product - 20. Verify image displayed");
		Assert.assertTrue(searchProductPage.isPictureImageUpdated(productName,productName));
		
		log.info("Product Details - 21. Click Edit button");
		productDetailsPage = searchProductPage.clickToEditButtonByProducName(productName);
		
		log.info("Product Details - 22. Expand Panel " + "Pictures");
		productDetailsPage.clickToExpandPanelByName("Pictures");
		
		log.info("Product Details - 23. Click Delete button at " + productTitle);
		productDetailsPage.clickToDeleteButtonAtProductTitle(productTitle);
		
		log.info("Product Details - 24. Verify No Data message displayed");
		Assert.assertTrue(productDetailsPage.isNoDataMessageDisplayedInTable(tableName));
		
		log.info("Search Product - 25. Click Save button");
		searchProductPage = productDetailsPage.clickToSaveButton();
		
		log.info("Search Product - 26. Enter Product name: " + productName);
		searchProductPage.enterToProductNameTextbox(productName);
		
		log.info("Search Product - 27. Click Search button");
		searchProductPage.clickToSearchButton();
		
		log.info("Search Product - 28. Verify Image displayed");
		Assert.assertTrue(searchProductPage.isPictureImageUpdated(productName,"default-image"));
		
	}

	@AfterClass
	public void cleanBrowser() {
		driver.quit();
	}

}
