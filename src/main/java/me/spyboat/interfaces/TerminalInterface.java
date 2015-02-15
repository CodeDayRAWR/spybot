package me.spyboat.interfaces;

import java.util.Scanner;
import java.util.UUID;

import me.spyboat.core.*;

public class TerminalInterface extends PlayerInterface {
  Player parent;
  BoardState bs;
  Scanner inputReader;

  public TerminalInterface() {
    inputReader = new Scanner(System.in);
  }

  public void setParent(Player parent) {
    this.parent = parent;
  }
  
  public void updateBoardState(BoardState bs) {
    this.bs = bs;
    this.update();
  }

  public Action getAction() {
    UnitState active = parent.activeUnit;
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
    }
  }

  public void update() {
    int height = 4 * 13 + 1;
    int width = 4 * 16 + 1;
    StringBuilder rows[] = new StringBuilder[height];
    // Redraw screen
    for (int y = 0; y < (height - 1); y += 4) {
      for (int i = 0; i < 4; i++) rows[y+i] = new StringBuilder();
      for (int x = 0; x < 16; x++) {
        Cell c = bs.cells.get(new Position(x, y/4));
        rows[y].append("+---");
        rows[y+1].append("|   ");
        rows[y+2].append("|   ");
        rows[y+3].append("|   ");
        if (!c.hasFloor) {
          rows[y+2].setCharAt(2 + x*4, 'X');
        }
      }
      rows[y].append('+');
      for (int i = 1; i < 4; i++) rows[y+i].append("|");
    }
    rows[height-1] = new StringBuilder();
    for (int j = 0; j < (width - 1) / 4; j++) rows[height-1].append("+---");

    // Draw the units
    for (UUID uid : bs.units.keySet()) {
      UnitState us = bs.units.get(uid);
      Position head = us.sectors.get(0);
      char headChar = us.baseUnit.name.charAt(0);
      if (us == parent.activeUnit) {
        headChar = Character.toLowerCase(headChar);
      }

      rows[2+head.y*4].setCharAt(2+head.x*4, headChar);

      for (int i = 1; i < us.sectors.size(); i++) {
        Position next = us.sectors.get(i);
        //System.out.print("(" + next.x + ", " + next.y + ") ");
        if (next.x < head.x) {
          rows[2+next.y*4].setCharAt(2+next.x*4, '-');
          rows[2+next.y*4].setCharAt(3+next.x*4, '>');
        } else if (next.x > head.x) {
          rows[2+next.y*4].setCharAt(1+next.x*4, '<');
          rows[2+next.y*4].setCharAt(2+next.x*4, '-');
        } else if (next.y > head.y) {
          rows[2+next.y*4].setCharAt(2+next.x*4, '|');
          rows[1+next.y*4].setCharAt(2+next.x*4, '^');
        } else {
          rows[2+head.y*4].setCharAt(2+head.x*4, '|');
          rows[3+head.y*4].setCharAt(2+head.x*4, 'v');
        }
        head = next;
      }
      //System.out.println();
    }

    for (int r = 0; r < height; r++) {
      System.out.println(rows[r].toString());
    }
  }
}
