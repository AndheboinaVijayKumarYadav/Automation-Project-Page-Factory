package com.vijay.testing.base;

import com.vijay.testing.driver.DriverManager;
import com.vijay.testing.utils.PropertyReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
       // Initialize browser base on browser value in properties file
        DriverManager.initDriver();

    }

    @AfterMethod
    public void tearDown() {
        // Quit the browser after each test
       DriverManager.down();
    }
}
