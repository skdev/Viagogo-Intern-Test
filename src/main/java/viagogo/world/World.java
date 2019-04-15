package viagogo.world;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import viagogo.event.EventProxy;

/**
 * A {@link viagogo.world.World} models the real world and contains
 * {@link viagogo.world.Region}s and {@link viagogo.event.Event}s that
 * correspond to the region.
 * 
 * @author Suraj Kumar <k975@live.co.uk>
 * @version 1.0
 */
public class World {
	/**
	 * The Logger instance
	 */
	private static final Logger logger = LoggerFactory.getLogger(World.class);
	/**
	 * A List of {@link viagogo.world.Region}s that are available in the
	 * {@link viagogo.world.World}.
	 */
	private List<Region> regions = new ArrayList<>();
	/**
	 * A Map that links {@link viagogo.event.EventProxy}'s to
	 * {@link viagogo.world.Region}s.
	 */
	private Map<EventProxy, Region> map = new HashMap<>();

	/**
	 * Adds a {@link viagogo.world.Region} to
	 * {@link viagogo.world.World#regions}
	 * 
	 * @param region
	 *            The {@link viagogo.world.Region} to add
	 */
	public void registerRegion(Region region) {
		if (regions.contains(region)) {
			logger.warn("Region " + region.getId() + ", is already registered to the world.");
		} else {
			regions.add(region);
		}
	}

	/**
	 * Removes the {@link viagogo.world.Region} from
	 * {@link viagogo.world.World#regions}.
	 * 
	 * @param region
	 *            The {@link viagogo.world.Region} to remove
	 */
	public void removeRegion(Region region) {
		regions.remove(region);
	}

	/**
	 * Maps an {@link viagogo.event.EventProxy} to a
	 * {@link viagogo.world.Region} and stores the pair into
	 * {@link viagogo.world.World#map}.
	 * 
	 * An {@link viagogo.event.EventProxy} can only be mapped to a
	 * {@link viagogo.world.Region} if the events {@link viagogo.event.Location}
	 * interests the {@link viagogo.world.Region} it is mapping to.
	 * 
	 * @param proxy
	 *            The {@link viagogo.event.EventProxy} to map
	 * @param region
	 *            The {@link viagogo.world.Region} to map
	 */
	public void registerEvent(EventProxy proxy, Region region) {
		if (!region.intersects(proxy.getEvent().getLocation())) {
			logger.warn("Cannot register event " + proxy.getId() + " because it is out of the region " + region.getId()
					+ "'s bounds.");
			return;
		}

		if (isConflictingEvent(proxy)) {
			logger.warn("Cannot register event " + proxy.getId()
					+ " because there is already another event at its location.");
			return;
		}

		map.put(proxy, region);
	}

	/**
	 * Checks {@link viagogo.world.World#map} to see if an
	 * {@link viagogo.event.EventProxy} already exists in the
	 * {@link viagogo.event.Location}.
	 * 
	 * @param proxy
	 *            The {@link viagogo.event.EventProxy} to check
	 * @return TRUE if there is already an event at the location.
	 */
	public boolean isConflictingEvent(EventProxy proxy) {
		for (Map.Entry<EventProxy, Region> entry : map.entrySet()) {
			if (entry.getKey().getEvent().getLocation().equals(proxy.getEvent().getLocation())) {
				return true;
			}
		}
		return false;
	}

	/**
	 * @return {@link viagogo.world.World#map}
	 */
	public Map<EventProxy, Region> getMap() {
		return map;
	}
}
