package me.spyboat.core;

public interface TurnBuilder {
  public void doAction(Action action);
  public void undoLast();
  public void finish();
}
