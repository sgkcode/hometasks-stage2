package com.epam.learn.service;

import com.epam.learn.model.ComputeEngine;
import com.epam.learn.page.googlecloud.GoogleCloudHomePage;
import com.epam.learn.page.googlecloud.GoogleCloudPricingCalculatorEmailEstimatePage;
import com.epam.learn.page.googlecloud.GoogleCloudPricingCalculatorEstimatePage;
import com.epam.learn.page.googlecloud.GoogleCloudPricingCalculatorPage;
import org.openqa.selenium.WebDriver;

public class GoogleCloudPricingCalculatorService {

  private static final String SEARCH_TERM = "Google Cloud Pricing Calculator";

  private WebDriver driver;

  public GoogleCloudPricingCalculatorService(WebDriver driver) {
    this.driver = driver;
  }

  public GoogleCloudPricingCalculatorPage getPricingCalculatorPageFromFirstPositionInSearchResults() {
    return new GoogleCloudHomePage(driver)
        .openPage()
        .searchForTerms(SEARCH_TERM)
        .goToPricingCalculatorFromFirstPositionInSearchResults();
  }

  public GoogleCloudPricingCalculatorEstimatePage addComputeEngineToEstimate(
      GoogleCloudPricingCalculatorPage pricingCalculatorPage,
      ComputeEngine computeEngine) {
    pricingCalculatorPage.switchToCalculatorFrame()
        .selectComputeEngineItem()
        .setNumberOfInstances(Integer.parseInt(computeEngine.getNumberOfInstances()))
        .setOperatingSystem(computeEngine.getOperatingSystem())
        .setMachineClass(computeEngine.getMachineClass())
        .setSeries(computeEngine.getSeries())
        .setMachineType(computeEngine.getMachineType());
    if (computeEngine.getNumberOfGPUs() > 0) {
      pricingCalculatorPage.setGPU(computeEngine.getGpuType(), computeEngine.getNumberOfGPUs());
    }
    return pricingCalculatorPage
        .setLocalSSD(computeEngine.getLocalSSD())
        .setDatacenterLocation(computeEngine.getDatacenterLocation())
        .setCommittedUsage(computeEngine.getCommittedUsage())
        .addToEstimate();
  }

  public GoogleCloudPricingCalculatorEmailEstimatePage sendEmailWithEstimatedCost(
      GoogleCloudPricingCalculatorEstimatePage estimatePage) {
    return estimatePage
        .switchToContentFrame()
        .goToEmailEstimate()
        .setEmail()
        .sendEmail();
  }
}
