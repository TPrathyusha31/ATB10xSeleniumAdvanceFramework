package com.SeleniumPractice.tests.POM.AppVWO;

import com.SeleniumPractice.UtilsTest.UtilsExcel_ToReadData_ForDataDrivenTesting;
import com.SeleniumPractice.base.CommonToAllTests;
import com.SeleniumPractice.driver.DriverManager;
import com.SeleniumPractice.pages.pageObjectModel.appvwo.Improved_POM.LoginPageVWO_ImprovedPOM;
import com.SeleniumPractice.utils.ProperitiesReader;
import com.SeleniumPractice.utils.waitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import static com.SeleniumPractice.driver.DriverManager.getDriver;

public class TestVWOLogin_05_DataDrivenTesting  extends CommonToAllTests {

    @Test(dataProvider = "getData")
    public void test_LoginVWO(String email, String password){
        System.out.println( email + " / " + password);

        LoginPageVWO_ImprovedPOM loginPageVWOImprovedPOM = new LoginPageVWO_ImprovedPOM(getDriver());
        String error_mesg = loginPageVWOImprovedPOM.LoginToVWOInvalidCreds(email,password);


        Assert.assertEquals(error_mesg, ProperitiesReader.readKey("error_message"));

    }

    @DataProvider
    public Object[][] getData(){

        return UtilsExcel_ToReadData_ForDataDrivenTesting.getTestDataFromExcel("sheet1");
    }

}
