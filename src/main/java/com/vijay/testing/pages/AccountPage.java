package com.vijay.testing.pages;

import com.vijay.testing.base.BasePage;
import com.vijay.testing.utils.PropertyReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.vijay.testing.utils.DropDownUtility.*;

public class AccountPage extends BasePage {

    public AccountPage(WebDriver driver){
        super(driver);
    }

    @FindBy(id = "password")
    private WebElement passwordInputField;

    @FindBy(id = "days")
    private WebElement dayDropDown;

    @FindBy(id = "months")
    private WebElement monthsDropDown;

    @FindBy(id = "years")
    private WebElement yearsDropDown;


    public void registeringAccountWithUserDetails(){

        enterText(passwordInputField, PropertyReader.readKey("user-password"));

        selectByValue(dayDropDown,"6");
        selectByIndex(monthsDropDown,4);
        selectByText(yearsDropDown,"2006");

    }
}
