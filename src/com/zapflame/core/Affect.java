package com.zapflame.core;

public class Affect {
  public enum TYPE {
    DAMAGE, BIT_DELETE, BIT_CREATE, HEAL
  }

  public TYPE t;
  public int magnitude;

  public Affect(TYPE t, int magnitude) {
    this.t = t;
    this.magnitude = magnitude;
  }
}
