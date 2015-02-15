package me.spyboat.core;

import java.util.ArrayList;
import java.util.HashMap;

import me.spyboat.interfaces.*;


public class Main {
  public static void main(String[] args) throws Exception {
    TerminalInterface i1 = new TerminalInterface();
    Player p1 = new Player(i1);
    Player p2 = new Player(new NullInterface());
    ArrayList<Player> players = new ArrayList<Player>();
    players.add(p1);
    players.add(p2);
    Templates.loadTemplates("res/affects.json", "res/units.json");
    BoardState bs = BoardState.loadFromFile("res/demo-level.json", players);
    HashMap<Player, Integer> ids = new HashMap<Player, Integer>();
    ids.put(p1, 0);
    ids.put(p2, 1);
    Battle b = new Battle(players, bs, ids);
    b.run();
  }

}
