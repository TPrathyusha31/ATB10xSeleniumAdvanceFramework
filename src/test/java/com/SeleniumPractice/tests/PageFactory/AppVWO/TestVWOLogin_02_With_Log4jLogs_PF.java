package com.SeleniumPractice.tests.PageFactory.AppVWO;

import com.SeleniumPractice.base.CommonToAllTests;
import com.SeleniumPractice.driver.DriverManager;
import com.SeleniumPractice.pages.pageObjectModel.appvwo.Improved_POM.DashboardPageVWO_ImprovedPOM;
import com.SeleniumPractice.pages.pageObjectModel.appvwo.Improved_POM.LoginPageVWO_ImprovedPOM;
import com.SeleniumPractice.utils.ProperitiesReader;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.logging.LogManager;
import java.util.logging.Logger;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestVWOLogin_02_With_Log4jLogs_PF extends CommonToAllTests {

   private static final Logger logger = LogManager.getLogger(TestVWOLogin_02_With_Log4jLogs_PF.class);

    @Description("Verify that with invalid username and password, error message is shown")
    @Test
    public void test_negativecase_invalidCreds(){

        logger.info("Starting the test case page factory");
        LoginPageVWO_ImprovedPOM loginPage = new LoginPageVWO_ImprovedPOM(DriverManager.getDriver());
        String error_msg = loginPage.LoginToVWOInvalidCreds(ProperitiesReader.readKey("invalid_username"),ProperitiesReader.readKey("invalid_password"));
        logger.info("Ending the test case page factory");

        //Assertions
        assertThat(error_msg).isNotBlank().isNotNull().isNotEmpty();
        Assert.assertEquals(error_msg,ProperitiesReader.readKey("error_message"));

    }
    @Description("Verify that with valid username and password, user is landed on dashboard page and name is shown on the top")
    @Test
    public void test_positivecase_validCreds() {

        LoginPageVWO_ImprovedPOM loginPage_positive = new LoginPageVWO_ImprovedPOM(DriverManager.getDriver());
        loginPage_positive.LoginToVWOValidCreds(ProperitiesReader.readKey("valid_username"),ProperitiesReader.readKey("valid_password"));
        DashboardPageVWO_ImprovedPOM dashboardPage = new DashboardPageVWO_ImprovedPOM(DriverManager.getDriver());
        String loggedInUsername = dashboardPage.LoggedInUser();


        //Assertions
        assertThat(loggedInUsername).isNotEmpty().isNotNull().isNotBlank();
        Assert.assertEquals(loggedInUsername,ProperitiesReader.readKey("expected_username"));

    }
}
