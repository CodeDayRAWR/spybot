package com.zapflame.interfaces;

import com.zapflame.core.Move;
import com.zapflame.core.Message;
import com.zapflame.core.GameStateMessage;

public interface PlayerInterface {
  public Move getMove();
  public void update(Message m);
  public void update(GameStateMessage gsm);
}
