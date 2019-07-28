package com.qxm.weather.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.qxm.weather.Repository.LocationRepository;
import com.qxm.weather.Repository.WeatherRepository;
import com.qxm.weather.client.RestClient;
import com.qxm.weather.model.Location;
import com.qxm.weather.model.WeatherResult;

@Service
public class WeatherServiceImpl implements WeatherService {
	@Autowired
	private LocationRepository locationRepository;

	@Autowired
	private WeatherRepository weatherRepository;

	@Autowired
	private RestClient client;
	
	@Override
	public List<WeatherResult> findAll() {
		List<WeatherResult> weathers = new ArrayList<>();
		List<Location> locations = this.locationRepository.findAll();
		
		for (Location location : locations) {
			WeatherResult weather = weatherRepository.findWeatherByLocation(location);
			if (weather == null) {
				String data = client.get(location.getLatitude() + "," + location.getLongitude());
				Gson gson = new GsonBuilder().create();
				weather = gson.fromJson(data, WeatherResult.class);
				weather.setLocationName(location.getName());
				weatherRepository.saveWeatherResult(weather);
			}
			weathers.add(weather);
			
		}
		return weathers;
	}

}
