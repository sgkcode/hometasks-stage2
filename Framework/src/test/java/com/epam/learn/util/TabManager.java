package com.epam.learn.util;

import java.util.ArrayList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class TabManager {

  private final Logger logger = LogManager.getRootLogger();
  private WebDriver driver;

  public TabManager(WebDriver driver) {
    this.driver = driver;
  }

  public void openNewTab() {
    ((JavascriptExecutor) driver).executeScript("window.open()");
    logger.info("New tab opened");
  }

  public void switchToTab(int tabIndex) {
    ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
    driver.switchTo().window(tabs.get(tabIndex));
    logger.info("Switched to tab [" + tabIndex + "]");
  }
}
