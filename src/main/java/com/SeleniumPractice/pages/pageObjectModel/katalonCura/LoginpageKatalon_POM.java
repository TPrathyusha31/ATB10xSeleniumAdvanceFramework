package com.SeleniumPractice.pages.pageObjectModel.katalonCura;

import com.SeleniumPractice.base.CommonToAllPage;
import com.SeleniumPractice.driver.DriverManager;
import com.SeleniumPractice.utils.waitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginpageKatalon_POM extends CommonToAllPage {
    WebDriver driver;

    public LoginpageKatalon_POM(WebDriver driver) {
        this.driver = driver;
    }

    //page locators

    private By username_katalon = By.id("txt-username");
    private By password_katalon = By.id("txt-password");
    private By Login_button = By.id("btn-login");
    private By error_text = By.className("lead text-danger");

    //Page actions

    public String LoginWithInvalidCreds(String usser, String passwrd) {
        enterInput(username_katalon, usser);
        enterInput(password_katalon, passwrd);
        waitHelpers.waitJVM(5000);
        clickElement(Login_button);
        waitHelpers.checkVisibility(DriverManager.getDriver(), error_text, 5000);
        return getText(error_text);
    }

    public void LoginWithValidCreds(String usser, String passwrd) {
        enterInput(username_katalon, usser);
        enterInput(password_katalon, passwrd);
        clickElement(Login_button);
    }
}
