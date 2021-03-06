package com.epam.learn.page;

import static com.epam.learn.page.googlecloud.GoogleCloudPricingCalculatorPage.PRICING_CALCULATOR_PAGE_URL;

import java.time.Duration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractPage {

  protected WebDriver driver;
  protected final Logger logger = LogManager.getRootLogger();
  protected Capabilities cap;
  protected String browserName;
  protected final int WAIT_TIMEOUT_SECONDS = 10;

  protected AbstractPage(WebDriver driver) {
    this.driver = driver;
    cap = ((RemoteWebDriver) driver).getCapabilities();
    browserName = cap.getBrowserName().toLowerCase();
    PageFactory.initElements(driver, this);
  }

  protected WebElement waitForVisibilityOfElement(WebElement element) {
    return new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
        .until(ExpectedConditions.visibilityOf(element));
  }

  protected WebElement waitForElementToBeClickable(WebElement element) {
    if (browserName.equals("firefox") && driver.getCurrentUrl()
        .contains(PRICING_CALCULATOR_PAGE_URL)) {
      ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }
    return new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
        .until(ExpectedConditions.elementToBeClickable(element));
  }

  protected WebElement waitForElementToBeClickable(By by) {
    return new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
        .until(ExpectedConditions.elementToBeClickable(by));
  }

  protected WebDriver waitForFrameToBeAvailableAndSwitchToIt(WebElement element) {
    return new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
        .until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
  }
}
