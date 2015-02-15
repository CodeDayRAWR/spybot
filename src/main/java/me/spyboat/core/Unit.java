package me.spyboat.core;

import java.util.ArrayList;

public class Unit {
  public ArrayList<Affect> affects;
  public int baseMoveRate, baseMaxSize;
  public String name, description;

  public Unit(ArrayList<Affect> affects, int baseMoveRate, int baseMaxSize,
      String name, String description) {
    this.affects = affects;
    this.baseMoveRate = baseMoveRate;
    this.baseMaxSize = baseMaxSize;
    this.name = name;
    this.description = description;
  }
}
