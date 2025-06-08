package com.SeleniumPractice.tests.POM.AppVWO;

import com.SeleniumPractice.Listeners.RetryAnalyzer;
import com.SeleniumPractice.Listeners.ScreenshotListener;
import com.SeleniumPractice.base.CommonToAllTests;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.apache.logging.log4j.LogManager;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.logging.Logger;

import static com.SeleniumPractice.driver.DriverManager.getDriver;

@Listeners(ScreenshotListener.class)
@Test(retryAnalyzer = RetryAnalyzer.class)
public class TestVWOLogin_07_ScreenshotListeners extends CommonToAllTests {

    //private static final Logger logger = LogManager.getLogger(TestVWOLogin_07_ScreenshotListeners.class);

    @Owner("PRAMOD")
    @Description("Verify that invalid creds give error message")
    @Test
    public void testFail() {
        getDriver().get("https://app.vwo.com");
        //   logger.info("Starting the Testcases Page Object Model");
        Assert.assertTrue(false);
    }

    @Owner("PRAMOD")
    @Description("Verify that invalid creds give error message")
    @Test
    public void testPass() {
        getDriver().get("https://app.vwo.com");
        // logger.info("Starting the Testcases Page Object Model");
        Assert.assertTrue(true);
    }

}
