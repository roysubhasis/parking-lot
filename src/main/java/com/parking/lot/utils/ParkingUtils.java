package com.parking.lot.utils;

import com.parking.lot.model.Car;
import com.parking.lot.model.ParkingLot;
import com.parking.lot.model.Slot;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class ParkingUtils {

  private static ParkingLot parkingLot = null;
  private static HashMap<String, List<Slot>> colorSlotMap = new HashMap<String, List<Slot>>();
  private static HashMap<String, Integer> regNoSlotNoMap = new HashMap<String, Integer>();

  public static void createParkingLot(String size) {
    Integer parkingLotSize = Integer.valueOf(size);
    Slot start = new Slot(1);
    parkingLot = new ParkingLot(start, 0, parkingLotSize);
    Slot temp = start;
    int counter = 2;
    while (counter <= parkingLotSize) {
      Slot slot = new Slot(counter);
      temp.setNext(slot);
      temp = temp.getNext();
      counter = counter + 1;
    }
    System.out.println("Created a parking lot with " + size + " slots");
  }

  public static void park(Car car) {
    if (parkingLot.getNumOfOccupiedSlots() == parkingLot.getSize()) {
      System.out.println("Sorry, parking lot is full");
    } else {
      Slot slot = parkingLot.getStart();
      while (slot.isOccupied()) {
        slot = slot.getNext();
      }
      slot.setCar(car);
      slot.setOccupied(true);
      parkingLot.updateOccupiedSlots(1);
      addMisc(slot);
      System.out.println("Allocated slot number: " + slot.getPos());
    }
  }

  public static void leave(String str) {
    Integer slotNo = Integer.valueOf(str);
    Slot slot = parkingLot.getStart();
    boolean left = false;
    while (slot != null) {
      if (slot.getPos() == slotNo && slot.isOccupied()) {
        removeMisc(slot);
        slot.setCar(null);
        slot.setOccupied(false);
        System.out.println("Slot number " + slot.getPos() + " is free");
        parkingLot.updateOccupiedSlots(-1);
        left = true;
        break;
      }
      slot = slot.getNext();
    }
    if (!left) {
      System.out.println("Slot number " + str + " was already free");
    }
  }

  public static void status() {
    Slot slot = parkingLot.getStart();
    System.out.println("Slot No.\tRegistration No\t\tColour");
    while (slot != null) {
      if (slot.isOccupied()) {
        System.out.println(
            slot.getPos()
                + "\t\t\t"
                + slot.getCar().getRegNo()
                + "\t\t"
                + slot.getCar().getColor());
      }
      slot = slot.getNext();
    }
  }

  private static void addMisc(Slot slot) {
    regNoSlotNoMap.put(slot.getCar().getRegNo(), slot.getPos());
    List<Slot> slots = colorSlotMap.get(slot.getCar().getColor());
    if (slots == null) {
      colorSlotMap.put(slot.getCar().getColor(), new LinkedList<>());
    }
    colorSlotMap.get(slot.getCar().getColor()).add(slot);
  }

  private static void removeMisc(Slot slot) {
    regNoSlotNoMap.remove(slot.getCar().getRegNo());
    List<Slot> slots = colorSlotMap.get(slot.getCar().getColor());
    if (slots == null) {
      slots = new LinkedList<>();
    }
    slots.remove(slot);
    // colorSlotMap.get(slot.getCar().getColor()).add(slot);
  }

  public static void printRegNosWithColor(String color) {
    List<Slot> slots = colorSlotMap.get(color);
    List<String> collect =
        slots.stream().map(s -> s.getCar().getRegNo()).collect(Collectors.toList());
    System.out.println(String.join(",", collect));
  }

  public static void printSlotNosWithColor(String color) {
    List<Slot> slots = colorSlotMap.get(color);
    List<String> collect =
        slots.stream().map(s -> String.valueOf(s.getPos())).collect(Collectors.toList());
    System.out.println(String.join(",", collect));
  }

  public static void printSlotNoForRegNo(String regNo) {
    String result =
        regNoSlotNoMap.containsKey(regNo) ? String.valueOf(regNoSlotNoMap.get(regNo)) : "Not found";
    System.out.println(result);
  }
}
