package com.zapflame.core;

public class Attack implements Action {
  protected final Affect affect;
  protected final Position target;

  public Attack(Affect affect, Position target) {
    this.affect = affect;
    this.target = target;
  }
}
