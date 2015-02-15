package com.zapflame.core;

import java.util.Set;

public class Cell {
  protected boolean hasFloor;
  protected FloorType floor;
  protected Set<Item> items;

  enum FloorType {
    TheOnlyFloorType
  }
  public Cell(boolean hasFloor) {
    this.hasFloor = hasFloor;
  }
}
