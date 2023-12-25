package com.opencart.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.opencart.base.BaseTest;
import com.opencart.constants.AppConstants;
import com.opencart.utils.PropertiesUtils;

/**
 * Contains test cases related to the Login page functionality.
 */
public class LoginPageTest extends BaseTest {

    /**
     * Verifies the Login page title.
     */
    @Test(priority = 1)
    public void loginPageTitleTest() {
        loginPage = homePage.navigateToLoginPage();
        Assert.assertEquals(loginPage.getLoginPageTitle().trim(), AppConstants.LOGIN_PAGE_TITLE);
    }

    /**
     * Verifies the Login page URL.
     */
    @Test(priority = 2)
    public void loginPageURLTest() {
        Assert.assertEquals(loginPage.getLoginPageURL().trim(), AppConstants.LOGIN_PAGE_URL);
    }

    /**
     * Tests the login functionality with valid credentials.
     */
    @Test(priority = 3)
    public void appLoginTest() {
        try {
            loginPage.doLogin(PropertiesUtils.setUserName().trim(), PropertiesUtils.setPassword().trim());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
