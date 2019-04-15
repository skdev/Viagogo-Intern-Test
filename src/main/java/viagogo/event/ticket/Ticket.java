package viagogo.event.ticket;

import viagogo.event.EventProxy;

/**
 * This class models a ticket required for accessing events.
 * 
 * @author Suraj Kumar <k975@live.co.uk>
 * @version 1.0
 */
public class Ticket {
	/**
	 * The unique Id to identify this {@link viagogo.event.ticket.Ticket}.
	 */
	private int id;
	/**
	 * The price of this {@link viagogo.event.ticket.Ticket} in US dollars.
	 */
	private double price;
	/**
	 * The {@link viagogo.event.Event} this ticket is used for.
	 */
	private EventProxy event;

	/**
	 * Constructs a new {@link viagogo.event.ticket.Ticket} with the appropriate
	 * {@link viagogo.event.Event} and price of the
	 * {@link viagogo.event.ticket.Ticket}.
	 * 
	 * @param id
	 * 			@see {@link viagogo.event.ticket.Ticket#id}
	 * @param event
	 * 			@see {@link viagogo.event.ticket.Ticket#event}
	 * @param price
	 * 			@see {@link viagogo.event.ticket.Ticket#price}
	 */
	public Ticket(int id, EventProxy event, double price) {
		if (price <= 0) {
			throw new IllegalArgumentException("Ticket price must be greater than 0");
		}
		if (event == null) {
			throw new NullPointerException("Cannot create ticket with null event");
		}
		this.id = id;
		this.event = event;
		this.price = price;
	}

	/**
	 * @return {@link viagogo.event.ticket.Ticket#id}
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * @return {@link viagogo.event.ticket.Ticket#event}
	 */
	public EventProxy getEvent() {
		return event;
	}

	/**
	 * @return {@link viagogo.event.ticket.Ticket#price}
	 */
	public double getPrice() {
		return price;
	}
}