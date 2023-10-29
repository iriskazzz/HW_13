package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.demoqa.helpers.Attach;
import com.demoqa.page.RegistrationFormPage;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

import static com.codeborne.selenide.WebDriverRunner.closeWebDriver;


public class RegistrationFormPageObjectsTest extends TestBase{
  RegistrationFormPage registrationFormPage = new RegistrationFormPage();

  @Test
  @Tag("regress")
  @DisplayName("Проверка полного заполнения формы")
  void fillPracticeForm() {
    registrationFormPage.openPage()
            .setFirstName("Irina")
            .setLastName("Petrova")
            .setEmail("ira@ya.ru")
            .setGenter("Female")
            .setNumber("1234567889")
            .setBirthDate("15", "April", "1995")
            .setSubjects("Economics")
            .setHobbies("Music")
            .setPicture("test.png")
            .setCurrentAddress("Sochi")
            .setState("Haryana")
            .setCity("Karnal")

            .clickSubmit()

            .checkResultTable()
            .checkResult("Student Name", "Irina Petrova")
            .checkResult("Student Email", "ira@ya.ru")
            .checkResult("Gender", "Female")
            .checkResult("Mobile", "1234567889")
            .checkResult("Date of Birth", "15 April,1995")
            .checkResult("Subjects", "Economics")
            .checkResult("Hobbies", "Music")
            .checkResult("Picture", "test.png")
            .checkResult("Address", "Sochi")
            .checkResult("State and City", "Haryana Karnal");
  }

  @Test
  @Tag("smoke")
  @Tag("regress")
  @DisplayName("Проверка заполнения только обязательных полей формы")
  void fillPracticeWithMinimumDataForm() {
    registrationFormPage.openPage()
            .setFirstName("Irina")
            .setLastName("Petrova")
            .setGenter("Female")
            .setNumber("1234567889")

            .clickSubmit()

            .checkResultTable()
            .checkResult("Student Name", "Irina Petrova")
            .checkResult("Gender", "Female")
            .checkResult("Mobile", "1234567889");
  }

}
