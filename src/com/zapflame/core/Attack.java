package com.zapflame.core;

import com.zapflame.core.Cell;

public class Attack extends Action {
  Unit unit;
  Cell target;
  Affect affect;

  public Attack(Unit unit, Cell target, Affect affect) {
    super(unit, target);
    this.affect = affect;
  }
}
