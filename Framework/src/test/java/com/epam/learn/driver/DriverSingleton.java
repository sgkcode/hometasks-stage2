package com.epam.learn.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

public class DriverSingleton {

  private static WebDriver driver;

  private DriverSingleton() {
  }

  public static WebDriver getDriver() {
    if (null == driver) {
      switch (System.getProperty("browser")) {
        case "edge": {
          WebDriverManager.edgedriver().setup();
          driver = new EdgeDriver();
          break;
        }
        case "opera": {
          WebDriverManager.operadriver().setup();
          driver = new OperaDriver();
          break;
        }
        case "firefox": {
          WebDriverManager.firefoxdriver().setup();
          driver = new FirefoxDriver();
          break;
        }
        default: {
          WebDriverManager.chromedriver().setup();
          driver = new ChromeDriver();
        }
      }
      driver.manage().window().maximize();
    }
    return driver;
  }

  public static void closeDriver() {
    driver.quit();
    driver = null;
  }
}
