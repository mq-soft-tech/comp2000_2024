import java.util.List;
import java.util.Random;

public class RandomMove implements MoveStrategy {
  @Override
  public Cell chooseNextLoc(List<Cell> possibleLocs) {
    return possibleLocs.stream()
			.skip(new Random().nextInt(possibleLocs.size()))
			.findAny().get();
  }

  public String toString() {
    return "random movement";
  }
}
