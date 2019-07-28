package com.qxm.weather.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.qxm.weather.Constant;
import com.qxm.weather.model.Location;
import com.qxm.weather.model.WeatherResult;
import com.qxm.weather.utils.TimeUtil;

@Repository("weatherRepository")
public class WeatherRepositoryImpl implements WeatherRepository {
    @Autowired
    private MongoTemplate mongoTemplate;
    
	@Override
	public void saveWeatherResult(WeatherResult weather) {
		
		weather.setRetrieveTime(TimeUtil.getRetrieveTime()); 
        mongoTemplate.save(weather);
	}

	/**
	 *  
	 */
	public WeatherResult findWeatherByLocation(Location location) {
		//Criteria criteria = Criteria.where("longitude").is(location.getLongitude()).and("latitude").is(location.getLatitude());
		Criteria criteria = Criteria.where("locationName").is(location.getName()).and("retrieveTime").is(TimeUtil.getRetrieveTime());

		Query query=new Query(criteria);
        WeatherResult result =  mongoTemplate.findOne(query , WeatherResult.class);
        return result;
    }

	/**
	 * 
	 */
	@Override
	public void deleteOldRecords() {
		long time = TimeUtil.getRetrieveTime() - Constant.OLD_TIME; //delete 3 days old records
        Query query=new Query(Criteria.where("retrieveTime").lt(time));
        mongoTemplate.remove(query,WeatherResult.class);
		
	}
}
