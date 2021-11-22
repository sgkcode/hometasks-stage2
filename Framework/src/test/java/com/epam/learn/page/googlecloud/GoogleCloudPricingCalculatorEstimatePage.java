package com.epam.learn.page.googlecloud;

import com.epam.learn.page.AbstractPage;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleCloudPricingCalculatorEstimatePage extends AbstractPage {

  @FindBy(xpath = "//*[@id='cloud-site']//iframe")
  private WebElement parentFrame;
  @FindBy(id = "myFrame")
  private WebElement contentFrame;
  @FindBy(xpath = "//div[contains(text(),'VM class')]")
  private WebElement vmClassField;
  @FindBy(xpath = "//div[contains(text(),'Instance type')]")
  private WebElement instanceTypeField;
  @FindBy(xpath = "//div[contains(text(),'Region')]")
  private WebElement regionField;
  @FindBy(xpath = "//div[contains(text(),'Local SSD')]")
  private WebElement localSSDField;
  @FindBy(xpath = "//div[contains(text(),'Commitment term')]")
  private WebElement commitmentTermField;
  @FindBy(xpath = "//b[contains(text(), 'Total Estimated Cost:')]")
  private WebElement totalEstimatedCostField;
  @FindBy(id = "email_quote")
  private WebElement emailEstimateButton;

  public GoogleCloudPricingCalculatorEstimatePage(WebDriver driver) {
    super(driver);
  }

  public String getVMClass() {
    return StringUtils.substringAfter(waitForVisibilityOfElement(vmClassField).getText(), ":")
        .toLowerCase().trim();
  }

  public String getInstanceType() {
    return StringUtils.substringAfter(waitForVisibilityOfElement(instanceTypeField).getText(), ": ")
        .toLowerCase().replaceAll("\\s.*", "");
  }

  public String getRegion() {
    return StringUtils.substringAfter(waitForVisibilityOfElement(regionField).getText(), ":")
        .toLowerCase().trim();
  }

  public String getLocalSSD() {
    return StringUtils.getDigits(waitForVisibilityOfElement(localSSDField).getText());
  }

  public String getCommitmentTerm() {
    return StringUtils
        .substringAfter(waitForVisibilityOfElement(commitmentTermField).getText(), ":")
        .toLowerCase().trim();
  }

  public double getTotalEstimatedCost() {
    return Double.parseDouble(StringUtils
        .substringBefore(waitForVisibilityOfElement(totalEstimatedCostField).getText(),
            "per 1 month")
        .replaceAll("[^\\d.]", ""));
  }

  public GoogleCloudPricingCalculatorEstimatePage switchToContentFrame() {
    waitForFrameToBeAvailableAndSwitchToIt(parentFrame);
    waitForFrameToBeAvailableAndSwitchToIt(contentFrame);
    logger.info("Switched to content frame");
    return this;
  }

  public GoogleCloudPricingCalculatorEmailEstimatePage goToEmailEstimate() {
    waitForElementToBeClickable(emailEstimateButton).click();
    logger.info("email estimate modal window opened");
    return new GoogleCloudPricingCalculatorEmailEstimatePage(driver);
  }
}
