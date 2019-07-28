package com.qxm.weather.Repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.qxm.weather.model.Location;

@Repository("locationRepository")
public class InMemLocationRepository implements LocationRepository {
	private List<Location> locations= new ArrayList<>();
	public InMemLocationRepository() { 
		Location location = new Location("Campbell, CA",-74.2862,45.9786);
		locations.add(location);
		location = new Location("Omaha, NE",-95.9272,41.2498);
		locations.add(location);
		location = new Location("Austin, TX", -97.7437, 30.2711);
	    locations.add(location);
		location = new Location("Niseko, Japan",140.6873,42.8047);
		locations.add(location);
		location = new Location("Nara, Japan",135.8817,34.2963);
		locations.add(location);
		location = new Location("Jakarta, Indonesia",106.8272,-6.1754);
		locations.add(location);
	}
	@Override
	public List<Location> findAll() {
		// TODO Auto-generated method stub
		return locations;
	}

}
