package me.spyboat.core;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Collections;
import java.util.UUID;

public class Battle {
  protected final List<Player> players;
  protected final BoardState initialBoardState;
  protected final Map<Player, Integer> unitOwners;
  protected Stack<BoardState> undoStack;

  protected Set<GameObserver> observers;

  public Battle(List<Player> players,
                BoardState boardState,
                Map<Player, Integer> unitOwners) {
    this.players = Collections.unmodifiableList(players);
    initialBoardState = boardState;
    this.unitOwners = Collections.unmodifiableMap(unitOwners);
  }

  public void addObserver(GameObserver observer) {
    observers.add(observer);
  }

  public void removeObserver(GameObserver observer) {
    observers.remove(observer);
  }

  public void run() {
    undoStack = new Stack<BoardState>();
    undoStack.push(initialBoardState);
    players.get(0).updateBoardState(initialBoardState);

  }

  public void validAction(Player p, Action a) {
  }

  // Returns whether the action went through

  public void doTurn(Player player) {
    player.transferControl();
    player.getTurn(new TurnBuilder() {
      public void doAction(Action action) {

      }
      public void undoLast() {

      }
      public void finish() {

      }
    });
  }
}
