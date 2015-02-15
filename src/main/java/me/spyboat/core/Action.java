package me.spyboat.core;

import java.util.UUID;

public abstract class Action {
  protected final UUID actor;
  protected final Position pos;

  public Action(UUID actor, Position pos) {
    this.actor = actor;
    this.pos = pos;
  }
}
