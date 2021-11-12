package com.epam.learn.pages.pastebin;

import com.epam.learn.pages.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PastebinResultPastePage extends AbstractPage {

  @FindBy(xpath = "//h1")
  private WebElement headingHeader;
  @FindBy(xpath = "//ol")
  private WebElement codeOrderedList;

  public PastebinResultPastePage(WebDriver driver) {
    super(driver);
  }

  public String getHeading() {
   return waitForVisibilityOfElement(headingHeader).getText();
  }

  public String getCode() {
    return waitForVisibilityOfElement(codeOrderedList).getText();
  }

  public String getSyntax() {
    return waitForVisibilityOfElement(codeOrderedList).getAttribute("class");
  }
}
