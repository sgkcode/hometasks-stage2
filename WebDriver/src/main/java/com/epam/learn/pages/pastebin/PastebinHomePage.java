package com.epam.learn.pages.pastebin;


import com.epam.learn.pages.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PastebinHomePage extends AbstractPage {

  private static final String HOMEPAGE_URL = "https://pastebin.com/";

  String dropDownOption = "//li[text()='%s']";
  @FindBy(id = "postform-text")
  private WebElement pasteTextArea;
  @FindBy(id = "select2-postform-format-container")
  private WebElement syntaxHighlightingDropdown;
  @FindBy(id = "select2-postform-expiration-container")
  private WebElement pasteExpirationTimeDropdown;
  @FindBy(id = "postform-name")
  private WebElement pasteNameInput;
  @FindBy(xpath = "//button[@type='submit']")
  private WebElement createNewPasteButton;

  public PastebinHomePage(WebDriver driver) {
    super(driver);
  }

  public PastebinHomePage openPage() {
    driver.get(HOMEPAGE_URL);
    ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 300);");
    return this;
  }

  public PastebinHomePage insertCode(String code) {
    waitForVisibilityOfElement(pasteTextArea).sendKeys(code);
    return this;
  }

  public PastebinHomePage insertName(String pasteName) {
    waitForVisibilityOfElement(pasteNameInput).sendKeys(pasteName);
    return this;
  }

  public PastebinHomePage selectExpirationTime(String expirationTime) {
    waitForElementToBeClickable(pasteExpirationTimeDropdown).click();
    waitForElementToBeClickable(By.xpath(String.format(dropDownOption, expirationTime)))
        .click();
    return this;
  }

  public PastebinHomePage selectSyntaxHighlighting(String syntaxHighlighting) {
    waitForElementToBeClickable(syntaxHighlightingDropdown).click();
    waitForElementToBeClickable(
        By.xpath(String.format(dropDownOption, syntaxHighlighting)))
        .click();
    return this;
  }

  public PastebinResultPastePage createNewPaste() {
    waitForElementToBeClickable(createNewPasteButton).click();
    return new PastebinResultPastePage(driver);
  }
}
