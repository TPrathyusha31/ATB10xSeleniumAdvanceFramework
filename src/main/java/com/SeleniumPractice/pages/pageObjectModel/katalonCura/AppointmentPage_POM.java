package com.SeleniumPractice.pages.pageObjectModel.katalonCura;

import com.SeleniumPractice.base.CommonToAllPage;
import com.SeleniumPractice.driver.DriverManager;
import com.SeleniumPractice.utils.waitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class AppointmentPage_POM extends CommonToAllPage {
    WebDriver driver;

    public AppointmentPage_POM(WebDriver driver){
        this.driver = driver;
    }

    //page locators
   private  By dropdown = By.id("combo_facility");
   private By checkbox = By.id("chk_hospotal_readmission");
  private By radio_btn = By.id("radio_program_medicare");
  private By date_inputBox = By.id("txt_visit_date");
  private By Comment_box = By.id("txt_comment");
  private By book_appointment_CTA = By.id("btn-book-appointment");
  private By confirmation_text = By.tagName("h2");

   // page actions
    public String AppointmentBasedOnHealthcareProgram(String date,String comment){

        Select select1 = new Select(driver.findElement(dropdown));
        select1.selectByIndex(0);
        clickElement(checkbox);
        clickElement(radio_btn);
        enterInput(date_inputBox,date);
        enterInput(Comment_box,comment);
        clickElement(book_appointment_CTA);

        return getText(confirmation_text);
    }
}
