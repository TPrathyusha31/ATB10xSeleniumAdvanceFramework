package com.SeleniumPractice.base;

import com.SeleniumPractice.driver.DriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;




public class CommonToAllTests {

    @BeforeTest
    public void setUP(){
     DriverManager.init();
    }

    @AfterTest
    public void tearDown(){
        DriverManager.close();
    }
}
