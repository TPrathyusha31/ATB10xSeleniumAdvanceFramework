package com.SeleniumPractice.pages.pageFactory.appvwo;

import com.SeleniumPractice.base.CommonToAllPage;
import com.SeleniumPractice.driver.DriverManager;
import com.SeleniumPractice.utils.waitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageVWO_PF extends CommonToAllPage {
    WebDriver driver;
    public LoginPageVWO_PF(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    //step 1 --> Page locators
    @FindBy(id ="login-username")
    private WebElement username;

    @FindBy(id ="login-password")
    private WebElement password;

    @FindBy(id ="js-login-btn")
    private WebElement signin_btn;

    @FindBy(id="js-notification-box-msg")
    private WebElement error_message;


    //Page actions
    public String LoginToVWOInvalidCreds(String user, String pwd){
        openVWOURL();
        enterInput(username,user);
        enterInput(password,pwd);
        clickElement(signin_btn);
        //wait --> explicit wait
        waitHelpers.checkVisibility(driver,error_message);
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
