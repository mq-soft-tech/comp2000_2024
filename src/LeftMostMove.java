import java.util.List;

public class LeftMostMove implements MoveStrategy {
  @Override
  public Cell chooseNextLoc(List<Cell> possibleLocs) {
    return possibleLocs.stream()
			.min(Cell::leftOfComparison)
			.get();
  }

  public String toString() {
    return "left-most movement";
  }
}
