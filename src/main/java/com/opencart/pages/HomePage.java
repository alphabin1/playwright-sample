package com.opencart.pages;

import com.microsoft.playwright.Page;
import com.opencart.factory.Browsers;

/**
 * Page class for Home Page functionalities.
 */
public class HomePage extends Browsers {

	Page page;

	// String Locators - Object Repository
	private String search = "#search input";
	private String searchPageHeader = "#content h1";
	private String myAccountBtn = "a[title='My Account']";
	private String loginLink = "//a[text()='Login']";
	private String searchIcon = "#search button";

	/**
	 * Constructs a HomePage object with the given Page instance.
	 *
	 * @param page The Playwright Page instance.
	 */
	public HomePage(Page page) {
		this.page = page;
	}

	/**
	 * Retrieves the title of the Home page.
	 *
	 * @return String representing the title of the Home page.
	 */
	public String getHomePageTitle() {
		String title = page.title();
		System.out.println("Home page title : " + title);
		return title;
	}

	/**
	 * Retrieves the URL of the Home page.
	 *
	 * @return String representing the URL of the Home page.
	 */
	public String getHomePageURL() {
		String url = page.url();
		System.out.println("Home page URL is : " + url);
		return page.url();
	}

	/**
	 * Performs a search for a product on the Home page.
	 *
	 * @param productName The name of the product to search.
	 * @return String representing the search page header after performing the
	 *         search.
	 */
	public String doSearch(String productName) {
		page.fill(search, productName);

		page.click(searchIcon);
		return page.textContent(searchPageHeader);
	}

	/**
	 * Navigates to the Login page from the Home page.
	 *
	 * @return LoginPage instance after navigating to the Login page.
	 */
	public LoginPage navigateToLoginPage() {
		page.click(myAccountBtn);
		page.click(loginLink);
		return new LoginPage(page);
	}
}
