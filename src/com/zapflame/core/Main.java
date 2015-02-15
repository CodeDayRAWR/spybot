package com.zapflame.core;

import java.util.ArrayList;

import com.zapflame.interfaces.*;


public class Main {
  public static void main(String[] args) {
    TerminalInterface i1 = new TerminalInterface();
    Player p1 = new Player(i1);
    Player p2 = new Player(new NullInterface());
    ArrayList<Player> players = new ArrayList<Player>();
    players.add(p1);
    players.add(p2);
    BoardState.loadFromFile("res/demo-level.json");
    //Battle b = new Battle(players);
    //b.run();
  }

}
