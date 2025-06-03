package com.SeleniumPractice.tests.POM.AppVWO;

import com.SeleniumPractice.pages.pageObjectModel.appvwo.Normal_POM.DashboardPageVWO_POM;
import com.SeleniumPractice.pages.pageObjectModel.appvwo.Normal_POM.LoginPageVWO_POM;
import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestVWOLogin_01_NormalScript_POM {
    @Description("Verify that with invalid username and password, error message is shown")
    @Test
    public void test_negativecase_invalidCreds(){

        //driverManager code
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--start-maximized");
        edgeOptions.addArguments("--incognito");

        //Page Class Code(POM Code)
        WebDriver driver = new EdgeDriver(edgeOptions);
        LoginPageVWO_POM loginPage = new LoginPageVWO_POM(driver);
        String error_msg = loginPage.LoginToVWOInvalidCreds("admin@123","123");

        //Assertions
        assertThat(error_msg).isNotBlank().isNotNull().isNotEmpty();
        Assert.assertEquals(error_msg,"Your email, password, IP address or location did not match");

        driver.quit();

    }
    @Description("Verify that with valid username and password, user is landed on dashboard page and name is shown on the top")
    @Test
    public void test_positivecase_validCreds() {

        WebDriver driver = new EdgeDriver();
        LoginPageVWO_POM loginPage_positive = new LoginPageVWO_POM(driver);
        loginPage_positive.LoginToVWOValidCreds("contact+aug@thetestingacademy.com","TtxkgQ!s$rJBk85");
        DashboardPageVWO_POM dashboardPage = new DashboardPageVWO_POM(driver);
        String loggedInUsername = dashboardPage.LoggedInUser();


        //Assertions
        assertThat(loggedInUsername).isNotEmpty().isNotNull().isNotBlank();
        Assert.assertEquals(loggedInUsername,"Aman");

        driver.quit();
    }

    }
