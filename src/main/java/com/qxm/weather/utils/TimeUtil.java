package com.qxm.weather.utils;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;

import com.qxm.weather.Constant;

public class TimeUtil {
    public static long getRetrieveTime() {
    	LocalDateTime time = LocalDateTime.now();
		int year = time.getYear();
		Month month = time.getMonth();
		int dayOfMonth = time.getDayOfMonth();
		int hour = time.getHour();
		int minute = time.getMinute();
		int newMinute = minute - minute % Constant.RETRIEVE_MINUTE;
		LocalDateTime retrieveTime  = LocalDateTime.of(year, month, dayOfMonth, hour, newMinute);
		return retrieveTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }
}
