package com.zapflame.core;

import com.zapflame.interfaces.PlayerInterface;

public class Player {
  PlayerInterface control;
  public UnitState activeUnit;
  public BoardState gs;

  public Player(PlayerInterface control) {
    this.control = control;
    control.setParent(this);
  }
  
  public void updateBoardState(BoardState gs) {
	  this.gs = gs;
	  control.updateBoardState(gs);
  }
  
  public void getTurn(TurnBuilder tb) {
	  
  }
}
