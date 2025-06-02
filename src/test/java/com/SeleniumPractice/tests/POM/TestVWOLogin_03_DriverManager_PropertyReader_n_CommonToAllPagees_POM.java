package com.SeleniumPractice.tests.POM;

import com.SeleniumPractice.driver.DriverManager;
import com.SeleniumPractice.pages.pageObjectModel.appvwo.Improved_POM.DashboardPageVWO_ImprovedPOM;
import com.SeleniumPractice.pages.pageObjectModel.appvwo.Improved_POM.LoginPageVWO_ImprovedPOM;
import com.SeleniumPractice.pages.pageObjectModel.appvwo.Normal_POM.DashboardPageVWO_POM;
import com.SeleniumPractice.pages.pageObjectModel.appvwo.Normal_POM.LoginPageVWO_POM;
import com.SeleniumPractice.utils.ProperitiesReader;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestVWOLogin_03_DriverManager_PropertyReader_n_CommonToAllPagees_POM {
    @Description("Verify that with invalid username and password, error message is shown")
    @Test
    public void test_negativecase_invalidCreds(){

        //driverManager code
        DriverManager.init();

        //Page Class Code(POM Code)
        LoginPageVWO_ImprovedPOM loginPage = new LoginPageVWO_ImprovedPOM(DriverManager.getDriver());
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

        LoginPageVWO_ImprovedPOM loginPage_positive = new LoginPageVWO_ImprovedPOM(DriverManager.getDriver());
        loginPage_positive.LoginToVWOValidCreds(ProperitiesReader.readKey("valid_username"),ProperitiesReader.readKey("valid_password"));
        DashboardPageVWO_ImprovedPOM dashboardPage = new DashboardPageVWO_ImprovedPOM(DriverManager.getDriver());
        String loggedInUsername = dashboardPage.LoggedInUser();


        //Assertions
        assertThat(loggedInUsername).isNotEmpty().isNotNull().isNotBlank();
        Assert.assertEquals(loggedInUsername,ProperitiesReader.readKey("expected_username"));

        DriverManager.getDriver().quit();
    }



}
