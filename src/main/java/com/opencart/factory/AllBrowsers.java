package com.opencart.factory;

import java.awt.Dimension;
import java.awt.Toolkit;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.opencart.utils.PropertiesClass;

public class AllBrowsers extends PropertiesClass {

	static Playwright playwright;
	static Browser browser;
	static BrowserContext browserContext;
	public static Page page;


	// Manage browser initialization and teardown using Playwright
	public static Page startBrowser(String browserName, String webUrl, boolean mode) {

		playwright = Playwright.create();
		
		if (browserName.toLowerCase().equals("chromium")) {
			browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(mode));

		} else if (browserName.toLowerCase().equals("firefox")) {
			browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(mode));

		} else if (browserName.toLowerCase().equals("safari")) {
			browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(mode));

		} else if (browserName.toLowerCase().equals("chrome")) {
			browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(mode));

		} else if (browserName.toLowerCase().equals("edge")) {
			browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("edge").setHeadless(mode));
			
		}

		else {
			System.out.println("Browser is not found");

		}

		System.out.println("Opend browser is: " + browserName);

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int) screenSize.getWidth();
		int heigth = (int) screenSize.getHeight();

		browserContext = browser.newContext(new Browser.NewContextOptions().setViewportSize(width, heigth));

		page = browserContext.newPage();

		page.navigate(webUrl);

		return page;

	}

	public void tearDown() {
		browserContext.close();
		page.context().browser().close();

	}

}
