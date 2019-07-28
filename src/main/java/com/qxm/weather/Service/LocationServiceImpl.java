package com.qxm.weather.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qxm.weather.Repository.LocationRepository;
import com.qxm.weather.model.Location;

@Service
public class LocationServiceImpl implements LocationService {
	@Autowired
    private LocationRepository repository;
    
	@Override
	public List<Location> findAll() {
		return repository.findAll();
	}

}
