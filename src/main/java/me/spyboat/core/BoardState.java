package me.spyboat.core;

import java.io.IOException;
import java.nio.file.Files;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.UUID;

public class BoardState {
  public Cell[] cells;
  public HashMap<UUID, UnitState> units;

  public BoardState() {
    cells = new Cell[13*16];
    units = new HashMap<UUID, UnitState>();
  }

  public boolean applyAction(Action act) {
    if (!validAction(act)) return false;
    if (act instanceof Attack) {
      Attack attack = (Attack) act;
      UnitState targetUnit = units.get(cells[act.target.y][act.target.x].uid);
      if (attack.magnitude < 0) {
      }
    }
  }

  public boolean validAction(Action act, int player) {
    Cell targetCell = cells[act.target.y][act.target.x];
    UnitState targetUnit;
    if (units.hasKey(targetCell.uid)) {
      targetUnit = units.get(targetCell.uid);
    } else {
      targetUnit = null;
    }
    
    if (units.get(act.actor).isRetired) return false;
    if (units.get(act.actor).owner != player) return false;

    if (act instanceof Attack) {
      if (targetUnit == null) return false;
      Attack attack = (Attack) act;
      UnitState actor = units.get(attack.actor);
      Position head = actor.sectors.get(0);
      int range = attack.affect.range;
      if (head.distance(attack.target) > range) return false;

      if (attack.affect.sort == Affect.Sort.HEALTH) {
        if (affect.magnitude == 0) return false;
        else if (affect.magnitude < 0) {
          if (targetUnit.owner == actor.owner) return false;
        } else {
          if (targetUnit.owner != actor.owner) return false;
        }
      }

      return true;
    }

    return true;
  }

  public static BoardState loadFromFile(String path,
      ArrayList<Player> players) throws IOException {

    BoardState gs = new BoardState();
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

    JSONArray unitArr = (JSONArray) jso.get("units");
    for (int i = 0; i < unitArr.length(); i++) {
      JSONObject unitJso = unitArr.getJSONObject(i);
      String name = unitJso.getString("name");
      int owner = unitJso.getInt("alignment");
      ArrayList<Position> sectors = new ArrayList<Position>();
      JSONArray sectorArr = (JSONArray) unitJso.get("sectors");
      for (int j = 0; j < sectorArr.length(); j++) {
        JSONObject currentSector = sectorArr.getJSONObject(j);
        int x = currentSector.getInt("x");
        int y = currentSector.getInt("y");
        sectors.add(new Position(x, y));
      }

      UUID uid = UUID.randomUUID();
      UnitState u = new UnitState(name, uid, sectors, owner);
      gs.units.put(uid, u);
    }

    return gs;
  }
}
