import org.junit.Assert;
import org.junit.Test;

import viagogo.event.Event;
import viagogo.event.EventProxy;
import viagogo.event.Location;
import viagogo.event.ticket.Ticket;

/**
 * Contains all tests relating {@link viagogo.event.EventProxy} and
 * {@link viagogo.event.Event}.
 * 
 * @author Suraj Kumar <k975@live.co.uk>
 */
public class EventTest {

	@Test
	public void testCapacity() {
		int capacity = 1;
		Event event = new Event(0, new Location(5, 9));
		EventProxy proxy = new EventProxy(event, 34.5, 1);

		Ticket[] tickets = { new Ticket(1, proxy, 34.5), new Ticket(2, proxy, 34.5), new Ticket(3, proxy, 34.5) };

		for (Ticket ticket : tickets) {
			proxy.registerTicket(ticket);
		}

		Assert.assertEquals((proxy.getTickets().length - 1), capacity);
	}

}
