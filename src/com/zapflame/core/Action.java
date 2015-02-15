package com.zapflame.core;

public abstract class Action {
  public static final Action endTurn = new EndTurn(null, null);
  public static final Action endMove = new EndMove(null, null);

  Unit unit;
  Cell target;

  public Action(Unit unit, Cell target) {
	  this.unit = unit;
	  this.target = target;
  }
}

class EndTurn extends Action {
	public EndTurn(Unit unit, Cell target) {
		super(unit, target);
	}
}
