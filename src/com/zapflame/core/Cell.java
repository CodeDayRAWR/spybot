package com.zapflame.core;

public class CellState {
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
