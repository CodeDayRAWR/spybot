import java.util.List;
import java.util.Collections;

public class UnitState {
  public UnitState(List<Affect> affects, List<Position> position) {
    assert()
    this.affects = Collections.unmodifiableList<Affect>(affects);
    this.position = Collections.unmodifiableList<Position>(position);
  }
  
  protected final List<Affect> affects;
  protected final List<Position> position;
}
