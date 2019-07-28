package com.qxm.weather.Service;

import java.util.List;

import com.qxm.weather.model.WeatherResult;

public interface WeatherService {
    public List<WeatherResult> findAll();
}
