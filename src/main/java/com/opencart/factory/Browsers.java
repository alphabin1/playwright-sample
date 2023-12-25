package com.opencart.factory;

import java.awt.Dimension;
import java.awt.Toolkit;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.opencart.utils.PropertiesUtils;

/**
 * This class manages browser initialization and teardown using Playwright.
 */
public class Browsers extends PropertiesUtils {

	Playwright playwright;
	Browser browser;
	BrowserContext browserContext;
	Page page;

	private static ThreadLocal<Page> tlPage = new ThreadLocal<>();

	/**
	 * Gets the current Page object.
	 *
	 * @return The current Page object associated with the thread.
	 */
	public static Page getPage() {
		return tlPage.get();
	}

	/**
	 * Initializes a browser and navigates to the specified URL.
	 *
	 * @param browserName The name of the browser (e.g., chrome, firefox).
	 * @param webUrl      The URL to navigate to.
	 * @param mode        The mode for browser initialization (headless or not).
	 * @return The created Page object for the browser.
	 */
	public Page startBrowser(String browserName, String webUrl, boolean mode) {

		playwright = Playwright.create();

		switch (browserName.toLowerCase()) {
		case "chromium":
			browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(mode));
			break;
		case "firefox":
			browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(mode));
			break;
		case "safari":
			browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(mode));
			break;
		case "chrome":
			browser = playwright.chromium()
					.launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(mode));
			break;
		case "edge":
			browser = playwright.chromium()
					.launch(new BrowserType.LaunchOptions().setChannel("edge").setHeadless(mode));
			break;
		default:
			System.out.println("Browser is not found");
		}

		System.out.println("Opened browser is: " + browserName);

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int) screenSize.getWidth();
		int height = (int) screenSize.getHeight();

		browserContext = browser.newContext(new Browser.NewContextOptions().setViewportSize(width, height));

		page = browserContext.newPage();
		page.navigate(webUrl);
		tlPage.set(page);

		return page;
	}

	/**
	 * Closes the browser and its context.
	 */
	public void tearDown() {
		browserContext.close();
		page.context().browser().close();
	}
}
