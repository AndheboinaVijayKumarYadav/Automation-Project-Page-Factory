package com.vijay.testing.base;

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
        // Automatically sets up ChromeDriver binary
        WebDriverManager.chromedriver().setup();

        // Initialize Chrome browser
        driver = new ChromeDriver();

        // Maximize the window
        driver.manage().window().maximize();

        // Set implicit wait (optional for PageFactory, but helpful in general)
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Navigate to the base URL (you can externalize this in a config file later)
        driver.get("https://automationexercise.com");  // Replace with your actual site URL
    }

    @AfterMethod
    public void tearDown() {
        // Quit the browser after each test
        if (driver != null) {
            driver.quit();
        }
    }
}
