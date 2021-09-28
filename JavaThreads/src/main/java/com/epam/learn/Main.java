package com.epam.learn;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Main {

  private static final int NUMBER_OF_PARKING_SPACES = 2;
  private static final int NUMBER_OF_CARS = 5;
  private static final int MIN_PARKING_TIME = 3;
  private static final int MAX_PARKING_TIME = 6;
  private static final int MIN_WAITING_TIME = 3;
  private static final int MAX_WAITING_TIME = 6;

  public static void main(String[] args) {
    Random random = new Random();
    Semaphore parkingLot = new Semaphore(NUMBER_OF_PARKING_SPACES);
    for (int i = 0; i < NUMBER_OF_CARS; i++) {
      new Thread(new Car(i + 1,
          random.nextInt(MAX_WAITING_TIME - MIN_WAITING_TIME) + MIN_WAITING_TIME,
          random.nextInt(MAX_PARKING_TIME - MIN_PARKING_TIME) + MIN_PARKING_TIME,
          parkingLot)).start();
    }
  }
}
