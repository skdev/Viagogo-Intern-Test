package viagogo.event;

/**
 * Holds absolute coordinate values on a 2d plane.
 * 
 * A Location is a point in a region and cannot be modified e.g. the a person
 * may be standing at vector location {4,5} and the persons position may change
 * to a new location however the location itself will never change and that
 * point will always remain.
 * 
 * @author Suraj Kumar <k975@live.co.uk>
 * @version 1.0
 */
public class Location {
	/**
	 * The X position (vertical axis)
	 */
	private final int x;
	/**
	 * The Y position (horizontal axis)
	 */
	private final int y;

	/**
	 * Constructs a new {@link viagogo.event.Location}
	 * 
	 * @param x
	 *            The x position
	 * @param y
	 *            The y position
	 */
	public Location(int x, int y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * @return {@link viagogo.event.Location#x}
	 */
	public int getX() {
		return x;
	}

	/**
	 * @return {@link viagogo.event.Location#y}
	 */
	public int getY() {
		return y;
	}

	/**
	 * Compares this {@link viagogo.event.Location} to another
	 * {@link viagogo.event.Location} by checking if the
	 * {@link viagogo.event.Location#x} and {@link viagogo.event.Location#y} are
	 * equal on both {@link viagogo.event.Location}'s.
	 * 
	 * @param location
	 *            The other {@link viagogo.event.Location} to compare
	 * @return TRUE if both {@link viagogo.event.Location}'s are equal.
	 */
	public boolean equals(Location location) {
		return x == location.x && y == location.y;
	}
}
