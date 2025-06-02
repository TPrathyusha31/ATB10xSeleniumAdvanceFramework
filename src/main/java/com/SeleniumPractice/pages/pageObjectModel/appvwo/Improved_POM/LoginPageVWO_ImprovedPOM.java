package com.SeleniumPractice.pages.pageObjectModel.appvwo.Improved_POM;

import com.SeleniumPractice.base.CommonToAllPage;
import com.SeleniumPractice.utils.waitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPageVWO_ImprovedPOM extends CommonToAllPage {
    WebDriver driver;

    //constructor
    public LoginPageVWO_ImprovedPOM(WebDriver driver){

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
        openVWOURL();
        enterInput(username,user);
        enterInput(password,pwd);
        clickElement(signin_btn);
        //wait --> explicit wait
        waitHelpers.checkVisibility(driver,error_message,3000);
        return getText(error_message);
    }

    public void LoginToVWOValidCreds(String user, String pwd) {
        openVWOURL();
        enterInput(username,user);
        enterInput(password,pwd);
        clickElement(signin_btn);

        //wait
        waitHelpers.waitJVM(3000);
    }

}