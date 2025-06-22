package com.example.seleniumtest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private WebDriver driver;

    // Example locator - change according to your HTML
    private By welcomeMessage = By.tagName("h1"); // assuming <h1>Welcome...</h1> exists

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    // Validate page title
    public boolean isTitleCorrect(String expectedTitle) {
        return driver.getTitle().equals(expectedTitle);
    }

    // Validate welcome message presence
    public boolean isWelcomeMessageDisplayed() {
        return driver.findElement(welcomeMessage).isDisplayed();
    }

    // Get welcome message text (optional)
    public String getWelcomeMessageText() {
        return driver.findElement(welcomeMessage).getText();
    }
}

