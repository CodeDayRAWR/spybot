package com.zapflame.core;


public class Move extends Action {
  Cell target;
  Unit u;
  public Move(Unit u, Cell target) {
	super(u, target);
  }
}
