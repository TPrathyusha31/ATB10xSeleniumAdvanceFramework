package com.SeleniumPractice.pages.pageObjectModel.katalonCura;

import com.SeleniumPractice.base.CommonToAllPage;
import com.SeleniumPractice.utils.waitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MakeAppointmentPage_POM extends CommonToAllPage {

    WebDriver driver;

    public MakeAppointmentPage_POM(WebDriver driver){
        this.driver = driver;
    }

    //page locators

    private By appointment_btn = By.id("btn-make-appointment");

    //page Actions
    public void ClickOnAppointmentBtn(){
        openKatalonURL();
        waitHelpers.waitJVM(3000);
        clickElement(appointment_btn);
    }
}
