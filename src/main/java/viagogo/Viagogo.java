package viagogo;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

import viagogo.event.Event;
import viagogo.event.EventProxy;
import viagogo.event.Location;
import viagogo.util.ManhattanDistance;
import viagogo.world.Region;
import viagogo.world.World;

/**
 * This is the main class that handles simulation of this application.
 * 
 * @author Suraj Kumar <k975@live.co.uk>
 * @version 1.0
 */
public class Viagogo {
	/**
	 * The default capacity each event can have
	 */
	private static final int DEFAULT_EVENT_CAPACITY = 1;
	/**
	 * The world instance containing all events and regions
	 */
	private World world;
	/**
	 * The region we are in and using
	 */
	private Region region;

	/**
	 * Initialises everything and constructs a new Viagogo
	 */
	public Viagogo() {
		world = new World();
		region = new Region(0, new Location(10, 10), new Location(-10, -10));
		registerRandomEventsToWorld(5);
	}

	/**
	 * Creates random events and registers them to the world
	 * 
	 * @param amount
	 *            The number of events to create
	 */
	private void registerRandomEventsToWorld(int amount) {
		DecimalFormat decimalFormat = new DecimalFormat("####0.00");

		for (int i = 0; i <= amount; i++) {
			int randomX = ThreadLocalRandom.current().nextInt(10);
			int randomY = ThreadLocalRandom.current().nextInt(10);
			double randomPrice = ThreadLocalRandom.current().nextDouble(200);
			double formattedPrice = Double.parseDouble(decimalFormat.format(randomPrice));

			Event event = new Event(i, new Location(randomX, randomY));
			EventProxy proxy = new EventProxy(event, formattedPrice, DEFAULT_EVENT_CAPACITY);
			world.registerEvent(proxy, region);
		}
	}

	/**
	 * Calculates the nearest events from a specified location.
	 * 
	 * @param location
	 *            The source location
	 * @param amount
	 *            The amount of events we want to get
	 * @return An array of EventProxy that are the nearest events.
	 */
	private EventProxy[] getNearestEvents(Location location, int amount) {
		if (amount < 0 || amount > world.getMap().size()) {
			throw new IllegalArgumentException("Amount " + amount
					+ ", must be greater than 0 and small than total amount of events: " + world.getMap().size());
		}

		List<EventProxy> events = new ArrayList<>();
		List<EventProxy> nearestEvents = new ArrayList<>();

		for (Entry<EventProxy, Region> entry : world.getMap().entrySet()) {
			events.add(entry.getKey());
		}
		
		while (nearestEvents.size() != amount) {
			EventProxy closest = null;
			int distance = -1;

			for (int i = 0; i < events.size(); i++) {
				if (events.get(i) != null) {
					int dist = ManhattanDistance.calculate(location, events.get(i).getEvent().getLocation());
					if (distance == -1) {
						distance = dist;
						closest = events.get(i);
					} else {
						if (dist <= distance) {
							distance = dist;
							closest = events.get(i);
						}
					}
				}
			}

			if (closest != null) {
				nearestEvents.add(closest);
				events.remove(closest);
			}
		}

		return nearestEvents.toArray(new EventProxy[nearestEvents.size()]);
	}

	/**
	 * Runs the application
	 */
	public static void main(String[] args) {
		Viagogo viagogo = new Viagogo();
		Scanner scanner = new Scanner(System.in);

		try {
			System.out.println("Please Input Coordinates:");

			String input = scanner.nextLine();
			String[] split = input.split(",");

			int x = Integer.parseInt(split[0]);
			int y = Integer.parseInt(split[1]);

			Location location = new Location(x, y);
			EventProxy[] nearestEvents = viagogo.getNearestEvents(location, 5);

			for (EventProxy proxy : nearestEvents) {
				if (proxy != null) {
					int distance = ManhattanDistance.calculate(location, proxy.getEvent().getLocation());
					System.out.println("Event " + proxy.getId() + " - $" + proxy.getPrice() + ", Distance " + distance);
				}
			}

		} finally {
			scanner.close();
		}

	}
}
