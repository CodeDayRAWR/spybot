package com.zapflame.core;

public class Attack {
  public enum TYPE {
    DAMAGE, BIT_DELETE, BIT_CREATE, HEAL
  }

  int targetX, targetY;

  public TYPE t;
  public int magnitude;

  public Attack(int targetX, int targetY, TYPE t, int magnitude) {
    this.targetX = targetX;
    this.targetY = targetY;
    this.t = t;
    this.magnitude = magnitude;
  }
}
