package me.spyboat.core;

import java.util.UUID;

public class Attack extends Action {
  protected final Affect affect;

  public Attack(UUID actor, Affect affect, Position pos) {
	super(actor, pos);
    this.affect = affect;
  }
}
