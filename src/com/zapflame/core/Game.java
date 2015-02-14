package com.zapflame.core;

public class Game {
  protected List<Player> players;

  public Game(List<Player> players) {
    this.players = Collections.unmodifiableList(players);
  }

  public void run() {
    // Code goes here
  }
}
