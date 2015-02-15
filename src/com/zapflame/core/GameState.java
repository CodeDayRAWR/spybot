package com.zapflame.core;

import java.io.IOException;
import java.nio.file.Files;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class GameState {
  protected Map<Position, Cell> cells;
  protected Map<UUID, UnitState> units;
  
  public GameState() {
    cells = new HashMap<Position, Cell>();
    units = new HashMap<UUID, UnitState>();
  }
  
  public GameState applyAction(Action a) {
    // Either cast to the appropriate Action subclass here and interpret it, or
    // delegate to an "Action#apply" method
	  return null;
  }

  public static GameState loadFromFile(String path) {
    GameState gs = new GameState();
    try {
      byte[] contents = Files.readAllBytes(java.nio.file.Paths.get(path));
      String s = new String(contents);
      JSONObject jso = new JSONObject(s);
      JSONArray json_cells = (JSONArray) jso.get("cells");
      for (int y = 0; y < 13; y++) {
        for (int x = 0; x < 16; x++) {
          JSONObject o = json_cells.getJSONObject(16*y + x);
          boolean hasFloor = false;
          if (o.has("passable")) {
            hasFloor = o.getBoolean("passable");
          }
          Position p = new Position(x, y);
          gs.cells.put(p, new Cell(hasFloor));
        }
      }

      return gs;
    } catch (IOException e) {
      e.printStackTrace();
    }

    return null;
  }
}
