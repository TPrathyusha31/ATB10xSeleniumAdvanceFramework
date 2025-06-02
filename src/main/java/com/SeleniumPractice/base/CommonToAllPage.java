package com.SeleniumPractice.base;

import com.SeleniumPractice.utils.ProperitiesReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.SeleniumPractice.driver.DriverManager.getDriver;

public class CommonToAllPage {

    public void openVWOURL(){
        //driver.get(url)
       getDriver().get(ProperitiesReader.readKey("url"));
    }

    public void enterInput(By by,String key){
        getDriver().findElement(by).sendKeys(key);
    }
    public void enterInput(WebElement by,String key){
        by.sendKeys(key);
    }

    public void clickElement(By by){
        getDriver().findElement(by).click();
    }
    public void clickElement(WebElement by){
         by.click();
    }
    public String getText(By by){
       return getDriver().findElement(by).getText();
    }
    public String getText(WebElement by){
       return by.getText();
    }
}

