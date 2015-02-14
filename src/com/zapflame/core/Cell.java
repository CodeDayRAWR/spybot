package com.zapflame.core;

public class Cell {
  int xPos, yPos;
  Unit occupyingUnit = null;

  public Cell(int xPos, int yPos) {
    this.xPos = xPos;
    this.yPos = yPos;
  }
}
