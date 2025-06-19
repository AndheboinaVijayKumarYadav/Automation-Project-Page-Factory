package com.vijay.testing.tests;

import com.vijay.testing.base.BaseTest;
import com.vijay.testing.driver.DriverManager;
import com.vijay.testing.pages.HomePage;
import com.vijay.testing.utils.PropertyReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {



    @Test
    public void testSignupLogin(){
        // Read the url from properties file
        String url = PropertyReader.readKey("url");

        if(url != null && !url.isEmpty()){
            DriverManager.getDriver().get(url);
        }
        else {
            throw new RuntimeException("Base URL is missing or empty in data.properties");
        }

        // Initialize HomePage object
        HomePage homePage = new HomePage(DriverManager.getDriver());

        // Get the page title and expected title
        String pageTitle = homePage.getPageTitle();
        String expectedTitle = PropertyReader.readKey("pagetitle");

        // Assertion to verify page title
        Assert.assertEquals(pageTitle,expectedTitle,"Actual and Expected page title do not match");

        // Assertion to verify is SignUp / Login is Displayed
        Assert.assertTrue(homePage.isSignupLoginDisplayed(),"Signup/Login is not displayed on homepage");
    }
}
