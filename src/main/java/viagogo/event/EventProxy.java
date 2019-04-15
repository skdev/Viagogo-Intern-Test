package viagogo.event;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import viagogo.event.ticket.Ticket;

/**
 * EventProxy is a proxy object is used to interact it the
 * {@link viagogo.event.Event} object.
 * 
 * This class is a lightweight wrapper over {@link viagogo.event.Event} and
 * provides additional functionality including handling of
 * {@link viagogo.event.ticket.Ticket}'s.
 * 
 * For more information on the Proxy Pattern see the Wikipedia page:
 * <a href="https://en.wikipedia.org/wiki/Proxy_pattern">Proxy_pattern</a>
 * 
 * @author Suraj Kumar <k975@live.co.uk>
 * @version 1.0
 */
public class EventProxy {
	/**
	 * Logger instance
	 */
	private static final Logger logger = LoggerFactory.getLogger(EventProxy.class);
	/**
	 * The {@link viagogo.event.Event} this class will act as a proxy for.
	 */
	private Event event;
	/**
	 * The price of an event; Note that this does reflect the actual ticket
	 * prices as they can vary.
	 */
	private double price;
	/**
	 * The capacity of an event i.e. how many
	 * {@link viagogo.event.ticket.Ticket}'s can be available for the
	 * {@link viagogo.event.EventProxy#event}.
	 */
	private int capacity;

	/**
	 * A container for {@link viagogo.event.ticket.Ticket}'s that are registered
	 * to the {@link viagogo.event.EventProxy#event}.
	 */
	private List<Ticket> tickets = new ArrayList<>();

	/**
	 * Constructs a new {@link viagogo.event.EventProxy}
	 * 
	 * @param event
	 * @see {@link viagogo.event.EventProxy#event}
	 * @param price
	 * @see {@link viagogo.event.EventProxy#price}
	 * @param capacity
	 * @see {@link viagogo.event.EventProxy#capacity}
	 */
	public EventProxy(Event event, double price, int capacity) {
		this.event = event;
		this.price = price;
		this.capacity = capacity;
	}

	/**
	 * Registers a {@link viagogo.event.ticket.Ticket} to
	 * {@link viagogo.event.EventProxy#tickets}.
	 * 
	 * This method will only register tickets if the ticket has not already been
	 * registered and that the capacity has not yet been reached.
	 * 
	 * @param ticket
	 *            The {@link viagogo.event.ticket.Ticket} to register.
	 */
	public void registerTicket(Ticket ticket) {
		if (tickets.contains(ticket)) {
			logger.warn(ticket.getId() + " has already been registered to " + event.getId());
			return;
		}
		
		if (tickets.size() > capacity) {
			logger.warn("Cannot register ticket " + ticket.getId() + ", capacity of " + capacity + " has been reached.");
			return;
		}

		tickets.add(ticket);
	}

	/**
	 * This methods removes the ticket from
	 * {@link viagogo.event.EventProxy#tickets}.
	 * 
	 * A {@link viagogo.event.ticket.Ticket} is void/not valid when it is not
	 * registered to {@link viagogo.event.EventProxy#tickets}.
	 * 
	 * @param ticket
	 *            The {@link viagogo.event.ticket.Ticket} to remove/void.
	 */
	public void voidTicket(Ticket ticket) {
		tickets.remove(ticket);
	}

	/**
	 * @return If the {@link viagogo.event.ticket.Ticket} is inside
	 *         {@link viagogo.event.EventProxy#tickets}.
	 */
	public boolean isTicketRegistered(Ticket ticket) {
		return tickets.contains(ticket);
	}

	/**
	 * Converts {@link viagogo.event.EventProxy#tickets} into a generic
	 * {@link viagogo.event.ticket.Ticket} array.
	 *
	 * @return An array of {@link viagogo.event.ticket.Ticket} that are
	 *         registered to this {@link viagogo.event.EventProxy}.
	 */
	public Ticket[] getTickets() {
		return tickets.toArray(new Ticket[tickets.size()]);
	}

	/**
	 * @return {@link viagogo.event.EventProxy#price}
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @return {@link viagogo.event.EventProxy#capacity}
	 */
	public int getCapacity() {
		return capacity;
	}

	/**
	 * @return The id of {@link viagogo.event.EventProxy#event}
	 */
	public int getId() {
		return event.getId();
	}

	/**
	 * @return {@link viagogo.event.EventProxy#event}
	 */
	public Event getEvent() {
		return event;
	}
}
