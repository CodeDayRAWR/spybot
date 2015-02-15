package com.zapflame.core;

import java.util.List;
import java.util.Collections;

public class UnitState {
  public UnitState(List<Affect> affects, List<Position> position) {
    this.affects = Collections.unmodifiableList(affects);
    this.position = Collections.unmodifiableList(position);
  }
  
  protected final List<Affect> affects;
  protected final List<Position> position;
}
