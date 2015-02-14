package com.zapflame.core;

public class Attack {
  int targetX, targetY;
  Affect affect;
  public Attack(int targetX, int targetY, Affect affect) {
    this.targetX = targetX;
    this.targetY = targetY;
    this.affect = affect;
  }
}
