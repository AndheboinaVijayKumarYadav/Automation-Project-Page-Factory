package com.vijay.testing.tests;

import com.vijay.testing.base.BaseTest;
import com.vijay.testing.driver.DriverManager;
import com.vijay.testing.pages.AccountPage;
import com.vijay.testing.pages.HomePage;
import com.vijay.testing.pages.LoginPage;
import com.vijay.testing.utils.PropertyReader;
import jdk.jfr.Description;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.net.Priority;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RegisterTest extends BaseTest {

    public static final Logger logger = LogManager.getLogger(RegisterTest.class);


    @Description("Verify User Registration")
    @Test(priority = 1, groups = {"regression","sanity"})
    public void testUserRegistration() throws InterruptedException {

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
        logger.info("Navigated to Login page");

        String actualLoginUrl = loginPage.getUrl(DriverManager.getDriver());
        String expectedLoginUrl = PropertyReader.readKey("login-url");
        assertThat(actualLoginUrl).overridingErrorMessage("Actual Login Url is not matching with Expected").isEqualTo(expectedLoginUrl);

        String actualUserInputText = loginPage.newUserText();
        String expectedUserInputText = PropertyReader.readKey("userInputText");

//        Assert.assertEquals(ActualUserInputText,ExpectedUserInputText,"Actual and Expected User Input Text do not match");
        assertThat(actualUserInputText).overridingErrorMessage("Actual Input Text is not matching with Expected").isEqualTo(expectedUserInputText);


        String userName = PropertyReader.readKey("username");
        String userEmail = PropertyReader.readKey("user-email");

        AccountPage accountPage = loginPage.createAccountWithNewUser(userName,userEmail);
        logger.info("Navigated to Account Page");

        String actualSignUpUrl = accountPage.getUrl(DriverManager.getDriver());
        System.out.println(actualSignUpUrl);
        String expectedSingUpUrl = PropertyReader.readKey("signUp-url");
        System.out.println(expectedSingUpUrl);
        assertThat(actualSignUpUrl).overridingErrorMessage("Actual SignUp Url is not matching with Expected Url").isEqualTo(expectedSingUpUrl);

        accountPage.registeringAccountWithUserDetails();
    }

}
