package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.components.CalendarComponent;
import pages.components.RegistrationResultsModal;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.timeout;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    CalendarComponent calendarComponent = new CalendarComponent();
    RegistrationResultsModal registrationResultsModal =
            new RegistrationResultsModal();
    private final SelenideElement
            userFirstNameInput = $("#firstName"),
            userLastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            userGenderSection = $("#genterWrapper"),
            userPhoneInput = $("#userNumber"),
            calendarSection = $("#dateOfBirthInput"),
            subjectsContainerInput = $("#subjectsContainer input"),
            hobbiesSection = $("#hobbiesWrapper"),
            imageUpdateField = $("input#uploadPicture"),
            currentAddressInput = $("#currentAddress"),
            stateField = $(byText("Select State")),
            cityField = $("#city"),
            submitButton = $("button#submit");
    @Step("Open Page with Form")
    public RegistrationPage openPage() {
        open("/automation-practice-form");
        String TITLE_TEXT = "Student Registration Form";
        $(".practice-form-wrapper").
                shouldHave(text(TITLE_TEXT));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        return this;
    }
    @Step("Set First Name: {firstName}")
    public RegistrationPage setFirstName(String firstName){
        userFirstNameInput.setValue(firstName);

        return this;
    }
    @Step("Set Last Name: {lastName}")
    public RegistrationPage setLastName(String lastName){
        userLastNameInput.setValue(lastName);

        return this;
    }
    @Step("Set Email: {email}")
    public RegistrationPage setEmail(String email){
        userEmailInput.setValue(email);

        return this;
    }
    @Step("Set Gender: {gender}")
    public RegistrationPage setGender(String gender){
        userGenderSection.$(byText(gender)).click();

        return this;
    }
    @Step("Set Phone number: {phone}")
    public RegistrationPage setPhone(String phone){
        userPhoneInput.setValue(phone);

        return this;
    }
    @Step("Set Date: {year} {month} {day}")
    public RegistrationPage setBirthDate(String year, String month, String day){
        calendarSection.click();
        calendarComponent.setDate(year, month, day);

        return this;
    }

    @Step("Set Subjects: {subjects}")
    public RegistrationPage setSubjects(String... subjects){

        for (String subject : subjects){
            subjectsContainerInput.setValue(subject).pressEnter();
        }

        return this;
    }
    @Step("Set Hobbies: {hobbies}")
    public RegistrationPage setHobbies(String... hobbies){

        for (String hobby : hobbies){
            hobbiesSection.$(byText(hobby)).click();
        }

        return this;
    }
    @Step("Upload Image: {pictureUrl}")
    public RegistrationPage setImage(String pictureUrl){
        imageUpdateField
                .uploadFile(new File("src/test/resources/" +
                        pictureUrl));

        return this;
    }
    @Step("Set Address: {currentAddress}")
    public RegistrationPage setCurrentAddress(String currentAddress){
        currentAddressInput.setValue(currentAddress);

        return this;
    }
    @Step("Set State: {state}")
    public RegistrationPage setState(String state){
        stateField.click();

        $(byText(state)).click();

        return this;
    }
    @Step("Set City: {city}")
    public RegistrationPage setCity(String city){
        cityField.click();
        $(byText(city)).click();

        return this;
    }
    @Step("Click submit button")
    public RegistrationPage clickSubmitButton(){
        submitButton.click();

        return this;
    }

    @Step("Verify results modal window appears")
    public RegistrationPage verifyResultsModalAppears(){
        registrationResultsModal.verifyModalAppears();

        return this;
    }
    @Step("Verify table data: {key} - {value}")
    public RegistrationPage verifyTableData(String key, String value){
        registrationResultsModal.verifyTableData(key, value);

        return this;
    }

}
