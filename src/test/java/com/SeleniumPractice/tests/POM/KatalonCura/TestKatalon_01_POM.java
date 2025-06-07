package com.SeleniumPractice.tests.POM.KatalonCura;

import com.SeleniumPractice.base.CommonToAllTests;
import com.SeleniumPractice.driver.DriverManager;
import com.SeleniumPractice.pages.pageObjectModel.katalonCura.AppointmentPage_POM;
import com.SeleniumPractice.pages.pageObjectModel.katalonCura.LoginpageKatalon_POM;
import com.SeleniumPractice.pages.pageObjectModel.katalonCura.MakeAppointmentPage_POM;
import com.SeleniumPractice.utils.ProperitiesReader;
import com.SeleniumPractice.utils.waitHelpers;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestKatalon_01_POM extends CommonToAllTests {

    @Description("TC#1 - Verify that on clicking Make appointment, user is landed on login page")
    @Test
    public void test_CurrentURLOfLoginPage() {
        MakeAppointmentPage_POM makeAppointmentPage = new MakeAppointmentPage_POM(DriverManager.getDriver());
        makeAppointmentPage.ClickOnAppointmentBtn();

        waitHelpers.waitJVM(3000);

        Assert.assertEquals(DriverManager.getDriver().getCurrentUrl(), ProperitiesReader.readKey("LoginPage_url"));
    }

    @Description("TC#2 - Verify that with invalid username and password, error message is shown")
    @Test
    public void test_negativeCase_invalidDetails() {
        MakeAppointmentPage_POM makeAppointmentPage = new MakeAppointmentPage_POM(DriverManager.getDriver());
        makeAppointmentPage.ClickOnAppointmentBtn();

        LoginpageKatalon_POM loginpageKatalon = new LoginpageKatalon_POM(DriverManager.getDriver());
        String error_mesg = loginpageKatalon.LoginWithInvalidCreds(ProperitiesReader.readKey("invalid_katalonuser"), ProperitiesReader.readKey("invalid_katalonpwd"));

        assertThat(error_mesg).isNotBlank().isNotNull().isNotEmpty();
        Assert.assertEquals(error_mesg, ProperitiesReader.readKey("katalon_error_text"));
    }

    @Description("TC#3 - Verify that with valid username and password,user is landed on appointment page")
    @Test
    public void test_positiveCase_validDetails() {
        MakeAppointmentPage_POM makeAppointmentPage = new MakeAppointmentPage_POM(DriverManager.getDriver());
        makeAppointmentPage.ClickOnAppointmentBtn();

        LoginpageKatalon_POM loginpageKatalon1 = new LoginpageKatalon_POM(DriverManager.getDriver());
        loginpageKatalon1.LoginWithValidCreds(ProperitiesReader.readKey("valid_katalonuser"), ProperitiesReader.readKey("valid_katalonpwd"));
    }


    @Description("TC#4 - Verify the appointment booking")
    @Test
    public void test_bookAppointment() {
        MakeAppointmentPage_POM makeAppointmentPage = new MakeAppointmentPage_POM(DriverManager.getDriver());
        makeAppointmentPage.ClickOnAppointmentBtn();

        LoginpageKatalon_POM loginpageKatalon1 = new LoginpageKatalon_POM(DriverManager.getDriver());
        loginpageKatalon1.LoginWithValidCreds(ProperitiesReader.readKey("valid_katalonuser"), ProperitiesReader.readKey("valid_katalonpwd"));

        AppointmentPage_POM appointmentPage = new AppointmentPage_POM(DriverManager.getDriver());

        String Booking_confirmationText = appointmentPage.AppointmentBasedOnHealthcareProgram(ProperitiesReader.readKey("bookingDate"), ProperitiesReader.readKey("bookingComment"));
        Assert.assertEquals(Booking_confirmationText, ProperitiesReader.readKey("Appointment_booked_msg"));
    }

}