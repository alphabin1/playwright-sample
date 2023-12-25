package com.opencart.pages;

import com.microsoft.playwright.Page;
import com.opencart.factory.Browsers;

/**
 * Page class for Login Page functionalities.
 */
public class LoginPage extends Browsers {

	Page page;

	// String Locators - Object Repository
	private String emailId = "#input-email";
	private String password = "#input-password";
	private String loginBtn = "[type='submit']";
	private String accountHeader = "#content > h2:first-of-type";

	/**
	 * Constructs a LoginPage object with the provided Page instance.
	 *
	 * @param page The Playwright Page instance.
	 */
	public LoginPage(Page page) {
		this.page = page;
	}

	/**
	 * Retrieves the title of the Login page.
	 *
	 * @return String representing the title of the Login page.
	 */
	public String getLoginPageTitle() {
		String title = page.title();
		System.out.println("Login page title is : " + title);
		return title;
	}

	/**
	 * Retrieves the URL of the Login page.
	 *
	 * @return String representing the URL of the Login page.
	 */
	public String getLoginPageURL() {
		String url = page.url();
		System.out.println("Login page url is : " + url);
		return url;
	}

	/**
	 * Performs login action with provided credentials.
	 *
	 * @param emailID User's email ID for login.
	 * @param pwd     User's password for login.
	 * @return Boolean representing the login success status.
	 */
	public boolean doLogin(String emailID, String pwd) {
		page.fill(emailId, emailID);
		page.fill(password, pwd);
		page.click(loginBtn);

		if (page.isVisible(accountHeader)) {
			System.out.println("User is logged in successfully..." + '\n');
			return true;
		} else {
			System.out.println("User is not able to login" + '\n');
			return false;
		}
	}
}
