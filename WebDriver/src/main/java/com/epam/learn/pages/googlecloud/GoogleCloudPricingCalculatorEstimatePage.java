package com.epam.learn.pages.googlecloud;

import com.epam.learn.pages.AbstractPage;
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
  private WebElement vmClass;
  @FindBy(xpath = "//div[contains(text(),'Instance type')]")
  private WebElement instanceType;
  @FindBy(xpath = "//div[contains(text(),'Region')]")
  private WebElement region;
  @FindBy(xpath = "//div[contains(text(),'Local SSD')]")
  private WebElement localSSD;
  @FindBy(xpath = "//div[contains(text(),'Commitment term')]")
  private WebElement commitmentTerm;
  @FindBy(xpath = "//b[contains(text(), 'Total Estimated Cost:')]")
  private WebElement totalEstimatedCost;
  @FindBy(id = "email_quote")
  private WebElement emailEstimateButton;

  public GoogleCloudPricingCalculatorEstimatePage(WebDriver driver) {
    super(driver);
  }

  public boolean isVMClassContains(String selectedMachineClass) {
    return waitForVisibilityOfElement(vmClass).getText().toLowerCase()
        .contains(selectedMachineClass.toLowerCase());
  }

  public boolean isInstanceTypeContains(String selectedInstanceType) {
    return waitForVisibilityOfElement(instanceType).getText().toLowerCase()
        .contains(StringUtils.substringBefore(selectedInstanceType, "(").toLowerCase().trim());
  }

  public boolean isRegionContains(String selectedDatacenterLocation) {
    return waitForVisibilityOfElement(region).getText().toLowerCase().contains(
        StringUtils.substringBefore(selectedDatacenterLocation, "(").toLowerCase().trim());
  }

  public boolean isLocalSSDContains(String selectedLocalSsd) {
    return StringUtils.getDigits(waitForVisibilityOfElement(localSSD).getText())
        .equals(StringUtils.getDigits(selectedLocalSsd));
  }

  public boolean isCommitmentTermContains(String selectedCommittedUsage) {
    return waitForVisibilityOfElement(commitmentTerm).getText().toLowerCase()
        .contains(selectedCommittedUsage.toLowerCase());
  }

  public boolean isTotalEstimatedCostContains(double costFromManualCheck) {
    return waitForVisibilityOfElement(totalEstimatedCost).getText().replaceAll(",", "")
        .contains(String.valueOf(costFromManualCheck));
  }

  public GoogleCloudPricingCalculatorEstimatePage switchToContentFrame() {
    waitForFrameToBeAvailableAndSwitchToIt(parentFrame);
    waitForFrameToBeAvailableAndSwitchToIt(contentFrame);
    return this;
  }


  public GoogleCloudPricingCalculatorEmailEstimatePage goToEmailEstimate() {
    waitForElementToBeClickable(emailEstimateButton).click();
    return new GoogleCloudPricingCalculatorEmailEstimatePage(driver);
  }
}
