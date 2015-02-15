package me.spyboat.core;

import java.util.Set;

public class Cell {
  public boolean hasFloor;
  public FloorType floor;
  public Set<Item> items;
  public UUID uid;

  enum FloorType {
    TheOnlyFloorType
  }

  public Cell(boolean hasFloor) {
    this.hasFloor = hasFloor;
    this.floor = FloorType.TheOnlyFloorType;
    this.items = null;
    this.uid = null;
  }
}
