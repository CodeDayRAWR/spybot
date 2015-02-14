package com.zapflame.core;

public class GameState {
  public Cell[][] cells;

  public GameState(int width, int height) {
    cells = new Cell[height][width];
  }
}
