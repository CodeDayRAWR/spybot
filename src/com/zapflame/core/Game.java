package com.zapflame.core;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Collections;

public class Game {
  protected List<Player> players;
  protected Map<Player, Set<UUID>> unitOwners;

  protected Set<GameObserver> observers;

  public Game(List<Player> players) {
    this.players = Collections.unmodifiableList(players);
    GameState = new GameState();
  }

  public void addObserver(GameObserver observer) {
    observers.add(observer);
  }

  public void run() {
	  players.get(0).updateGameState(gs);
	  players.get(0).control.update();
  }

  public void doTurn(Player player) {
    player.doTurn(new Turn)
  }
}
