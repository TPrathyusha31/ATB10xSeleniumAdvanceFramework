package com.SeleniumPractice.pages.pageObjectModel.appvwo.Normal_POM;

import com.SeleniumPractice.utils.waitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPageVWO_POM { //Page class --> two things -->Page locators and Page actions
    WebDriver driver;

    //constructor
   public LoginPageVWO_POM(WebDriver driver){

        this.driver = driver;

    }

    //step 1 --> Page locators
    private By username = By.id("login-username");
    private By password = By.id("login-password");
    private By signin_btn = By.id("js-login-btn");
    private By error_message = By.id("js-notification-box-msg");
    // private By signinSSO = By.xpath("//button[@data-qa='dobevozose']"); --> not used hence commented out

    //step 2 --> Page actions
    public String LoginToVWOInvalidCreds(String user, String pwd){
        driver.get("https://app.vwo.com/#/login");
        driver.findElement(username).sendKeys(user);
        driver.findElement(password).sendKeys(pwd);
        driver.findElement(signin_btn).click();

        //wait --> explicit wait
        waitHelpers.checkVisibility(driver,error_message,3000);

        String error_msg_text = driver.findElement(error_message).getText();
        return error_msg_text;
    }

    public void LoginToVWOValidCreds(String user, String pwd) {
        driver.get("https://app.vwo.com/#/login");
        driver.findElement(username).sendKeys(user);
        driver.findElement(password).sendKeys(pwd);
        driver.findElement(signin_btn).click();

        //wait
        waitHelpers.waitJVM(3000);
    }

}

