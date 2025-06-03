package com.SeleniumPractice.tests.POM.KatalonCura;

import com.SeleniumPractice.base.CommonToAllTests;
import com.SeleniumPractice.driver.DriverManager;
import com.SeleniumPractice.pages.pageObjectModel.katalonCura.MakeAppointmentPage_POM;
import com.SeleniumPractice.utils.ProperitiesReader;
import com.SeleniumPractice.utils.waitHelpers;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestKatalon_01_POM extends CommonToAllTests {

    @Description("Verify that on clicking Make appointment, user is landed on login page")
    @Test
    public void test_CurrentURLOfLoginPage(){
        MakeAppointmentPage_POM makeAppointmentPage = new MakeAppointmentPage_POM(DriverManager.getDriver());
        makeAppointmentPage.ClickOnAppointmentBtn();

        waitHelpers.waitJVM(3000);

        Assert.assertEquals(DriverManager.getDriver().getCurrentUrl(), ProperitiesReader.readKey("LoginPage_url"));
    }

    @Description("Verify that with invalid username and password, error message is shown")
    @Test
    public void test_negativeCase_invalidDetails(){

    }

    @Description("Verify that with valid username and password,user is landed on appointment page")
    @Test
    public void test_positiveCase_validDetails() {
    }
  }

