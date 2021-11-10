package com.epam.learn.pages.googlecloud;

import com.epam.learn.pages.AbstractPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleCloudPricingCalculatorEmailEstimatePage extends AbstractPage {

  @FindBy(xpath = "//*[@id='cloud-site']//iframe")
  private WebElement parentFrame;
  @FindBy(id = "myFrame")
  private WebElement contentFrame;
  @FindBy(xpath = "//input[@type='email']")
  private WebElement emailInput;
  @FindBy(xpath = "//button[@aria-label='Send Email']")
  private WebElement sendEmailButton;


  public GoogleCloudPricingCalculatorEmailEstimatePage(WebDriver driver) {
    super(driver);
  }

  public GoogleCloudPricingCalculatorEmailEstimatePage switchToContentFrame() {
    waitForFrameToBeAvailableAndSwitchToIt(parentFrame);
    waitForFrameToBeAvailableAndSwitchToIt(contentFrame);
    return this;
  }

  public GoogleCloudPricingCalculatorEmailEstimatePage setEmail() {
    waitForElementToBeClickable(emailInput).sendKeys(Keys.CONTROL + "v");
    return this;
  }

  public GoogleCloudPricingCalculatorEmailEstimatePage sendEmail() {
    waitForElementToBeClickable(sendEmailButton).click();
    return this;
  }
}
