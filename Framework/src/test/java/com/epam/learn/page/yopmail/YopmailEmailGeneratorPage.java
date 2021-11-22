package com.epam.learn.page.yopmail;

import com.epam.learn.page.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class YopmailEmailGeneratorPage extends AbstractPage {

  @FindBy(id = "cprnd")
  private WebElement copyEmailButton;

  public YopmailEmailGeneratorPage(WebDriver driver) {
    super(driver);
  }

  public YopmailEmailGeneratorPage copyEmailAddress() {
    waitForVisibilityOfElement(copyEmailButton).click();
    logger.info("Generated email address copied to clipboard");
    return this;
  }
}
