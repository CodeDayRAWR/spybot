package com.zapflame.core;

import java.util.UUID;

public class GameState {
  protected Map<Position, Cell> cells;
  protected Map<UUID, UnitState> units;
  
  public GameState() {
    
  }
  
  public GameState applyAction(Action a) {
    // Either cast to the appropriate Action subclass here and interpret it, or
    // delegate to an "Action#apply" method
  }
}
