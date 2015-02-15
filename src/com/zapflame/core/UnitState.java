import java.util.List;
import java.util.Collections;

public class UnitState {
  protected final List<Affect> affects;
  protected final List<Position> position;

  public UnitState(List<Affect> affects, List<Position> position) {
    this.affects = Collections.unmodifiableList<Affect>(affects);
    this.position = Collections.unmodifiableList<Position>(position);
  }


}
