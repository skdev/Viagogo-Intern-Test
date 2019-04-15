package viagogo.util;

import viagogo.event.Location;

/**
 * <a href=
 * "https://en.wiktionary.org/wiki/Manhattan_distance">Manhattan_distance</a>
 * 
 * @author Suraj Kumar <k975@live.co.uk>
 * @version 1.0
 */
public class ManhattanDistance {
	/**
	 * Private constructor used to stop instantiation of this class
	 */
	private ManhattanDistance() {
		throw new AssertionError();
	}

	/**
	 * Calculates the distances using the Manhattan distance algorithm between 2
	 * {@link viagogo.event.Location}'s
	 * 
	 * @return An integer value of the distance
	 */
	public static int calculate(Location loc1, Location loc2) {
		return Math.abs(loc1.getX() - loc2.getX()) + Math.abs(loc1.getY() - loc2.getY());
	}
}
