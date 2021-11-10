package com.epam.learn.tests.hurt_me_plenty;

import static com.epam.learn.constants.GoogleCloudConstants.COMMITTED_USAGE;
import static com.epam.learn.constants.GoogleCloudConstants.DATACENTER_LOCATION;
import static com.epam.learn.constants.GoogleCloudConstants.LOCAL_SSD;
import static com.epam.learn.constants.GoogleCloudConstants.MACHINE_CLASS;
import static com.epam.learn.constants.GoogleCloudConstants.MACHINE_TYPE;
import static com.epam.learn.constants.GoogleCloudConstants.TOTAL_ESTIMATED_COST;

import com.epam.learn.tests.base.GoogleCloudBaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HurtMePlentyTest extends GoogleCloudBaseTest {

  @Test
  public void shouldGetSelectedMachineClass() {
    Assert.assertTrue(estimatePage.isVMClassContains(MACHINE_CLASS));
  }

  @Test
  public void shouldGetSelectedMachineType() {
    Assert.assertTrue(estimatePage.isInstanceTypeContains(MACHINE_TYPE));
  }

  @Test
  public void shouldGetSelectedDatacenterLocation() {
    Assert.assertTrue(estimatePage.isRegionContains(DATACENTER_LOCATION));
  }

  @Test
  public void shouldGetSelectedLocalSSD() {
    Assert.assertTrue(estimatePage.isLocalSSDContains(LOCAL_SSD));
  }

  @Test
  public void shouldGetSelectedCommittedUsage() {
    Assert.assertTrue(estimatePage.isCommitmentTermContains(COMMITTED_USAGE));
  }

  @Test
  public void shouldGetTheSameCostAsInManualCheck() {
    Assert.assertTrue(estimatePage.isTotalEstimatedCostContains(TOTAL_ESTIMATED_COST));
  }
}
