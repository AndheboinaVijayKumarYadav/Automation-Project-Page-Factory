package com.vijay.testing.tests;

import com.vijay.testing.base.BaseTest;
import com.vijay.testing.driver.DriverManager;
import com.vijay.testing.pages.AccountPage;
import com.vijay.testing.pages.HomePage;
import com.vijay.testing.pages.LoginPage;
import com.vijay.testing.utils.PropertyReader;
import jdk.jfr.Description;
import org.apache.logging.log4j.core.net.Priority;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterTest extends BaseTest {


    @Description("Verify User Registration")
    @Test(priority = 1, groups = {"regression","sanity"})
    public void testUserRegistration(){

        String url = PropertyReader.readKey("url");

        if(url != null && !url.isEmpty()){
            DriverManager.getDriver().get(url);
        }
        else {
            throw new RuntimeException("Base URL is missing or empty in data.properties");
        }

        // Initialize HomePage object
        HomePage homePage = new HomePage(DriverManager.getDriver());

        //Initialize LoginPage object
        LoginPage loginPage = homePage.navigateToLoginPage();

        String ActualUserInputText = loginPage.newUserText();
        String ExpectedUserInputText = PropertyReader.readKey("userInputText");

        Assert.assertEquals(ActualUserInputText,ExpectedUserInputText,"Actual and Expected User Input Text do not match");

        String userName = PropertyReader.readKey("username");
        String userEmail = PropertyReader.readKey("useremail");

        AccountPage accountPage = loginPage.createAccountWithNewUser(userName,userEmail);

    }

}
