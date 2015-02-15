package com.zapflame.core;

public class Affect {
  public enum Sort {
    HEALTH, FLOOR, STEPCAP, SIZECAP
  }

  protected Affect(Sort sort, int magnitude, int cost, int requiredSize) {
    this.sort = sort;
    this.magnitude = magnitude;
    this.cost = cost;
    this.requiredSize = requiredSize;
  }

  public final Sort sort;
  public final int magnitude;
  public final int cost;
  public final int requiredSize;
}
