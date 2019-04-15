import org.junit.Assert;
import org.junit.Test;

import viagogo.event.Location;
import viagogo.util.ManhattanDistance;

/**
 * Contains tests relating {@link viagogo.util.ManhattanDistance}
 * 
 * @author Suraj Kumar <k975@live.co.uk>
 */
public class ManhattanDistanceTest {

	@Test
	public void testDistance() {
		Location a = new Location(4,5);
		Location b = new Location(4,6);
		Location c = new Location(10,2);
		
		int distanceAB = ManhattanDistance.calculate(a, b);
		int distanceBC = ManhattanDistance.calculate(b, c);
		int distanceAC = ManhattanDistance.calculate(a, c);
		
		Assert.assertTrue(distanceAB < distanceBC);
		Assert.assertTrue(distanceAB < distanceAC);
	}
	
}
