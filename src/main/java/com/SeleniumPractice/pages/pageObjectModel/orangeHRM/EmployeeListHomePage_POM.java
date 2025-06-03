package com.SeleniumPractice.pages.pageObjectModel.orangeHRM;

import com.SeleniumPractice.base.CommonToAllPage;
import com.SeleniumPractice.utils.waitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EmployeeListHomePage_POM extends CommonToAllPage {

    WebDriver driver;
    public EmployeeListHomePage_POM(WebDriver driver){
        this.driver=driver;
    }

    //page locators
    private By loggedInUserName = By.xpath("//h6[text()='PIM']");

    //page actions
    public String LoggedInUserName(){
        waitHelpers.waitJVM(3000);
        return getText(loggedInUserName);
    }
}
