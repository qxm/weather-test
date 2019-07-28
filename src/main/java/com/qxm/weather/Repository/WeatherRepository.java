package com.qxm.weather.Repository;

import com.qxm.weather.model.Location;
import com.qxm.weather.model.WeatherResult;

public interface WeatherRepository {
    public void saveWeatherResult(WeatherResult weather);
    
    public WeatherResult findWeatherByLocation(Location location) ;

    public void deleteOldRecords();
}
