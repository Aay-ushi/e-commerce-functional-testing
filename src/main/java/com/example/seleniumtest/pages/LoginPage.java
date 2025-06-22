package com.example.seleniumtest.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	WebDriver driver;
    By username = By.name("username");
    By password = By.name("password");
    By loginBtn = By.tagName("button");
		By invalidCredentialMessage=By.xpath("//*[@data-testid='invalid-credential']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void login(String user, String pass) {
        driver.findElement(username).sendKeys(user);
        driver.findElement(password).sendKeys(pass);
        driver.findElement(loginBtn).click();
    }

		@SuppressWarnings("deprecation")
		public boolean isInvalidCredentialMessageDisplayed(){
			driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
			return driver.findElement(invalidCredentialMessage).isDisplayed();
		}

}
