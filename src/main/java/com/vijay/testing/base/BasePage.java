package com.vijay.testing.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    protected WebDriver driver;

    // Constructor
    public BasePage(WebDriver driver) {
        this.driver = driver;

        // Initialize all the WebElements declared using @FindBy in child classes
        PageFactory.initElements(driver, this);
    }
}