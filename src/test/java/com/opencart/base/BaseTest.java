package com.opencart.base;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.microsoft.playwright.Page;
import com.opencart.factory.Browsers;
import com.opencart.pages.HomePage;
import com.opencart.pages.LoginPage;
import com.opencart.utils.PropertiesUtils;

/**
 * BaseTest class for test initialization and teardown.
 */
public class BaseTest {
	
	static Page page;
	protected HomePage homePage;
	protected LoginPage loginPage;

	/**
	 * Initializes the test environment.
	 * 
	 * @throws IOException if an I/O exception occurs
	 */
	@Parameters({ "browserName", "webUrl", "mode" })
	@BeforeTest
	public void setUP() throws IOException {
		page = Browsers.startBrowser(
			PropertiesUtils.setBrowser().trim(), 
			PropertiesUtils.setUrl().trim(), 
			PropertiesUtils.setMode()
		);
		homePage = new HomePage();
	}

	/**
	 * Tears down the test environment after test execution.
	 */
	@AfterTest
	public void tearDown() {
		page.context().browser().close();
	}
}
