package com.epam.learn.tests.bring_it_on;

import static com.epam.learn.constants.PastebinConstants.CODE_FOR_BRING_IT_ON;
import static com.epam.learn.constants.PastebinConstants.EXPIRATION_TIME;
import static com.epam.learn.constants.PastebinConstants.PASTE_NAME_FOR_BRING_IT_ON;
import static com.epam.learn.constants.PastebinConstants.SYNTAX_BASH;

import com.epam.learn.pages.pastebin.PastebinHomePage;
import com.epam.learn.pages.pastebin.PastebinResultPastePage;
import com.epam.learn.tests.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BringItOnTest extends BaseTest {

  private PastebinResultPastePage pastebinResult;

  @BeforeClass
  public void fillOutForm() {
    pastebinResult = new PastebinHomePage(driver)
        .openPage()
        .insertCode(CODE_FOR_BRING_IT_ON)
        .selectSyntaxHighlighting(SYNTAX_BASH)
        .selectExpirationTime(EXPIRATION_TIME)
        .insertName(PASTE_NAME_FOR_BRING_IT_ON)
        .createNewPaste();
  }

  @Test
  public void shouldGetEnteredHeading() {
    Assert.assertTrue(pastebinResult.isHeadingEqual(PASTE_NAME_FOR_BRING_IT_ON));
  }

  @Test
  public void shouldGetCodeWithBashSyntaxHighlighting() {
    Assert.assertTrue(pastebinResult.isBashSyntaxPresent());
  }

  @Test
  public void shouldGetEnteredCode() {
    Assert.assertTrue(pastebinResult.isCodeEqual(CODE_FOR_BRING_IT_ON));
  }
}
