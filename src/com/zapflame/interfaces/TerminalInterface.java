package com.zapflame.interfaces;

import java.util.Scanner;

import com.zapflame.core.*;

public class TerminalInterface extends PlayerInterface {
  Player parent;
  GameState gs;
  Scanner inputReader;

  public TerminalInterface() {
    inputReader = new Scanner(System.in);
  }

  public void setParent(Player parent) {
    this.parent = parent;
  }
  
  public void updateGameState(GameState gs) {
    this.gs = gs;
  }

  public Action getAction() {
    Unit active = parent.activeUnit;
    String type = inputReader.next();
    char c = type.charAt(0);
    switch (c) {
      case 'a':
        int affectID = Integer.parseInt(inputReader.next());
        Affect affect = parent.activeUnit.affects.get(affectID);
        int x1 = Integer.parseInt(inputReader.next());
        int y1 = Integer.parseInt(inputReader.next());
        Cell target = gs.cells[y1][x1];
        return new Attack(active, target, affect);
      case 'm':
        int x2 = Integer.parseInt(inputReader.next());
        int y2 = Integer.parseInt(inputReader.next());
        Cell target2 = gs.cells[y2][x2];
        return new Move(active, target2);
      case 's':
        return Action.endMove;
      case 'e':
        return Action.endTurn;
      default:
    	return null;
    }
  }

  public void update() {
    int height = 3 * gs.cells.length + 1;
    int width = 4 * gs.cells[0].length + 1;
    StringBuilder rows[] = new StringBuilder[height];
    // Redraw screen
    for (int y = 0; y < (height - 1); y += 3) {
      for (int i = 0; i < 3; i++) rows[y+i] = new StringBuilder();
      for (int x = 0; x < gs.cells[0].length; x++) {
        rows[y].append("+---");
        rows[y+1].append("+   ");
        rows[y+2].append("+   ");
      }
      for (int i = 0; i < 3; i++) rows[y+i].append("+");
    }
    rows[height-1] = new StringBuilder();
    for (int j = 0; j < width; j++) rows[height-1].append('+');

    for (int r = 0; r < height; r++) {
      System.out.println(rows[r].toString());
    }
  }
}
