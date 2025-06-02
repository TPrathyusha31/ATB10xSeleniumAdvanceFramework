package com.SeleniumPractice.pages.pageObjectModel.appvwo.Improved_POM;

import com.SeleniumPractice.base.CommonToAllPage;
import com.SeleniumPractice.utils.waitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.SeleniumPractice.driver.DriverManager.getDriver;

public class DashboardPageVWO_ImprovedPOM extends CommonToAllPage {
    WebDriver driver;

    public DashboardPageVWO_ImprovedPOM(WebDriver driver) {
        this.driver = driver;
    }

    //Page Locators
    private By userNameOnDashboard = By.xpath("//span[@data-qa='lufexuloga']");

    //PageActions
    public String LoggedInUser() {
        waitHelpers.checkVisibility(driver, userNameOnDashboard);
        return getText(userNameOnDashboard);
    }
}