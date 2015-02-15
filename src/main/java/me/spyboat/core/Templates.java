package me.spyboat.core;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONObject;

public class Templates {
  public static HashMap<String, Unit> units;
  public static HashMap<String, Affect> affects;

  public static void loadTemplates(String affectPath, String unitPath) throws IOException {
    byte[] affectContents = Files.readAllBytes(Paths.get(affectPath));
    String s = new String(affectContents);
    JSONObject jso = new JSONObject(s);
    JSONArray affectArr = (JSONArray) jso.get("affects");
    for (int i = 0; i < affectArr.length(); i++) {
      JSONObject current = affectArr.getJSONObject(i);
      String name = current.getString("name");
      String description = current.getString("description");
      Affect.Sort sort = Affect.Sort.HEALTH;
      int range = current.getInt("range");
      int magnitude = current.getInt("magnitude");
      int requiredSize = current.getInt("requiredSize");
      int cost = current.getInt("cost");
      Affect a = new Affect(sort, magnitude, cost, requiredSize, range, name, description);
      affects.put(name, a);
    }
    
    byte[] unitContents = Files.readAllBytes(Paths.get(unitPath));
    String sUnit = new String(unitContents);
    JSONObject unitJso = new JSONObject(sUnit);
    JSONArray unitArr = (JSONArray) unitJso.get("units");
    for (int i = 0; i < unitArr.length(); i++) {
        JSONObject current = affectArr.getJSONObject(i);
        String name = current.getString("name");
        String description = current.getString("description");
        int moveRate = current.getInt("moveRate");
        int maxSize = current.getInt("maxSize");
        ArrayList<Affect> attacks = new ArrayList<Affect>();
        JSONArray attacksArr = (JSONArray) current.get("attacks");
        for (int j = 0; j < attacksArr.length(); j++) {
        	String attack = attacksArr.getString(j);
        	attacks.add(affects.get(attack));
        }
        
        Unit u = new Unit(attacks, moveRate, maxSize, name, description);
        units.put(name, u);
      }
  }
}
