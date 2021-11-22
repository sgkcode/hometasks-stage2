package com.epam.learn.page.googlecloud;

import com.epam.learn.page.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleCloudSearchResultsPage extends AbstractPage {

  @FindBy(xpath = "(//a[@class='gs-title'])[1]")
  private WebElement firstPositionInSearchResultsLink;

  protected GoogleCloudSearchResultsPage(WebDriver driver) {
    super(driver);
  }

  public GoogleCloudPricingCalculatorPage goToPricingCalculatorFromFirstPositionInSearchResults() {
    waitForElementToBeClickable(firstPositionInSearchResultsLink).click();
    logger.info("Google Cloud Pricing Calculator page opened");
    return new GoogleCloudPricingCalculatorPage(driver);
  }
}
