package com.epam.learn.pages.yopmail;

import com.epam.learn.pages.AbstractPage;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class YopmailEmailInboxPage extends AbstractPage {

  @FindBy(id = "ifmail")
  private WebElement messageFrame;
  @FindBy(xpath = "//span[contains(text(),'noreply@google.com')]")
  private WebElement emailFromGoogleField;
  @FindBy(id = "refresh")
  private WebElement refreshButton;
  @FindBy(xpath = "//h3[contains(text(),'USD')]")
  private WebElement totalEstimatedMonthlyCostField;

  public YopmailEmailInboxPage(WebDriver driver) {
    super(driver);
  }

  public YopmailEmailInboxPage getGoogleCloudEstimateMessage() {
    long startTimeOfMailChecking = System.currentTimeMillis();
    while (true) {
      waitForFrameToBeAvailableAndSwitchToIt(messageFrame);
      try {
        waitForVisibilityOfElement(emailFromGoogleField);
        break;
      } catch (TimeoutException e) {
        if ((System.currentTimeMillis() - startTimeOfMailChecking) > 60000) {
          throw new TimeoutException("Can't get message from Google Cloud");
        }
        driver.switchTo().defaultContent();
        waitForElementToBeClickable(refreshButton).click();
      }
    }
    return this;
  }

  public double getTotalEstimatedCost() {
    return Double.parseDouble(
        waitForVisibilityOfElement(totalEstimatedMonthlyCostField).getText()
            .replaceAll("[^\\d.]", ""));
  }
}
