package com.qxm.weather.Repository;

import java.util.List;

import com.qxm.weather.model.Location;

public interface LocationRepository {
    public List<Location> findAll();
}
