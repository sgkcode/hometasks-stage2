package com.epam.learn.pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractPage {

  protected WebDriver driver;

  protected final int WAIT_TIMEOUT_SECONDS = 10;

  protected AbstractPage(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
  }

  protected WebElement waitForVisibilityOfElement(WebElement element) {
    return new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
        .until(ExpectedConditions.visibilityOf(element));
  }

  protected WebElement waitForElementToBeClickable(WebElement element) {
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
