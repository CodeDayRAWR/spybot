package me.spyboat.core;

public class Affect {
  public enum Sort {
    HEALTH, FLOOR, STEPCAP, SIZECAP
  }
  

  protected Affect(Sort sort, int magnitude, int cost,
      int requiredSize, int range, String name, String description) {
    this.sort = sort;
    this.magnitude = magnitude;
    this.cost = cost;
    this.range = range;
    this.requiredSize = requiredSize;
    this.name = name;
    this.description = description;
  }

  public final String name;
  public final String description;
  public final Sort sort;
  public final int magnitude;
  public final int cost;
  public final int range;
  public final int requiredSize;
}
