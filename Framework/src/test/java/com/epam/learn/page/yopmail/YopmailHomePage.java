package com.epam.learn.page.yopmail;

import com.epam.learn.page.AbstractPage;
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
    logger.info("Yopmail email generator page opened");
    return new YopmailEmailGeneratorPage(driver);
  }

  public YopmailEmailInboxPage goToEmailInboxPage() {
    waitForElementToBeClickable(checkInboxButton).click();
    logger.info("Yopmail email inbox page opened");
    return new YopmailEmailInboxPage(driver);
  }
}
