package com.qxm.weather;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;



@SpringBootApplication
@EnableScheduling
public class WeatherApp {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(WeatherApp.class, args);
    }
}
