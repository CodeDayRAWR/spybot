package com.zapflame.core;

import java.util.List;
import java.util.Collections;
import java.util.UUID;

public class UnitState {
  public UnitState(UUID uid, List<Position> sectors, Player owner, int moveRate, int maxSize) {
    this.uid = uid;
    this.sectors = Collections.unmodifiableList(sectors);
    this.owner = owner;
    this.moveRate = moveRate;
    this.maxSize = maxSize;
  }
  
  protected final List<Position> sectors;
  protected final UUID uid;
  final Player owner;
  final int moveRate;
  final int maxSize;
}
