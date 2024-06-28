package com.parking.lot;

import com.parking.lot.model.Car;
import com.parking.lot.utils.Constants;
import com.parking.lot.utils.FileUtils;
import com.parking.lot.utils.ParkingUtils;

import java.util.List;
import java.util.Scanner;

public class ParkingLotApplication {

  public static void main(String[] args) {
    if (args != null && args.length > 0) {
      List<String> lines = FileUtils.readFile(args[0]);
      for (String line : lines) {
        performAction(line);
      }
    } else {
      Scanner sc = new Scanner(System.in);
      String command = sc.nextLine();
      while (!Constants.EXIT.equalsIgnoreCase(command)) {
        performAction(command);
        command = sc.nextLine();
      }
    }
  }

  private static void performAction(String line) {
    String split[] = line.split(" ");
    switch (split[0]) {
      case Constants.CREATE_PARKING_LOT:
        ParkingUtils.createParkingLot(split[1]);
        break;
      case Constants.PARK:
        Car car = new Car(split[1], split[2]);
        ParkingUtils.park(car);
        break;
      case Constants.LEAVE:
        ParkingUtils.leave(split[1]);
        break;
      case Constants.STATUS:
        ParkingUtils.status();
        break;
      case Constants.REGISTRATION_NUMBERS_FOR_CARS_WITH_COLOUR:
        ParkingUtils.printRegNosWithColor(split[1]);
        break;
      case Constants.SLOT_NUMBERS_FOR_CARS_WITH_COLOUR:
        ParkingUtils.printSlotNosWithColor(split[1]);
        break;
      case Constants.SLOT_NUMBER_FOR_REGISTRATION_NUMBER:
        ParkingUtils.printSlotNoForRegNo(split[1]);
        break;
      default:
        System.out.println("INVALID COMMAND");
    }
  }
}
