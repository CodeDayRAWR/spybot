package com.zapflame.core;

import java.util.UUID;

public class Attack extends Action {
  protected final Affect affect;

  public Attack(UUID target, Affect affect, Position pos) {
	super(target, pos);
    this.affect = affect;
  }
}
