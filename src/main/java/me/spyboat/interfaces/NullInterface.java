package me.spyboat.interfaces;

import me.spyboat.core.Action;

public class NullInterface extends PlayerInterface {

  public Action getAction() {
    return null;
  }

  public void update() {		
  }

}
