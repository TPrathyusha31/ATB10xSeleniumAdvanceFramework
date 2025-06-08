package com.SeleniumPractice.tests.POM.AppVWO;

import com.SeleniumPractice.Listeners.RetryAnalyzer;
import com.SeleniumPractice.Listeners.RetryListener;
import com.SeleniumPractice.base.CommonToAllTests;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.SeleniumPractice.driver.DriverManager.getDriver;

@Test(retryAnalyzer = RetryAnalyzer.class)
public class TestVWOLogin_06_RetryListeners extends CommonToAllTests{

   // private static final Logger logger = LogManager.getLogger(TestVWOLogin_06_RetryListeners.class);

        @Owner("Prathyusha")
        @Description("Verify that invalid creds give error message")
        @Test
        public void testFail() {
            getDriver().get("https://app.vwo.com");
          //  logger.info("Starting the Testcases Page Object Model");
            Assert.assertTrue(false);
        }

        @Owner("Prathyusha")
        @Description("Verify that invalid creds give error message")
        @Test
        public void testPass() {
            getDriver().get("https://app.vwo.com");
          //  logger.info("Starting the Testcases Page Object Model");
            Assert.assertTrue(true);
        }

}
