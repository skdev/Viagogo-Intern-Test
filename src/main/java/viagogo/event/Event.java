package viagogo.event;

/**
 * This class represents an event that occurs at a certain
 * {@link viagogo.event.Location}.
 * 
 * @author Suraj Kumar <k975@live.co.uk>
 * @version 1.0
 */
public class Event {
	/**
	 * The unique Id to identify this {@link viagogo.event.Event}.
	 */
	private int id;
	/**
	 * The {@link viagogo.event.Location} of the {@link viagogo.event.Event}
	 */
	private Location location;

	/**
	 * Constructs a new {@link viagogo.event.Event}
	 * 
	 * @param id
	 *            The {@link viagogo.event.Event#id} of the event
	 * @param location
	 *            The {@link viagogo.event.Location} of the event
	 */
	public Event(int id, Location location) {
		this.id = id;
		this.location = location;
	}

	/**
	 * Sets a new {@link viagogo.event.Location} for this event
	 * 
	 * @param location
	 *            The new {@link viagogo.event.Event#location}
	 */
	public void setLocation(Location location) {
		this.location = location;
	}

	/**
	 * @return {@link Event#location}
	 */
	public Location getLocation() {
		return location;
	}

	/**
	 * @return {@link Event#id}
	 */
	public int getId() {
		return id;
	}
}
