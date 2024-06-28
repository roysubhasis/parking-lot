package com.parking.lot.model;

import lombok.Data;

import java.util.Objects;

@Data
public class Slot {
  private Integer pos;
  private Slot next;
  private boolean isOccupied;
  private Car car;

  public Slot(Integer pos) {
    this.pos = pos;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Slot slot = (Slot) o;
    return pos == slot.pos;
  }

  @Override
  public int hashCode() {
    return Objects.hash(pos, next, isOccupied, car);
  }
}
