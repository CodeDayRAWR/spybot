package com.zapflame.core;


public class GameStateMessage extends Message {
  public GameState gs;

  public GameStateMessage(String message, GameState gs) {
    super(message);
    this.gs = gs;
  }
}
