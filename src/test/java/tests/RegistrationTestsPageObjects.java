package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

public class RegistrationTestsPageObjects extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void fullRegistrationTest() {
        registrationPage.openPage()
                .setFirstName("Василий")
                .setLastName("Тестов")
                .setEmail("test@test.com")
                .setGender("Male")
                .setUserNumber("9123456789")
                .setDateOfBirth("17", "May", "2000")
                .setSubjectsInput("Chemistry")
                .setHobbiesWrapperInput("Sports")
                .setUploadPictureInput("images.png")
                .setCurrentAddress("Moscow, Prospekt Mira str.")
                .setStateWrapper("Uttar Pradesh")
                .setCityWrapper("Agra")
                .submit();

        registrationPage.checkResult("Student Name", "Василий Тестов")
                .checkResult("Student Email","test@test.com")
                .checkResult("Gender", "Male")
                .checkResult("Mobile","9123456789")
                .checkResult("Date of Birth", "17 May,2000")
                .checkResult("Subjects", "Chemistry")
                .checkResult("Hobbies", "Sports")
                .checkResult("Picture", "images.png")
                .checkResult("Address", "Moscow, Prospekt Mira str.")
                .checkResult("State and City","Uttar Pradesh");
    }


    @Test
    void minimalRegistrationTest() {
        registrationPage.openPage()
                .setFirstName("Василий")
                .setLastName("Тестов")
                .setGender("Male")
                .setUserNumber("9123456789")
                .submit();

        registrationPage.checkResult("Student Name", "Василий Тестов")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "9123456789");

    }

    @Test
    void negativeRegistrationTest() {
        registrationPage.openPage()
                .setFirstName("Тестов Василий")
                .setGender("Male")
                .setUserNumber("9123456789")
                .submit();

        registrationPage.noResult();


    }
}