package com.opencart.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.opencart.base.BaseTest;
import com.opencart.constants.AppConstants;
import com.opencart.pages.HomePage;
import com.opencart.utils.PropertiesClass;

public class LoginPageTest extends BaseTest {

	@Test(priority = 1)
	public void loginPageTitleTest() {
		loginPage = new HomePage().navigateToLoginPage();
		Assert.assertEquals(loginPage.getLoginPageTitle().trim(), AppConstants.Login_PAGE_TITLE);
	}

	@Test(priority = 2)
	public void loginPageURLTest() {
		Assert.assertEquals(loginPage.getLoginPageURL().trim(), AppConstants.Login_PAGE_URL);

	}

	@Test(priority = 3)
	public void appLoginTest() {
		try {
			loginPage.doLogin(PropertiesClass.setUserName().trim(), PropertiesClass.setPassword().trim());

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
