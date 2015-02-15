package me.spyboat.core;

import java.util.UUID;

public abstract class Action {
  public static final Action endTurn = new EndTurn(null, null);

  protected final UUID target;
  protected final Position pos;

  public Action(UUID target, Position pos) {
	  this.target = target;
	  this.pos = pos;
  }
}

class EndTurn extends Action {
	public EndTurn(UUID unit, Position target) {
		super(unit, target);
	}
}
