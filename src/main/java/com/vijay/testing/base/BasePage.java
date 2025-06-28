package com.vijay.testing.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

    public WebElement findElement(By locator){
        return driver.findElement(locator);
    }

    public void clickElement(WebElement element){
        element.click();
    }

    public void clickElement(By locator){
        findElement(locator).click();
    }

    public void enterText(WebElement element,String text){
        element.clear();
        element.sendKeys(text);
    }

    public String getText(WebElement element){
        return element.getText();
    }

    public String getUrl(WebDriver driver){
        return driver.getCurrentUrl();
    }


}