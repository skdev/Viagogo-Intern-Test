package viagogo.world;

import viagogo.event.Location;

/**
 * A {@link viagogo.world.Region} is an area within a
 * {@link viagogo.world.World}.
 * 
 * Region is based on an upperbound and lowerbound, take the following image:
 * 
 * <br>
 * U######<br>
 * #######<br>
 * ######L<br>
 * <br>
 * 
 * The 'U' and 'L' represent the upper and lower bounds. Once those coordinates
 * have been set a {@link viagogo.world.Region} is created.
 * 
 * @author Suraj Kumar <k975@live.co.uk>
 * @version 1.0
 */
public class Region {
	/**
	 * The unique Id to identify this {@link viagogo.world.Region}.
	 */
	private final int id;
	/**
	 * The upperbound of this {@link viagogo.world.Region}.
	 */
	private final Location upperBound;
	/**
	 * The lowerbound of this {@link viagogo.world.Region}.
	 */
	private final Location lowerBound;

	/**
	 * Constructs a new {@link viagogo.world.Region}
	 * 
	 * @param id
	 * 			@see {@link viagogo.world.Region#id}
	 * @param upperBound
	 * 			@see {@link viagogo.world.Region#upperBound}
	 * @param lowerBound
	 * 			@see {@link viagogo.world.Region#lowerBound}
	 */
	public Region(int id, Location upperBound, Location lowerBound) {
		this.id = id;
		this.upperBound = upperBound;
		this.lowerBound = lowerBound;
	}

	/**
	 * This method checks if a certain {@link viagogo.event.Location} interests
	 * this {@link viagogo.world.Region}
	 * 
	 * @param location
	 *            The {@link viagogo.event.Location} to check.
	 * @return TRUE if the {@link viagogo.event.Location} intersects the
	 *         {@link viagogo.world.Region}.
	 */
	public boolean intersects(Location location) {
		int x = location.getX();
		int y = location.getY();

		boolean inBounds = x >= lowerBound.getX() && y <= upperBound.getY() && x <= upperBound.getX()
				&& y >= lowerBound.getY();

		return inBounds;
	}

	/**
	 * Checks if a {@link viagogo.world.Region} intersects another
	 * {@link viagogo.world.Region}
	 * 
	 * @param region
	 *            The {@link viagogo.world.Region} to check
	 * @return TRUE if the {@link viagogo.world.Region} intersects
	 */
	public boolean intersects(Region region) {
		Location upper = region.upperBound;
		Location lower = region.lowerBound;

		boolean upperIntersects = intersects(upper);
		boolean lowerIntersects = intersects(lower);

		System.out.println(upperIntersects + ", " + lowerIntersects);

		return upperIntersects && lowerIntersects;
	}

	/**
	 * @return {@link viagogo.world.Region#id}
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return {@link viagogo.world.Region#upperBound}
	 */
	public Location getUpperBound() {
		return upperBound;
	}

	/**
	 * @return {@link viagogo.world.Region#lowerBound}
	 */
	public Location getLowerBound() {
		return lowerBound;
	}
}
