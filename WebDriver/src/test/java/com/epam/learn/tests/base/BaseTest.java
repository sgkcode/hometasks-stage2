package com.epam.learn.tests.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public abstract class BaseTest {

  protected WebDriver driver;

  @BeforeTest(alwaysRun = true)
  protected void setUp() {
    driver = new ChromeDriver();
    driver.manage().window().maximize();
  }

  @AfterTest(alwaysRun = true)
  protected void tearDown() {
    driver.quit();
    driver = null;
  }
}
