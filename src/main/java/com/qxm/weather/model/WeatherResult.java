package com.qxm.weather.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "weathers")
public class WeatherResult {
	@Id
	String id;
	long retrieveTime;
	String locationName;
	double latitude	;//37.8267
	double longitude;//	-122.4233
	String timezone;//	"America/Los_Angeles"
	WeatherDetail currently;
	public WeatherDetail getCurrently() {
		return currently;
	}
	public void setCurrently(WeatherDetail currently) {
		this.currently = currently;
	}
	public String getLocationName() {
		return locationName;
	}
	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}
	public long getRetrieveTime() {
		return retrieveTime;
	}
	public void setRetrieveTime(long retrieveTime) {
		this.retrieveTime = retrieveTime;
	}
	
	
}
