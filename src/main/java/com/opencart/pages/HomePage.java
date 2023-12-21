package com.opencart.pages;

import com.opencart.factory.AllBrowsers;

public class HomePage extends AllBrowsers {

	// String Locators - Object Repository
	private String search = "//input[@name='search']";
	private String searchIcon = "#search button";
	private String searchPageHeder = "#content h1";
	private String myAccountBtn = "a[title='My Account']";
	private String loginLink = "//a[text()='Login']";

	// Page Methods
	public String getHomePageTitle() {
		String title = page.title();
		System.out.println("Home page title : " + title);
		return title;
	}

	public String getHomePageURL() {
		String url = page.url();
		System.out.println("Home page URL is : " + url);
		return page.url();
	}

	public String doSearch(String productName) {
		page.fill(search, productName);
		page.click(searchIcon);
		return page.textContent(searchPageHeder);
	}

	public LoginPage navigateToLoginPage() {
		page.click(myAccountBtn);
		page.click(loginLink);
		return new LoginPage();
	}
}
