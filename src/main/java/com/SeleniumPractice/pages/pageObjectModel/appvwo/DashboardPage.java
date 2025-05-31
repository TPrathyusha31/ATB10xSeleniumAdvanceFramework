package com.SeleniumPractice.pages.pageObjectModel.appvwo;

import com.SeleniumPractice.utils.waitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage {
    WebDriver driver;

    public DashboardPage(WebDriver driver){
        this.driver = driver;
    }

    //Page Locators
    private By userNameOnDashboard = By.xpath("//span[@data-qa='lufexuloga']");

    //PageActions
    public String LoggedInUser(){
        waitHelpers.checkVisibility(driver,userNameOnDashboard);
        return driver.findElement(userNameOnDashboard).getText();
    }
}
