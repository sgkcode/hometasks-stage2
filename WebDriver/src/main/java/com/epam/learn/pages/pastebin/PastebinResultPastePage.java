package com.epam.learn.pages.pastebin;

import com.epam.learn.pages.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PastebinResultPastePage extends AbstractPage {

  @FindBy(xpath = "//h1")
  private WebElement heading;
  @FindBy(xpath = "//ol[@class='bash']")
  private WebElement bashSyntax;
  @FindBy(xpath = "//ol")
  private WebElement code;

  public PastebinResultPastePage(WebDriver driver) {
    super(driver);
  }

  public boolean isHeadingEqual(String enteredHeading) {
    return waitForVisibilityOfElement(heading).getText().equals(enteredHeading);
  }

  public boolean isCodeEqual(String enteredCode) {
    return waitForVisibilityOfElement(code).getText().equals(enteredCode);
  }

  public boolean isBashSyntaxPresent() {
    return waitForVisibilityOfElement(bashSyntax).isDisplayed();
  }
}


