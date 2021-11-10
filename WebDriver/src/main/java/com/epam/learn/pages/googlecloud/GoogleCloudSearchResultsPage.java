package com.epam.learn.pages.googlecloud;

import com.epam.learn.pages.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleCloudSearchResultsPage extends AbstractPage {

  @FindBy(xpath = "(//a[@class='gs-title'])[1]")
  private WebElement firstPositionInSearchResults;

  protected GoogleCloudSearchResultsPage(WebDriver driver) {
    super(driver);
  }

  public GoogleCloudPricingCalculatorPage goToPricingCalculatorFromSearchResults() {
    waitForElementToBeClickable(firstPositionInSearchResults).click();
    return new GoogleCloudPricingCalculatorPage(driver);
  }
}
