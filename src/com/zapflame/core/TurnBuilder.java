package com.zapflame.core;

public interface TurnBuilder {
  public void do(Action action);
  public void undoLast();
  public void finish();
}
