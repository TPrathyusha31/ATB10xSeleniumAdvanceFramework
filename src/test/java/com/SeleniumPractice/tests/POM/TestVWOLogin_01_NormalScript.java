package com.SeleniumPractice.tests.POM;

import com.SeleniumPractice.pages.pageObjectModel.appvwo.DashboardPage;
import com.SeleniumPractice.pages.pageObjectModel.appvwo.LoginPage;
import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestVWOLogin_01_NormalScript {
    @Description("Verify that with invalid username and password, error message is shown")
    @Test
    public void test_negativecase_invalidCreds(){

        //driverManager code
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--start-maximized");
        edgeOptions.addArguments("--incognito");

        //Page Class Code(POM Code)
        WebDriver driver = new EdgeDriver(edgeOptions);
        LoginPage loginPage = new LoginPage(driver);
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
        LoginPage loginPage_positive = new LoginPage(driver);
        loginPage_positive.LoginToVWOValidCreds("contact+aug@thetestingacademy.com","TtxkgQ!s$rJBk85");
        DashboardPage dashboardPage = new DashboardPage(driver);
        String loggedInUsername = dashboardPage.LoggedInUser();

        assertThat(loggedInUsername).isNotEmpty().isNotNull().isNotBlank();
        Assert.assertEquals(loggedInUsername,"Aman");

        driver.quit();
    }

    }
