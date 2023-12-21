package com.opencart.base;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.microsoft.playwright.Page;
import com.opencart.factory.AllBrowsers;
import com.opencart.pages.HomePage;
import com.opencart.pages.LoginPage;
import com.opencart.utils.PropertiesClass;

public class BaseTest {
	
	static Page page;
	protected HomePage homePage;
	protected LoginPage loginPage;

	// Base class for test initialization
	@BeforeTest
	public void setUP() throws IOException {
		page = AllBrowsers.startBrowser(PropertiesClass.setBrowser().trim(), PropertiesClass.setUrl().trim(), PropertiesClass.setMode());
		homePage = new HomePage();

	}

	// Base class for teardown
	@AfterTest
	public void tearDown() {
		page.context().browser().close();

	}

}
