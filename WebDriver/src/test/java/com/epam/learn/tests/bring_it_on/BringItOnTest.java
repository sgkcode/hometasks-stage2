package com.epam.learn.tests.bring_it_on;

import static com.epam.learn.constants.PastebinConstants.CLASS_ATTRIBUTE_BASH;
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

  @BeforeClass (description = "Filling out the form for the BringItOn test")
  public void fillOutForm() {
    pastebinResult = new PastebinHomePage(driver)
        .openPage()
        .insertCode(CODE_FOR_BRING_IT_ON)
        .selectSyntaxHighlighting(SYNTAX_BASH)
        .selectExpirationTime(EXPIRATION_TIME)
        .insertName(PASTE_NAME_FOR_BRING_IT_ON)
        .createNewPaste();
  }

  @Test(description = "Check received heading")
  public void shouldGetEnteredHeading() {
    Assert.assertEquals(pastebinResult.getHeading(), PASTE_NAME_FOR_BRING_IT_ON,
        "received heading differs from entered heading");
  }

  @Test(description = "Check received code for Bash syntax highlighting")
  public void shouldGetCodeWithBashSyntaxHighlighting() {
    Assert.assertEquals(pastebinResult.getSyntax(), CLASS_ATTRIBUTE_BASH,
        "received code isn't highlighted as Bash syntax");
  }

  @Test(description = "Check received code")
  public void shouldGetEnteredCode() {
    Assert.assertEquals(pastebinResult.getCode(), CODE_FOR_BRING_IT_ON,
        "received code differs from entered code");
  }
}
