package com.zapflame.interfaces;

public interface PlayerInterface {
  public Move getMove();
  public void update(Message);
  public void update(GameStateMessage);
}
