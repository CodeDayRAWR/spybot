package com.zapflame.core;

public class CellState {
  enum FloorType {
    TheOnlyFloorType
  }

  protected boolean hasFloor;
  protected FloorType floor;
  protected Set<Item> items;
}
