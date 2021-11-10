package com.epam.learn.utils;

import java.util.ArrayList;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class TabManager {

  private WebDriver driver;

  public TabManager(WebDriver driver) {
    this.driver = driver;
  }

  public void openNewTab() {
    ((JavascriptExecutor) driver).executeScript("window.open()");
  }

  public void switchToTab(int tabIndex) {
    ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
    driver.switchTo().window(tabs.get(tabIndex));
  }

}
