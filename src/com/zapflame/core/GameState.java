package com.zapflame.core;

import java.io.IOException;
import java.nio.file.Files;

import org.json.JSONArray;
import org.json.JSONObject;

public class GameState {
  public Cell[][] cells;

  public GameState(int width, int height) {
    cells = new Cell[height][width];
  }

  public static GameState loadFromFile(String path) {
	  GameState gs = new GameState(16,13);
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
	    		gs.cells[y][x] = new Cell(hasFloor);
	    	}
	    }
	    
	    return gs;
	  } catch (IOException e) {
		e.printStackTrace();
	  }
	  
	  return null;
  }
}
