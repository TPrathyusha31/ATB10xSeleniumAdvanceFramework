package com.SeleniumPractice.tests.POM.AppVWO;

import com.SeleniumPractice.driver.DriverManager;
import com.SeleniumPractice.pages.pageObjectModel.appvwo.Normal_POM.DashboardPageVWO_POM;
import com.SeleniumPractice.pages.pageObjectModel.appvwo.Normal_POM.LoginPageVWO_POM;
import com.SeleniumPractice.utils.ProperitiesReader;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestVWOLogin_02_DriverManager_PropertyReader_POM {
    @Description("Verify that with invalid username and password, error message is shown")
    @Test
    public void test_negativecase_invalidCreds(){

        //driverManager code
        DriverManager.init();

        //Page Class Code(POM Code)
        LoginPageVWO_POM loginPage = new LoginPageVWO_POM(DriverManager.getDriver());
        String error_msg = loginPage.LoginToVWOInvalidCreds(ProperitiesReader.readKey("invalid_username"),ProperitiesReader.readKey("invalid_password"));

        //Assertions
        assertThat(error_msg).isNotBlank().isNotNull().isNotEmpty();
        Assert.assertEquals(error_msg,ProperitiesReader.readKey("error_message"));

        DriverManager.getDriver().quit();

    }
    @Description("Verify that with valid username and password, user is landed on dashboard page and name is shown on the top")
    @Test
    public void test_positivecase_validCreds() {

       DriverManager.init();

        LoginPageVWO_POM loginPage_positive = new LoginPageVWO_POM(DriverManager.getDriver());
        loginPage_positive.LoginToVWOValidCreds(ProperitiesReader.readKey("valid_username"),ProperitiesReader.readKey("valid_password"));
        DashboardPageVWO_POM dashboardPage = new DashboardPageVWO_POM(DriverManager.getDriver());
        String loggedInUsername = dashboardPage.LoggedInUser();


        //Assertions
        assertThat(loggedInUsername).isNotEmpty().isNotNull().isNotBlank();
        Assert.assertEquals(loggedInUsername,ProperitiesReader.readKey("expected_username"));

        DriverManager.getDriver().quit();
    }


}
