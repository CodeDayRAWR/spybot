package com.zapflame.core;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
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
  }
}
