package com.qxm.weather.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.qxm.weather.Repository.WeatherRepository;

@Component
public class HouseKeepTask {
	private static final Logger log = LoggerFactory.getLogger(HouseKeepTask.class);
	@Autowired
	WeatherRepository weatherRepository;

	// delete task run at 1:50am
	@Scheduled(cron = "0 50 1 * * ?")
	public void deleteOldRecords() {
		weatherRepository.deleteOldRecords();
		// log.info("The time is now {}", dateFormat.format(new Date()));
	}
}
