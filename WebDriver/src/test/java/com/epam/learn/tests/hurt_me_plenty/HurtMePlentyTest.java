package com.epam.learn.tests.hurt_me_plenty;

import static com.epam.learn.constants.GoogleCloudConstants.COMMITTED_USAGE;
import static com.epam.learn.constants.GoogleCloudConstants.DATACENTER_LOCATION;
import static com.epam.learn.constants.GoogleCloudConstants.LOCAL_SSD;
import static com.epam.learn.constants.GoogleCloudConstants.MACHINE_CLASS;
import static com.epam.learn.constants.GoogleCloudConstants.MACHINE_TYPE;
import static com.epam.learn.constants.GoogleCloudConstants.TOTAL_ESTIMATED_COST;

import com.epam.learn.tests.base.GoogleCloudBaseTest;
import org.apache.commons.lang3.StringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HurtMePlentyTest extends GoogleCloudBaseTest {

  @Test (description = "Check machine class")
  public void shouldGetSelectedMachineClass() {
    Assert.assertEquals(estimatePage.getVMClass(),MACHINE_CLASS.toLowerCase(),
    "received VM class differs from selected machine class");
  }

  @Test(description = "Check instance type")
  public void shouldGetSelectedMachineType() {
    Assert.assertEquals(estimatePage.getInstanceType(), StringUtils
        .substringBefore(MACHINE_TYPE, "(").toLowerCase().trim(),
        "received instance type differs from selected machine type");
  }

  @Test(description = "Check region")
  public void shouldGetSelectedDatacenterLocation() {
    Assert.assertEquals(estimatePage.getRegion(),
        StringUtils.substringBefore(DATACENTER_LOCATION, "(").toLowerCase().trim(),
        "received region differs from selected datacenter location");
  }

  @Test(description = "Check local SSD")
  public void shouldGetSelectedLocalSSD() {
    Assert.assertEquals(estimatePage.getLocalSSD(), StringUtils.getDigits(LOCAL_SSD),
        "received local SSD size differs from selected value");
  }

  @Test(description = "Check commitment term")
  public void shouldGetSelectedCommittedUsage() {
    Assert.assertEquals(estimatePage.getCommitmentTerm(), COMMITTED_USAGE.toLowerCase(),
        "received commitment term differs from selected committed usage");
  }

  @Test(description = "Check total estimated cost")
  public void shouldGetTheSameCostAsInManualCheck() {
    Assert.assertEquals(estimatePage.getTotalEstimatedCost(), TOTAL_ESTIMATED_COST,
        "received total estimated cost differs from the manual check value");
  }
}
