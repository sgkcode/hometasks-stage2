package com.epam.learn.test;

import static com.epam.learn.page.googlecloud.GoogleCloudPricingCalculatorPage.PRICING_CALCULATOR_PAGE_URL;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SmokeTest extends CommonConditions {

  @Test(description = "Smoke test")
  public void shouldGetGoogleCloudPricingCalculatorPage() {
    calculatorService.getPricingCalculatorPageFromFirstPositionInSearchResults();
    Assert.assertTrue(driver.getCurrentUrl().contains(PRICING_CALCULATOR_PAGE_URL),
        "got the wrong page from the first position in the search results");
  }
}
