package com.epam.learn.tests.i_can_win;

import static com.epam.learn.constants.PastebinConstants.CODE_FOR_I_CAN_WIN;
import static com.epam.learn.constants.PastebinConstants.EXPIRATION_TIME;
import static com.epam.learn.constants.PastebinConstants.PASTE_NAME_FOR_I_CAN_WIN;

import com.epam.learn.pages.pastebin.PastebinHomePage;
import com.epam.learn.pages.pastebin.PastebinResultPastePage;
import com.epam.learn.tests.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ICanWinTest extends BaseTest {

  private PastebinResultPastePage pastebinResult;

  @BeforeClass
  public void fillOutForm() {
    pastebinResult = new PastebinHomePage(driver)
        .openPage()
        .insertCode(CODE_FOR_I_CAN_WIN)
        .selectExpirationTime(EXPIRATION_TIME)
        .insertName(PASTE_NAME_FOR_I_CAN_WIN)
        .createNewPaste();
  }

  @Test
  public void shouldGetEnteredHeading() {
    Assert.assertTrue(pastebinResult.isHeadingEqual(PASTE_NAME_FOR_I_CAN_WIN));
  }
}
