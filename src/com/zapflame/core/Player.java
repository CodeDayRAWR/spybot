package com.zapflame.core;

import com.zapflame.interfaces.PlayerInterface;

public class Player {
  PlayerInterface control;
  public Unit activeUnit;
  public GameState gs;

  public Player(PlayerInterface control) {
    this.control = control;
    control.setParent(this);
  }
  
  public void updateGameState(GameState gs) {
	  this.gs = gs;
	  control.updateGameState(gs);
  }
}
