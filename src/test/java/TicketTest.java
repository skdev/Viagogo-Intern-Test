import org.junit.Assert;
import org.junit.Test;

import viagogo.event.Event;
import viagogo.event.EventProxy;
import viagogo.event.Location;
import viagogo.event.ticket.Ticket;

/**
 * Contains tests relating {@link viagogo.event.ticket.Ticket}
 * 
 * @author Suraj Kumar <k975@live.co.uk>
 */
public class TicketTest {

	@Test
	public void testRegister() {
		Event event = new Event(1, new Location(5,5));
		EventProxy proxy = new EventProxy(event, 38.5, 1);
		
		Ticket ticket = new Ticket(1, proxy, 38.5);
		Ticket ticket2 = new Ticket(2, proxy, 38.5);

		
		proxy.registerTicket(ticket);
		proxy.registerTicket(ticket);
		proxy.registerTicket(ticket2);
		
		Assert.assertTrue(proxy.isTicketRegistered(ticket));
		Assert.assertEquals(proxy.getTickets().length, 2);

		proxy.voidTicket(ticket2);
		Assert.assertEquals(proxy.getTickets().length, 1);
	}
	
	@Test
	public void testTicketConstruction() {
		Event event = new Event(1, new Location(5,5));
		EventProxy proxy = new EventProxy(event, 38.5, 1);
		
		Ticket validTicket = null;
		Ticket invalidTicket = null;
		
		try {
			validTicket = new Ticket(1, proxy, 38.5);
			invalidTicket = new Ticket(2, null, 0);
		} catch (Exception e) {
			/* Ignore */
		}
		
		Assert.assertNotNull(validTicket);
		Assert.assertNull(invalidTicket);
	}
	
}
