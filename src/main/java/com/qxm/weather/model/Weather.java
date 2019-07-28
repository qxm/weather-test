package com.qxm.weather.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "weathers")
public class Weather {
	 @Id
	 private String id;
	 private String name;
	 private double latitude;
	 private double longtitude;
	 private WeatherDetail[] details;
}
