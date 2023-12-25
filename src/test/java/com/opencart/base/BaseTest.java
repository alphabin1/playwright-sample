package com.opencart.base;

import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.microsoft.playwright.Page;
import com.opencart.factory.Browsers;
import com.opencart.pages.HomePage;
import com.opencart.pages.LoginPage;
import com.opencart.utils.PropertiesUtils;
import com.opencart.utils.ScreenshotUtility;

/**
 * BaseTest class for test initialization and teardown.
 */
public class BaseTest {
	
	Browsers browsers;
	Page page;
	protected HomePage homePage;
	protected LoginPage loginPage;

	/**
	 * Initializes the test environment.
	 * 
	 * @throws IOException if an I/O exception occurs
	 */
	@BeforeTest
	public void setUP() throws IOException {
		browsers = new Browsers();
		page = browsers.startBrowser(
			PropertiesUtils.setBrowser().trim(), 
			PropertiesUtils.setUrl().trim(), 
			PropertiesUtils.setMode()
		);
		homePage = new HomePage(page);
	}

	/**
	 * Tears down the test environment after test execution.
	 */
	@AfterTest
	public void tearDown() {
		page.context().browser().close();
	}
	
	/**
	 * Takes a screenshot in case of test failure.
	 *
	 * @param result The test result.
	 * @throws IOException if an I/O exception occurs while capturing the screenshot
	 */
	@AfterMethod(alwaysRun = true)
	public void tearDown(ITestResult result) throws IOException {
        if (ITestResult.FAILURE == result.getStatus()) {
            // Capture a screenshot and get the path
            String screenshotPath = ScreenshotUtility.captureScreenshot();
            System.out.println("Screenshot is generated for failure: " + result.getName() + " - Path: " + screenshotPath + '\n');
        }
    }
}
