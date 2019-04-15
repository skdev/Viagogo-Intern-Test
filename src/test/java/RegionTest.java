import org.junit.Assert;
import org.junit.Test;

import viagogo.event.Location;
import viagogo.world.Region;

/**
 * Contains tests relating {@link viagogo.world.Region}
 * 
 * @author Suraj Kumar <k975@live.co.uk>
 */
public class RegionTest {

	@Test
	public void testIntersection() {
		
		Location upperBound = new Location(10, 10);
		Location lowerBound = new Location(-10, -10);

		Region a = new Region(1, upperBound, lowerBound);
		Region b = new Region(2, upperBound, lowerBound);
		
		Assert.assertTrue(a.intersects(b));
	}
	
}
