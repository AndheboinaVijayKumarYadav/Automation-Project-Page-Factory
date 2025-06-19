package com.vijay.testing.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    // WebDriver instance accessible to child page classes
    protected WebDriver driver;

    // Constructor to initialize the driver and PageFactory elements
    public BasePage(WebDriver driver) {
        this.driver = driver;

        // Initialize all the WebElements declared using @FindBy in child classes
        PageFactory.initElements(driver, this);
    }
}