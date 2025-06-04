package com.SeleniumPractice.tests.POM.OrangeHRM;

import com.SeleniumPractice.base.CommonToAllTests;
import com.SeleniumPractice.driver.DriverManager;
import com.SeleniumPractice.pages.pageObjectModel.orangeHRM.EmployeeListHomePage_POM;
import com.SeleniumPractice.pages.pageObjectModel.orangeHRM.LoginpageOrangeHRM_POM;
import com.SeleniumPractice.utils.ProperitiesReader;
import io.qameta.allure.Description;
import org.assertj.core.api.AssertionsForClassTypes;
import org.testng.Assert;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class TestOrangeHRM_01_POM extends CommonToAllTests {

    @Description("TC#1 - Verify that with invalid username and password, error message is shown")

    @Test
    public void test_negativeCase_invalidCreds(){

        LoginpageOrangeHRM_POM loginpage = new LoginpageOrangeHRM_POM(DriverManager.getDriver());
        String error_msg = loginpage.LoginUsingInvalidCreds(ProperitiesReader.readKey("invalid_ohrusername"),ProperitiesReader.readKey("invalid_ohrpassword"));

       assertThat(error_msg).isNotEmpty().isNotNull().isNotBlank();

        Assert.assertEquals(error_msg,"Invalid credentials");
    }

    @Description("TC#2 - Verify that with valid username and password,user is landed on employeekistpage page")

    @Test
    public void test_positiveCase_validCreds(){
        LoginpageOrangeHRM_POM loginpage = new LoginpageOrangeHRM_POM(DriverManager.getDriver());
        loginpage.LoginUsingValidCreds(ProperitiesReader.readKey("valid_ohrusername"),ProperitiesReader.readKey("valid_ohrpassword"));

        EmployeeListHomePage_POM employeeListPage = new EmployeeListHomePage_POM(DriverManager.getDriver());
        String loggedInUser = employeeListPage.LoggedInUserName();

        Assert.assertEquals(loggedInUser,ProperitiesReader.readKey("ohr_expected_username"));
    }

}
