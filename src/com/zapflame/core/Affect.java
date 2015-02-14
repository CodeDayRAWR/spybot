package com.zapflame.core;

public class Affect {
  public enum Sort {
    HEALTH, FLOOR, STEPCAP, SIZECAP
  }

  protected Affect(TYPE t, int magnitude, int cost, int requiredSize) {
    this.t = t;
    this.magnitude = magnitude;
  }

  public final Sort sort;
  public final int magnitude;
  public final int cost;
  public final int requiredSize;
}
