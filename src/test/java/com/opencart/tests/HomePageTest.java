package com.opencart.tests;


import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.opencart.base.BaseTest;
import com.opencart.constants.AppConstants;

public class HomePageTest extends BaseTest{
	
	@Test
	public void homePageTitleTest() {
		Assert.assertEquals(homePage.getHomePageTitle(), AppConstants.HOME_PAGE_TITLE);
		
	}
	
	@Test
	public void homePageURLTest() {
		Assert.assertEquals(homePage.getHomePageURL(), AppConstants.HOME_PAGE_URL);
		
	}

	@DataProvider
	public Object[][] getProductData() {
		return new Object[][] { 
			{ "Macbook" },
			{ "iMac" },
			{ "Samasung" }
		};
	}

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
