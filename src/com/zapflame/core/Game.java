package com.zapflame.core;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Collections;
import java.util.UUID;

public class Game {
  protected List<Player> players;
  protected Map<Player, Set<UUID>> unitOwners;
  GameState gs;
  
  public Game(List<Player> players) {
    this.players = Collections.unmodifiableList(players);
    gs = new GameState();
  }

  public void run() {
	  players.get(0).updateGameState(gs);
	  players.get(0).control.update();
  }
}
