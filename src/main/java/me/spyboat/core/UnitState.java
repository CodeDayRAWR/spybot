package me.spyboat.core;

import java.util.List;
import java.util.Collections;
import java.util.UUID;

public class UnitState {
  public UnitState(String name, UUID uid, List<Position> sectors, int owner) {
    this.baseUnit = Templates.units.get(name);
    this.uid = uid;
    this.sectors = Collections.unmodifiableList(sectors);
    this.owner = owner;
    this.moveRate = baseUnit.baseMoveRate;
    this.maxSize = baseUnit.baseMaxSize;
  }
  
  public final Unit baseUnit;
  public final List<Position> sectors;
  public final UUID uid;
  public final int owner;
  public final int moveRate;
  public final int maxSize;
}
