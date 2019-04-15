import org.junit.Assert;
import org.junit.Test;

import viagogo.event.Location;

/**
 * Contains tests relating {@link viagogo.event.Location}
 * 
 * @author Suraj Kumar <k975@live.co.uk>
 */
public class LocationTest {

	@Test
	public void testEquals() {
		Location location = new Location(5, 2);
		Location location2 = new Location(5, 2);
		Location location3 = new Location(6, 4);
		
		Assert.assertTrue(location.equals(location2));
		Assert.assertFalse(location.equals(location3));
	}
	
}
