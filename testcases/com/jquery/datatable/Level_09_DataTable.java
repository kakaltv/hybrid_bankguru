package com.jquery.datatable;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Sleeper;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObject.DataTable.HomePageObject;
import pageObject.DataTable.PageGeneratorManager;

public class Level_09_DataTable extends BaseTest{
	WebDriver driver;
	HomePageObject homePage;
	
	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		driver = getBrowser(browserName, url);
		homePage = PageGeneratorManager.getHomePage(driver);
		
	}

	// https://www.jqueryscript.net/demo/CRUD-Data-Grid-Plugin-jQuery-Quickgrid/
	public void Table_01_Paging() {
		homePage.openPageByNumber("15");
		Assert.assertTrue(homePage.isPageActivedNyNumberDisplayed("15"));
		
		homePage.openPageByNumber("5");
		Assert.assertTrue(homePage.isPageActivedNyNumberDisplayed("5"));
		
		homePage.openPageByNumber("3");
		Assert.assertTrue(homePage.isPageActivedNyNumberDisplayed("3"));

	}
	
	// https://www.jqueryscript.net/demo/CRUD-Data-Grid-Plugin-jQuery-Quickgrid/
	public void Table_02_Input_Header_Textbox() {
		// Input to textbox
		homePage.inputToHeaderByName("Females","777");
		homePage.sleepInSecond(2);
		homePage.refreshPage(driver);
		
		homePage.inputToHeaderByName("Males","803");
		homePage.sleepInSecond(2);
		homePage.refreshPage(driver);
		
		homePage.inputToHeaderByName("Country","South-Central Asia");
		homePage.sleepInSecond(2);
		homePage.refreshPage(driver);
		
		// Click to icon by country name
		homePage.clickToIconByCountryName("Argentina", "remove");
		homePage.sleepInSecond(2);
		
		homePage.clickToIconByCountryName("ASIA", "edit");
		homePage.sleepInSecond(2);
		
	}

	// https://www.jqueryscript.net/demo/CRUD-Data-Grid-Plugin-jQuery-Quickgrid/
	public void Table_03_Click_To_Icon() {
		// Click to icon by country name
		homePage.clickToIconByCountryName("Argentina", "remove");
		homePage.sleepInSecond(2);
		
		homePage.clickToIconByCountryName("ASIA", "edit");
		homePage.sleepInSecond(2);
		
	}

	// https://www.jqueryscript.net/demo/CRUD-Data-Grid-Plugin-jQuery-Quickgrid/
	public void Table_04_Verify_Row_Value() {
		homePage.inputToHeaderByName("Country","Afghanistan");
		Assert.assertTrue(homePage.isRowValueDisplayed("38418","Afghanistan","407124","791312"));
		homePage.sleepInSecond(2);
		
	}
	
	// https://www.jqueryscript.net/demo/jQuery-Dynamic-Data-Grid-Plugin-appendGrid/
	public void Table_05_Input_Row_Textbox() {
		// Input to textbox
		homePage.inputToTextboxByRowNumber("Contact Person","3","Kim Kaka");
		homePage.sleepInSecond(1);
		homePage.refreshPage(driver);
		
		homePage.inputToTextboxByRowNumber("Company","2","Hong Kong");
		homePage.sleepInSecond(1);
		homePage.refreshPage(driver);
		
		homePage.inputToTextboxByRowNumber("Order Placed","2","Kong");
		homePage.sleepInSecond(1);
		homePage.refreshPage(driver);
		
	}

	// https://www.jqueryscript.net/demo/jQuery-Dynamic-Data-Grid-Plugin-appendGrid/
	@Test
	public void Table_06_Click_To_Icon() {
		homePage.clickToIconByRowNumber("2","Move Up");
		homePage.sleepInSecond(2);
		
		homePage.clickToIconByRowNumber("3","Remove Current Row");
		homePage.sleepInSecond(2);
		
	}

	@AfterClass
	public void cleanBrowser() {
		driver.quit();
	}

}
