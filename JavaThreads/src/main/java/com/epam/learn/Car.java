package com.epam.learn;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Car implements Runnable {

  private int id;
  private int waitingTime;
  private int parkingTime;
  private Semaphore parkingLot;

  public Car(int id, int waitingTime, int parkingTime, Semaphore parkingLot) {
    this.id = id;
    this.waitingTime = waitingTime;
    this.parkingTime = parkingTime;
    this.parkingLot = parkingLot;
  }

  @Override
  public void run() {
    arriveAtParkingLot();
    try {
      if (parkingLot.tryAcquire(waitingTime, TimeUnit.SECONDS)) {
        System.out.println(this + "is parked for " + parkingTime + " sec");
        TimeUnit.SECONDS.sleep(parkingTime);
        System.out.println(this + "left the parking lot");
        parkingLot.release();
      } else {
        System.out.println(
            this + "can't wait more than " + waitingTime
                + " sec and leaves for another parking lot");
      }
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  public void arriveAtParkingLot() {
    try {
      Thread.sleep(new Random().nextInt(1000));
      System.out.println(this + "arrived at the parking lot");
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  @Override
  public String toString() {
    SimpleDateFormat date = new SimpleDateFormat("hh:mm:ss");
    return date.format(new Date()) + " Car{" +
        "id=" + id +
        "} ";
  }
}
