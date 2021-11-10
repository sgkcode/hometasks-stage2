package com.epam.learn.pages.googlecloud;

import com.epam.learn.pages.AbstractPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleCloudHomePage extends AbstractPage {

  private static final String HOMEPAGE_URL = "https://cloud.google.com/";

  @FindBy(xpath = "//input[@name='q']")
  WebElement searchInput;

  public GoogleCloudHomePage(WebDriver driver) {
    super(driver);
  }

  public GoogleCloudHomePage openPage() {
    driver.get(HOMEPAGE_URL);
    return this;
  }

  public GoogleCloudSearchResultsPage search(String searchTerm) {
    waitForElementToBeClickable(searchInput).click();
    searchInput.sendKeys(searchTerm);
    searchInput.sendKeys(Keys.ENTER);
    return new GoogleCloudSearchResultsPage(driver);
  }
}
