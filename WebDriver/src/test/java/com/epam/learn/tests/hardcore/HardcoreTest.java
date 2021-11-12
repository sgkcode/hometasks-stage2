package com.epam.learn.tests.hardcore;

import static com.epam.learn.constants.GoogleCloudConstants.TOTAL_ESTIMATED_COST;

import com.epam.learn.pages.googlecloud.GoogleCloudPricingCalculatorEmailEstimatePage;
import com.epam.learn.pages.yopmail.YopmailEmailGeneratorPage;
import com.epam.learn.pages.yopmail.YopmailEmailInboxPage;
import com.epam.learn.pages.yopmail.YopmailHomePage;
import com.epam.learn.tests.base.GoogleCloudBaseTest;
import com.epam.learn.utils.TabManager;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HardcoreTest extends GoogleCloudBaseTest {

  private GoogleCloudPricingCalculatorEmailEstimatePage emailEstimatePage;
  private YopmailEmailGeneratorPage emailGeneratorPage;
  private YopmailEmailInboxPage emailInboxPage;
  private TabManager tabManager;

  @BeforeClass(description = "Filling out the form for the Hardcore test")
  @Override
  public void fillOutForm() {
    super.fillOutForm();
    tabManager = new TabManager(driver);
    tabManager.openNewTab();
    tabManager.switchToTab(1);
    emailGeneratorPage = new YopmailHomePage(driver)
        .openPage()
        .generateNewEmailAddress()
        .copyEmailAddress();
    tabManager.switchToTab(0);
    emailEstimatePage = estimatePage.switchToContentFrame()
        .goToEmailEstimate()
        .setEmail()
        .sendEmail();
    tabManager.switchToTab(1);
    emailInboxPage = new YopmailHomePage(driver)
        .openPage()
        .goToEmailInboxPage()
        .getGoogleCloudEstimateMessage();
  }

  @Test(description = "Check received by email total estimated cost")
  public void shouldGetTheSameCostAsOnCalculatorPage() {
    Assert.assertEquals(emailInboxPage.getTotalEstimatedCost(), TOTAL_ESTIMATED_COST,
        "total estimated cost received by email is different from the price calculator page");
  }
}
