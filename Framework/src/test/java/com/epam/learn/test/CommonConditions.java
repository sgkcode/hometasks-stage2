package com.epam.learn.test;

import com.epam.learn.driver.DriverSingleton;
import com.epam.learn.service.GoogleCloudPricingCalculatorService;
import com.epam.learn.service.YopmailService;
import com.epam.learn.util.TabManager;
import com.epam.learn.util.TestListener;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

@Listeners({TestListener.class})
public abstract class CommonConditions {

  protected WebDriver driver;
  protected GoogleCloudPricingCalculatorService calculatorService;
  protected YopmailService yopmailService;
  protected TabManager tabManager;

  @BeforeTest(alwaysRun = true)
  protected void setUp() {
    driver = DriverSingleton.getDriver();
    tabManager = new TabManager(driver);
    calculatorService = new GoogleCloudPricingCalculatorService(driver);
    yopmailService = new YopmailService(driver);
  }

  @AfterTest(alwaysRun = true)
  protected void stopBrowser() {
    DriverSingleton.closeDriver();
  }
}
