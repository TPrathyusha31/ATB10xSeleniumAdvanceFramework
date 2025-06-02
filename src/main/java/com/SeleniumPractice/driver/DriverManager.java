package com.SeleniumPractice.driver;

import com.SeleniumPractice.utils.ProperitiesReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverManager {

    private static WebDriver driver;

    public static WebDriver getDriver() {
        return driver;
    }

    public static void setDriver(WebDriver driver) {
        DriverManager.driver = driver;
    }

    //when we want to start the browser
    public static void init(){
       String browser = ProperitiesReader.readKey("browser");
        browser.toLowerCase();

        switch(browser) {
            case "edge" :
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--start-maximized");
                edgeOptions.addArguments("--incognito");
                driver = new EdgeDriver(edgeOptions);
                break;
            case "chrome" :
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--start-maximized");
                chromeOptions.addArguments("--incognito");
               driver = new ChromeDriver(chromeOptions);
               break;
            case "firefox" :
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("--start-maximized");
                firefoxOptions.addArguments("--incognito");
                driver = new FirefoxDriver(firefoxOptions);
                break;
            default:
                System.out.println("The Provided browser is not supported!");

        }
    }

    //when we want to close the browser
    public static void close(){
             driver.quit();
    }
}
