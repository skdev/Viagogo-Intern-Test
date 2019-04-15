
import org.junit.Assert;
import org.junit.Test;

import viagogo.event.Event;
import viagogo.event.EventProxy;
import viagogo.event.Location;
import viagogo.world.Region;
import viagogo.world.World;

/**
 * Contains tests relating {@link viagogo.world.World}
 * 
 * @author Suraj Kumar <k975@live.co.uk>
 */
public class WorldTest {
	private World world;
	private Region region;
	
	public WorldTest() {
		world = new World();
		region = new Region(0, new Location(10,10), new Location(-10, -10));
		world.registerRegion(region);
	}

	@Test
	public void testRegister() {
		Event nonConflictingEvent = new Event(1, new Location(4,5));
		Event nonConflictingEvent1 = new Event(2, new Location(1,5));
		Event conflictingEvent = new Event(4, new Location(4,5));

		EventProxy nonConflictingProxy = new EventProxy(nonConflictingEvent, 0, 0);
		EventProxy nonConflictingProxy1 = new EventProxy(nonConflictingEvent1, 0, 0);
		EventProxy conflictingProxy = new EventProxy(conflictingEvent, 0, 0);

		world.registerEvent(nonConflictingProxy, region);
		world.registerEvent(nonConflictingProxy1, region);
		world.registerEvent(conflictingProxy, region);

		int size = world.getMap().size();
		Assert.assertEquals(size, 2);
	}
	
	@Test
	public void testConflicting() {
		Event nonConflictingEvent = new Event(1, new Location(4,5));
		Event nonConflictingEvent1 = new Event(2, new Location(1,5));
		Event nonConflictingEvent2 = new Event(3, new Location(10,2));

		EventProxy nonConflictingProxy = new EventProxy(nonConflictingEvent, 0, 0);
		EventProxy nonConflictingProxy1 = new EventProxy(nonConflictingEvent1, 0, 0);
		EventProxy nonConflictingProxy2 = new EventProxy(nonConflictingEvent2, 0, 0);
		
		world.registerEvent(nonConflictingProxy, region);
		world.registerEvent(nonConflictingProxy1, region);
		world.registerEvent(nonConflictingProxy2, region);
		
		Event conflictingEvent = new Event(4, new Location(4,5));
		EventProxy conflictingProxy = new EventProxy(conflictingEvent, 0, 0);
		
		boolean conflicting = world.isConflictingEvent(conflictingProxy);
		boolean nonConflicting = world.isConflictingEvent(new EventProxy(new Event(5, new Location(1,1)), 0, 0));
		
		Assert.assertTrue(conflicting);
		Assert.assertFalse(nonConflicting);
	}
	
	@Test
	public void testBounds() {
		Location passLocation = new Location(3, 4);
		Location passLocation2 = new Location(10, 10);
		Location passLocation3 = new Location(-10, -10);
		Location failLocation = new Location(20,10);
		Location failLocation2 = new Location(100,100);
		
		Assert.assertTrue(region.intersects(passLocation));
		Assert.assertTrue(region.intersects(passLocation2));
		Assert.assertTrue(region.intersects(passLocation3));
		Assert.assertFalse(region.intersects(failLocation));
		Assert.assertFalse(region.intersects(failLocation2));
	}
	
}
