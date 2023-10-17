package com.demoqa.page;

import com.codeborne.selenide.SelenideElement;
import com.demoqa.page.components.CalendarComponent;
import com.demoqa.page.components.ResultModal;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationFormPage {
  private CalendarComponent calendarComponent = new CalendarComponent();
  private ResultModal resultModal = new ResultModal();

  private SelenideElement
          firstNameInput = $("#firstName"),
          lastNameInput = $("#lastName"),
          emailInput = $("#userEmail"),
          genderInput = $("#genterWrapper"),
          numberInput = $("#userNumber"),
          subjectInput = $("#subjectsInput"),
          hobbiesInput = $("#hobbiesWrapper"),
          pictureInput = $("#uploadPicture"),
          currentAddressInput = $("#currentAddress"),
          stateInput = $("#stateCity-wrapper"),
          cityInput = $("#stateCity-wrapper"),
          submitButton = $("#submit");

  public RegistrationFormPage openPage() {
    open("/automation-practice-form");
    executeJavaScript("$('footer').remove()");
    executeJavaScript("$('#fixedban').remove()");

    return this;
  }

  public RegistrationFormPage checkTitle(String title) {
    $(".practice-form-wrapper").shouldHave(text(title));

    return this;
  }

  public RegistrationFormPage removeBanner() {
    executeJavaScript("$('footer').remove()");
    executeJavaScript("$('#fixedban').remove()");

    return this;
  }

  public RegistrationFormPage setFirstName(String value) {
    firstNameInput.setValue(value);

    return this;
  }

  public RegistrationFormPage setLastName(String value) {
    lastNameInput.setValue(value);

    return this;
  }

  public RegistrationFormPage setEmail(String value) {
    emailInput.setValue(value);

    return this;
  }

  public RegistrationFormPage setNumber(String value) {
    numberInput.setValue(value);

    return this;
  }

  public RegistrationFormPage setGenter(String value) {
    genderInput.$(byText(value)).click();

    return this;
  }

  public RegistrationFormPage setBirthDate(String day, String month, String year) {
    $("#dateOfBirthInput").click();
    calendarComponent.setDate(day, month, year);

    return this;
  }

  public RegistrationFormPage setSubjects(String value) {
    subjectInput.setValue(value).pressEnter();

    return this;
  }

  public RegistrationFormPage setHobbies(String value) {
    hobbiesInput.$(byText(value)).click();

    return this;
  }

  public RegistrationFormPage setPicture(String value) {
    pictureInput.uploadFromClasspath(value);

    return this;
  }

  public RegistrationFormPage setCurrentAddress(String value) {
    currentAddressInput.setValue(value);

    return this;
  }

  public RegistrationFormPage setState(String value) {
    $("#state").click();
    stateInput.$(byText(value)).click();

    return this;
  }

  public RegistrationFormPage setCity(String value) {
    $("#city").click();
    cityInput.$(byText(value)).click();

    return this;
  }

  public RegistrationFormPage checkResultTable() {
    resultModal.checkVisible();

    return this;
  }

  public RegistrationFormPage checkResult(String key, String value) {
    resultModal.checkResults(key, value);

    return this;
  }

  public RegistrationFormPage clickSubmit() {
    submitButton.click();

    return this;
  }

}