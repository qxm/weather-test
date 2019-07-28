package com.qxm.weather.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import com.qxm.weather.Service.WeatherService;
import com.qxm.weather.model.WeatherResult;
import com.qxm.weather.task.HouseKeepTask;

@Controller
public class WeatherController {
	private static final Logger log = LoggerFactory.getLogger(WeatherController.class);

	@Autowired
	private WeatherService weatherService;
	
    
    @GetMapping("/weather")
	public String weather(Model model) {
		return "weather";
	}
    
	
	
	@ModelAttribute("allWeathers")
	public List<WeatherResult> populateWeathers() {
		List<WeatherResult> weathers = weatherService.findAll();
		log.info("Retrieve the weather data");
		return weathers;
	}
	
}
