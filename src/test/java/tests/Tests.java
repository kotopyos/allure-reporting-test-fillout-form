package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class Tests extends TestBase {
    @Test
    @Issue("Issue link")
    @Feature("User info form")
    @Story("Filling out user form")
    @Owner("staya_kotyat")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value="Form", url="https://demoqa.com/automation-practice-form")
    @DisplayName("Filling out form with valid data")
    void fillOutForm() {

        registrationPage
                .openPage()
                .setFirstName(data.nameFirst).setLastName(data.nameLast)
                .setEmail(data.email)
                .setGender(data.gender)
                .setPhone(data.phone)
                .setBirthDate(data.birthDateYear, data.birthDateMonth, data.birthDateDay)
                .setSubjects(data.subject)
                .setHobbies(data.hobby)
                .setImage(data.pictureUrl)
                .setCurrentAddress(data.currentAddress)
                .setState(data.state)
                .setCity(data.city)
                .clickSubmitButton()
                .verifyResultsModalAppears()
                .verifyTableData("Student Name", data.nameFirst + " " + data.nameLast)
                .verifyTableData("Student Email", data.email)
                .verifyTableData("Gender", data.gender)
                .verifyTableData("Mobile", data.phone)
                .verifyTableData("Date of Birth", data.birthDateDay + " " + data.birthDateMonth + "," + data.birthDateYear)
                .verifyTableData("Hobbies", data.hobby)
                .verifyTableData("Picture", data.pictureUrl)
                .verifyTableData("Address", data.currentAddress)
                .verifyTableData("State and City", data.state + " " + data.city)
                .verifyTableData("Subjects", data.subject);
    }
}
