package com.vijay.testing.pages;

import com.vijay.testing.base.BasePage;
import com.vijay.testing.driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver); // Calls BasePage's constructor and initializes PageFactory
    }

    @FindBy(xpath = "//h2[contains(text(),'User')]")
    private WebElement newUser;

    @FindBy(xpath = "//input[@data-qa='signup-name']")
    private WebElement newUserNameInputField;

    @FindBy(xpath = "//input[@data-qa='signup-email']")
    private WebElement newUserEmailInputField;

    @FindBy(xpath = "//button[text()='Signup']")
    private WebElement signupButton;


    public String newUserText(){
        return getText(newUser);
    }

    public AccountPage createAccountWithNewUser(String username, String email){

        enterText(newUserNameInputField,username);
        enterText(newUserEmailInputField,email);

        clickElement(signupButton);

        return new AccountPage(DriverManager.getDriver());
    }

}
