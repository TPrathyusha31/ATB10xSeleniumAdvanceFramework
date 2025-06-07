package com.SeleniumPractice.pages.pageObjectModel.orangeHRM;

import com.SeleniumPractice.base.CommonToAllPage;
import com.SeleniumPractice.driver.DriverManager;
import com.SeleniumPractice.utils.ProperitiesReader;
import com.SeleniumPractice.utils.waitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginpageOrangeHRM_POM extends CommonToAllPage{
    WebDriver driver;
    public  LoginpageOrangeHRM_POM(WebDriver driver){
        this.driver=driver;
    }

    //Page locators
    private By  username = By.xpath("input[placeholder='Username']");
    private By  password = By.xpath("//input[@name='password']");
    private By Login_btn = By.xpath("//button[text()=' Login ']");
    private By error_message =  By.xpath("//p[text()='Invalid credentials']");

    //Page Actions
    public String LoginUsingInvalidCreds(String user, String pwd){
        openOrangeHRMURL();
        waitHelpers.waitJVM(5000);
        enterInput(username,user);
        enterInput(password,pwd);
        clickElement(Login_btn);
        waitHelpers.checkVisibility(DriverManager.getDriver(),error_message,4000);
        return getText(error_message);
    }

    public void LoginUsingValidCreds(String user, String pwd) {
        openOrangeHRMURL();
        waitHelpers.waitJVM(3000);
        enterInput(username,user);
        enterInput(password,pwd);
        clickElement(Login_btn);
    }




}
