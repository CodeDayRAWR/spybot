package com.zapflame.core;

import java.util.Collections;
import java.util.List;

public class Game {
  protected List<Player> players;
  private GameState gs;

  public Game(List<Player> players) {
    this.players = Collections.unmodifiableList(players);
    gs = new GameState(16, 13);
  }

  public void run() {
	  players.get(0).updateGameState(gs);
	  players.get(0).control.update();    
  }
}
