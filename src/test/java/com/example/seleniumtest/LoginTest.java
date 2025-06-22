package com.example.seleniumtest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.example.seleniumtest.pages.HomePage;
import com.example.seleniumtest.pages.LoginPage;

import io.qameta.allure.Feature;

/**
 * Unit test for simple App.
 */
@Feature("Login Functionality")
public class LoginTest extends BaseTest{

    /**
     * Rigorous Test :-)
     */
    @Test
    public void validLogin() {
        LoginPage login = new LoginPage(driver);
        HomePage homePage=new HomePage(driver);
        login.login("admin", "password123");
        Assert.assertTrue(homePage.isWelcomeMessageDisplayed());
    }

    @Test
    public void invalidLogin() {
        LoginPage login = new LoginPage(driver);
        login.login("admin", "dfdfadsfadsfg");
        Assert.assertTrue(login.isInvalidCredentialMessageDisplayed());
    }

    @Test
    public void noPassword() {
        LoginPage login = new LoginPage(driver);
        login.login("admin", "");
        Assert.assertTrue(login.isInvalidCredentialMessageDisplayed());
    }

    
    @Test
    public void noUsername() {
        LoginPage login = new LoginPage(driver);
        login.login("", "jbjdgbs");
        Assert.assertTrue(login.isInvalidCredentialMessageDisplayed());
    }
}
