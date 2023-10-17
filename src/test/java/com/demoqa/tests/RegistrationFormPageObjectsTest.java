package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import com.demoqa.page.RegistrationFormPage;
import org.junit.jupiter.api.*;


public class RegistrationFormPageObjectsTest {
  RegistrationFormPage registrationFormPage = new RegistrationFormPage();

  @BeforeAll
  static void configure() {
    Configuration.pageLoadStrategy = "eager";
    Configuration.baseUrl = "https://demoqa.com";
  }

  @Tag("regress")
  @Test
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

  @Tag("smoke")
  @Tag("regress")
  @Test
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
