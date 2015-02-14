package com.zapflame.core;


public class Move extends Action {
  int x, y;
  UID unitID;
  public Move(UID unitID, int x, int y) {
    this.unitID = unitID;
    this.x = x;
    this.y = y;
  }
}
