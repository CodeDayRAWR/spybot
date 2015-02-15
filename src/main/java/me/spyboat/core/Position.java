package me.spyboat.core;

public final class Position {
  public final int x, y;
  public Position(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public int distance(Position p) {
    return Math.abs(x - p.x) + Math.abs(y - p.y);
  }
  
  public boolean equals(Object obj) {
    if (super.equals(obj)) {
      return true;
    }
    
    if (obj instanceof Position) {
      Position that = (Position) obj;
      return that.x == this.x && that.y == this.y;
    }
    else {
      return false;
    }
  }
  public int hashCode() {
    return (x << 16) ^ (y & 0xFFFF);
  }
}
