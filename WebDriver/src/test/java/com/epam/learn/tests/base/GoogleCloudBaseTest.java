package com.epam.learn.tests.base;

import static com.epam.learn.constants.GoogleCloudConstants.COMMITTED_USAGE;
import static com.epam.learn.constants.GoogleCloudConstants.DATACENTER_LOCATION;
import static com.epam.learn.constants.GoogleCloudConstants.GPU_TYPE;
import static com.epam.learn.constants.GoogleCloudConstants.LOCAL_SSD;
import static com.epam.learn.constants.GoogleCloudConstants.MACHINE_CLASS;
import static com.epam.learn.constants.GoogleCloudConstants.MACHINE_TYPE;
import static com.epam.learn.constants.GoogleCloudConstants.NUMBER_OF_GPUS;
import static com.epam.learn.constants.GoogleCloudConstants.NUMBER_OF_INSTANCES;
import static com.epam.learn.constants.GoogleCloudConstants.OPERATING_SYSTEM;
import static com.epam.learn.constants.GoogleCloudConstants.SEARCH_TERM;
import static com.epam.learn.constants.GoogleCloudConstants.SERIES;

import com.epam.learn.pages.googlecloud.GoogleCloudHomePage;
import com.epam.learn.pages.googlecloud.GoogleCloudPricingCalculatorEstimatePage;
import org.testng.annotations.BeforeClass;

public class GoogleCloudBaseTest extends BaseTest {

  protected GoogleCloudPricingCalculatorEstimatePage estimatePage;

  @BeforeClass
  public void fillOutForm() {
    estimatePage = new GoogleCloudHomePage(driver)
        .openPage()
        .search(SEARCH_TERM)
        .goToPricingCalculatorFromSearchResults()
        .switchToCalculatorFrame()
        .selectComputeEngineItem()
        .setNumberOfInstances(NUMBER_OF_INSTANCES)
        .setOperatingSystem(OPERATING_SYSTEM)
        .setMachineClass(MACHINE_CLASS)
        .setSeries(SERIES)
        .setMachineType(MACHINE_TYPE)
        .setGPU(NUMBER_OF_GPUS, GPU_TYPE)
        .setLocalSSD(LOCAL_SSD)
        .setDatacenterLocation(DATACENTER_LOCATION)
        .setCommittedUsage(COMMITTED_USAGE)
        .addToEstimate();
  }
}
