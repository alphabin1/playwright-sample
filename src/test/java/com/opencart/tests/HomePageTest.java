package com.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.opencart.base.BaseTest;
import com.opencart.constants.AppConstants;

/**
 * Test cases related to the Home Page functionality of the application.
 */
public class HomePageTest extends BaseTest{
	
	/**
	 * Test to verify the Home Page title.
	 */
	@Test
	public void homePageTitleTest() {
		Assert.assertEquals(homePage.getHomePageTitle(), AppConstants.HOME_PAGE_TITLE);
	}
	
	/**
	 * Test to verify the Home Page URL.
	 */
	@Test
	public void homePageURLTest() {
		Assert.assertEquals(homePage.getHomePageURL(), AppConstants.HOME_PAGE_URL);
	}

	/**
	 * Data provider for the search test.
	 * 
	 * @return Object array with product names
	 */
	@DataProvider
	public Object[][] getProductData() {
		return new Object[][] { 
			{ "Macbook" },
			{ "iMac" },
			{ "Samsung" }
		};
	}

	/**
	 * Test to perform a search operation on the Home Page.
	 * 
	 * @param productName Name of the product to search
	 */
	@Test(dataProvider = "getProductData")
	public void searchTest(String productName) {
		try {
			Thread.sleep(3000);
			String actualSearchHeader = homePage.doSearch(productName);
			Assert.assertEquals(actualSearchHeader, "Search - " + productName);

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
