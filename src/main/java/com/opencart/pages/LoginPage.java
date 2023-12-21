package com.opencart.pages;

import com.opencart.factory.AllBrowsers;

public class LoginPage extends AllBrowsers {

	// String Locators - Object Repository
	private String emailId = "#input-email";
	private String password = "#input-password";
	private String loginBtn = "[type='submit']";
	private String accountHeader = "//h2[text()='My Account']";

	// Page Methods
	public String getLoginPageTitle() {
		String title = page.title();
		System.out.println("Login page title is : " + title);
		return title;
	}

	public String getLoginPageURL() {
		String url = page.url();
		System.out.println("Login page url is : " + url);
		return url;
	}

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
