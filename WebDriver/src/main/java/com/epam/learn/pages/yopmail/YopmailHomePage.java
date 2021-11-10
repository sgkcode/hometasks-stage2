package com.epam.learn.pages.yopmail;

import com.epam.learn.pages.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class YopmailHomePage extends AbstractPage {

  private static final String HOMEPAGE_URL = "https://yopmail.com/en/";

  @FindBy(xpath = "//*[@id='listeliens']/a[@href='email-generator']")
  private WebElement randomEmailButton;
  @FindBy(xpath = "//*[@id='refreshbut']/button")
  private WebElement checkInboxButton;

  public YopmailHomePage(WebDriver driver) {
    super(driver);
  }

  public YopmailHomePage openPage() {
    driver.get(HOMEPAGE_URL);
    return this;
  }

  public YopmailEmailGeneratorPage generateNewEmailAddress() {
    waitForElementToBeClickable(randomEmailButton).click();
    return new YopmailEmailGeneratorPage(driver);
  }

  public YopmailEmailInboxPage goToEmailInboxPage() {
    waitForElementToBeClickable(checkInboxButton).click();
    return new YopmailEmailInboxPage(driver);
  }
}
