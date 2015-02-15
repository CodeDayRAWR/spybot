package com.zapflame.core;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Collections;

public class Game {
  protected List<Player> players;
  protected Map<Player, Set<UUID>> unitOwners;

  public Game(List<Player> players) {
    this.players = Collections.unmodifiableList(players);
    GameState = new GameState();
  }

  public void run() {
	  players.get(0).updateGameState(gs);
	  players.get(0).control.update();
  }
}
