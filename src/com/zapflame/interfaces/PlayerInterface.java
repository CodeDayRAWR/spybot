package com.zapflame.interfaces;

import com.zapflame.core.*;

public abstract class PlayerInterface {
  Player parent;
  BoardState gs;

  public abstract Action getAction();
  public abstract void update();

  public void setParent(Player parent) {
    this.parent = parent;
  }

  public void updateBoardState(BoardState gs) {
    this.gs = gs;
  }
}
