package com.zapflame.core;

public class Step extends Action {
  protected final UUID unitID;
  protected final Position newPosition;
  
  public Move(UUID unitID, Position newPosition) {
    this.unitID = unitID;
    this.newPosition = newPosition;
  }
}
