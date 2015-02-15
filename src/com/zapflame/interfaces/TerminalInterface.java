package com.zapflame.interfaces;

import java.util.Scanner;
import java.util.UUID;

import com.zapflame.core.*;

public class TerminalInterface extends PlayerInterface {
  Player parent;
  BoardState gs;
  Scanner inputReader;

  public TerminalInterface() {
    inputReader = new Scanner(System.in);
  }

  public void setParent(Player parent) {
    this.parent = parent;
  }
  
  public void updateBoardState(BoardState gs) {
    this.gs = gs;
  }

  public Action getAction() {
/*    UUID active = parent.activeUnit.uid;
    String type = inputReader.next();
    char c = type.charAt(0);
    switch (c) {
      case 'a':
        int affectID = Integer.parseInt(inputReader.next());
        Affect affect = parent.activeUnit.affects.get(affectID);
        int x1 = Integer.parseInt(inputReader.next());
        int y1 = Integer.parseInt(inputReader.next());
        Position target = new Position(x1, y1);
        return new Attack(active, affect, target);
      case 'm':
        int x2 = Integer.parseInt(inputReader.next());
        int y2 = Integer.parseInt(inputReader.next());
        Position target2 = new Position(x2, y2);
        return new Step(active, target2);
      case 'e':
        return Action.endTurn;
      default:
    	return null;
    }*/
	  return null;
  }

  public void update() {
    int height = 3 * 13 + 1;
    int width = 4 * 16 + 1;
    StringBuilder rows[] = new StringBuilder[height];
    // Redraw screen
    for (int y = 0; y < (height - 1); y += 3) {
      for (int i = 0; i < 3; i++) rows[y+i] = new StringBuilder();
      for (int x = 0; x < 16; x++) {
        rows[y].append("+---");
        rows[y+1].append("|   ");
        rows[y+2].append("|   ");
      }
      rows[y].append('+');
      for (int i = 1; i < 3; i++) rows[y+i].append("|");
    }
    rows[height-1] = new StringBuilder();
    for (int j = 0; j < (width - 1) / 4; j++) rows[height-1].append("+---");

    for (int r = 0; r < height; r++) {
      System.out.println(rows[r].toString());
    }
  }
}
