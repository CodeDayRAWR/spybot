package com.zapflame.interfaces;

import com.zapflame.core.*;

public abstract class PlayerInterface {
  Player parent;
  GameState gs;

  public abstract Action getAction();
  public abstract void update();

  public void setParent(Player parent) {
    this.parent = parent;
  }

  public void updateGameState(GameState gs) {
    this.gs = gs;
  }
}
