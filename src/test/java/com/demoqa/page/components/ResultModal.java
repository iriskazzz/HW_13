package com.demoqa.page.components;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ResultModal {
  private final static String TITLE_TEXT = "Thanks for submitting the form";

  public ResultModal checkVisible() {
    $(".modal-dialog").should(appear);
    $("#example-modal-sizes-title-lg").shouldHave(text(TITLE_TEXT));

    return this;
  }

  public ResultModal checkResults(String key, String value) {
    $(".table-responsive").$(byText(key)).parent()
            .shouldHave(text(value));

    return this;
  }

}