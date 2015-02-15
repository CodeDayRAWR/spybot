package com.zapflame.core;

public class Cell {
  protected boolean hasFloor;
  protected FloorType floor;
  enum FloorType {
    TheOnlyFloorType
  }
  public Cell(boolean hasFloor) {
	  this.hasFloor = hasFloor;
  }
}
