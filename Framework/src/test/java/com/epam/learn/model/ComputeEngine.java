package com.epam.learn.model;

import java.util.Objects;

public class ComputeEngine {

  private String numberOfInstances;
  private String operatingSystem;
  private String machineClass;
  private String series;
  private String machineType;
  private String gpuType;
  private int numberOfGPUs;
  private String localSSD;
  private String datacenterLocation;
  private String committedUsage;

  public ComputeEngine(String numberOfInstances, String operatingSystem, String machineClass,
      String series, String machineType, String gpuType, int numberOfGPUs, String localSSD,
      String datacenterLocation, String committedUsage) {
    this.numberOfInstances = numberOfInstances;
    this.operatingSystem = operatingSystem;
    this.machineClass = machineClass;
    this.series = series;
    this.machineType = machineType;
    this.gpuType = gpuType;
    this.numberOfGPUs = numberOfGPUs;
    this.localSSD = localSSD;
    this.datacenterLocation = datacenterLocation;
    this.committedUsage = committedUsage;
  }

  public String getNumberOfInstances() {
    return numberOfInstances;
  }

  public void setNumberOfInstances(String numberOfInstances) {
    this.numberOfInstances = numberOfInstances;
  }

  public String getOperatingSystem() {
    return operatingSystem;
  }

  public void setOperatingSystem(String operatingSystem) {
    this.operatingSystem = operatingSystem;
  }

  public String getMachineClass() {
    return machineClass;
  }

  public void setMachineClass(String machineClass) {
    this.machineClass = machineClass;
  }

  public String getSeries() {
    return series;
  }

  public void setSeries(String series) {
    this.series = series;
  }

  public String getMachineType() {
    return machineType;
  }

  public void setMachineType(String machineType) {
    this.machineType = machineType;
  }

  public String getGpuType() {
    return gpuType;
  }

  public void setGpuType(String gpuType) {
    this.gpuType = gpuType;
  }

  public int getNumberOfGPUs() {
    return numberOfGPUs;
  }

  public void setNumberOfGPUs(int numberOfGPUs) {
    this.numberOfGPUs = numberOfGPUs;
  }

  public String getLocalSSD() {
    return localSSD;
  }

  public void setLocalSSD(String localSSD) {
    this.localSSD = localSSD;
  }

  public String getDatacenterLocation() {
    return datacenterLocation;
  }

  public void setDatacenterLocation(String datacenterLocation) {
    this.datacenterLocation = datacenterLocation;
  }

  public String getCommittedUsage() {
    return committedUsage;
  }

  public void setCommittedUsage(String committedUsage) {
    this.committedUsage = committedUsage;
  }

  @Override
  public String toString() {
    return "ComputeEngine{" +
        "numberOfInstances='" + numberOfInstances + '\'' +
        ", operatingSystem='" + operatingSystem + '\'' +
        ", machineClass='" + machineClass + '\'' +
        ", series='" + series + '\'' +
        ", machineType='" + machineType + '\'' +
        ", gpuType='" + gpuType + '\'' +
        ", numberOfGPUs=" + numberOfGPUs +
        ", localSSD='" + localSSD + '\'' +
        ", datacenterLocation='" + datacenterLocation + '\'' +
        ", committedUsage='" + committedUsage + '\'' +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ComputeEngine that = (ComputeEngine) o;
    return numberOfGPUs == that.numberOfGPUs && Objects
        .equals(numberOfInstances, that.numberOfInstances) && Objects
        .equals(operatingSystem, that.operatingSystem) && Objects
        .equals(machineClass, that.machineClass) && Objects.equals(series, that.series)
        && Objects.equals(machineType, that.machineType) && Objects
        .equals(gpuType, that.gpuType) && Objects.equals(localSSD, that.localSSD)
        && Objects.equals(datacenterLocation, that.datacenterLocation) && Objects
        .equals(committedUsage, that.committedUsage);
  }

  @Override
  public int hashCode() {
    return Objects
        .hash(numberOfInstances, operatingSystem, machineClass, series, machineType, gpuType,
            numberOfGPUs, localSSD, datacenterLocation, committedUsage);
  }
}
