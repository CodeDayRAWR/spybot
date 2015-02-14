package com.zapflame.core;

public class GameState {
  public static final int WIDTH = 16;
  public static final int HEIGHT = 13;

  public Cell[][] cells;

  public GameState() {
    cells = new Cell[HEIGHT][WIDTH];
  }

  public void initialize() {
    for (int i = 0; i < HEIGHT; i++) {
      for (int j = 0; j < WIDTH; j++) {
        cells[i][j] = new Cell(i, j);
      }
    }
  }
}
