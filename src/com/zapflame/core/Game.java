package com.zapflame.core;

public class Game {
  protected Set<Interface> interfaces;
  protected List<Player> players;
  
  public Game(List<Player> players) {
    this.players = Collections.unmodifiableList(players);
  }
  
  public void attachInterface(Interface i) {
    interfaces.add(i);
  }
  
  public void run() {
    // Code goes here
  }
}
