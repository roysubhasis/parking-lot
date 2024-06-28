package com.parking.lot.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ParkingLot {
  private Slot start;
  private Integer numOfOccupiedSlots;
  private Integer size;

  public void updateOccupiedSlots(int val) {
    this.numOfOccupiedSlots += val;
  }
}
