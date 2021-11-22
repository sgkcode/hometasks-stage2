package com.epam.learn.page.googlecloud;

import com.epam.learn.page.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleCloudPricingCalculatorPage extends AbstractPage {

  public static final String PRICING_CALCULATOR_PAGE_URL = "https://cloud.google.com/products/calculator";
  private final String optionPattern = "//div[contains(@class,'md-clickable')]"
      + "//div[contains(text(),'%s')]";

  @FindBy(xpath = "//*[@id='cloud-site']//iframe")
  private WebElement parentCalculatorFrame;
  @FindBy(id = "myFrame")
  private WebElement contentCalculatorFrame;
  @FindBy(xpath = "//md-tab-item/div[contains(@class,'compute')]")
  private WebElement computeEngineItem;
  @FindBy(xpath = "//input[@ng-model='listingCtrl.computeServer.quantity']")
  private WebElement numberOfInstancesInput;
  @FindBy(xpath = "//md-select[@ng-model='listingCtrl.computeServer.os']")
  private WebElement operationSystemDropDown;
  @FindBy(xpath = "//md-select[@placeholder='VM Class']")
  private WebElement machineClassDropDown;
  @FindBy(xpath = "//md-select[@placeholder='Series']")
  private WebElement seriesDropDown;
  @FindBy(xpath = "//md-select[@placeholder='Instance type']")
  private WebElement machineTypeDropDown;
  @FindBy(xpath = "//md-checkbox[@ng-model='listingCtrl.computeServer.addGPUs']")
  private WebElement addGPUsCheckBox;
  @FindBy(xpath = "//md-select[@placeholder='Number of GPUs']")
  private WebElement numberOfGPUsDropDown;
  @FindBy(xpath = "//md-select[@placeholder='GPU type']")
  private WebElement GPUTypeDropDown;
  @FindBy(xpath = "//md-select[@placeholder='Local SSD']")
  private WebElement localSSDDropDown;
  @FindBy(xpath = "//md-select[@placeholder='Datacenter location']")
  private WebElement datacenterLocationDropDown;
  @FindBy(xpath = "//md-select[@placeholder='Committed usage']")
  private WebElement committedUsageDropDown;
  @FindBy(xpath = "//button[@ng-click='listingCtrl.addComputeServer(ComputeEngineForm);']")
  private WebElement addToEstimateButton;

  public GoogleCloudPricingCalculatorPage(WebDriver driver) {
    super(driver);
  }

  public GoogleCloudPricingCalculatorPage switchToCalculatorFrame() {
    waitForFrameToBeAvailableAndSwitchToIt(parentCalculatorFrame);
    waitForFrameToBeAvailableAndSwitchToIt(contentCalculatorFrame);
    logger.info("Switched to content frame");
    return this;
  }

  public GoogleCloudPricingCalculatorPage selectComputeEngineItem() {
    waitForElementToBeClickable(computeEngineItem).click();
    logger.info("Compute Engine item selected");
    return this;
  }

  public GoogleCloudPricingCalculatorPage setNumberOfInstances(int number) {
    waitForVisibilityOfElement(numberOfInstancesInput).sendKeys(String.valueOf(number));
    logger.info("Number of instances [" + number + "] selected");
    return this;
  }

  public GoogleCloudPricingCalculatorPage setOperatingSystem(String operationSystem) {
    waitForElementToBeClickable(operationSystemDropDown).click();
    waitForElementToBeClickable(By.xpath(String.format(optionPattern, operationSystem)))
        .click();
    logger.info("Operation system [" + operationSystem + "] selected");
    return this;
  }

  public GoogleCloudPricingCalculatorPage setMachineClass(String machineClass) {
    waitForElementToBeClickable(machineClassDropDown).click();
    waitForElementToBeClickable(By.xpath(String.format(optionPattern, machineClass)))
        .click();
    logger.info("MachineClass [" + machineClass + "] selected");
    return this;
  }

  public GoogleCloudPricingCalculatorPage setSeries(String series) {
    waitForElementToBeClickable(seriesDropDown).click();
    waitForElementToBeClickable(By.xpath(String.format(optionPattern, series))).click();
    logger.info("Series [" + series + "] selected");
    return this;
  }

  public GoogleCloudPricingCalculatorPage setMachineType(String machineType) {
    waitForElementToBeClickable(machineTypeDropDown).click();
    waitForElementToBeClickable(By.xpath(String.format(optionPattern, machineType))).click();
    logger.info("MachineType [" + machineType + "] selected");
    return this;
  }

  public GoogleCloudPricingCalculatorPage setGPU(String GPUType, int numberOfGPUs) {
    waitForElementToBeClickable(addGPUsCheckBox).click();
    waitForElementToBeClickable(GPUTypeDropDown).click();
    waitForElementToBeClickable(By.xpath(String.format(optionPattern, GPUType))).click();
    waitForElementToBeClickable(numberOfGPUsDropDown).click();
    waitForElementToBeClickable(By.xpath(String.format(optionPattern, numberOfGPUs)))
        .click();
    logger.info("GPU (type [" + GPUType + "], number of GPUs [" + numberOfGPUs + "]) selected");
    return this;
  }

  public GoogleCloudPricingCalculatorPage setLocalSSD(String localSSD) {
    waitForElementToBeClickable(localSSDDropDown).click();
    waitForElementToBeClickable(By.xpath(String.format(optionPattern, localSSD))).click();
    logger.info("Local SSD [" + localSSD + "] selected");
    return this;
  }

  public GoogleCloudPricingCalculatorPage setDatacenterLocation(String location) {
    waitForElementToBeClickable(datacenterLocationDropDown).click();
    waitForElementToBeClickable(By.xpath(String.format(optionPattern, location))).click();
    logger.info("Datacenter location [" + location + "] selected");
    return this;
  }

  public GoogleCloudPricingCalculatorPage setCommittedUsage(String committedUsage) {
    waitForElementToBeClickable(committedUsageDropDown).click();
    waitForElementToBeClickable(By.xpath(String.format(optionPattern, committedUsage)))
        .click();
    logger.info("Committed usage [" + committedUsage + "] selected");
    return this;
  }

  public GoogleCloudPricingCalculatorEstimatePage addToEstimate() {
    waitForElementToBeClickable(addToEstimateButton).click();
    logger.info("Added to estimate");
    return new GoogleCloudPricingCalculatorEstimatePage(driver);
  }
}
