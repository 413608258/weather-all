package com.lous.weathercollectionserver.controller;

import com.lous.weathercollectionserver.service.WeatherDataCollectionService;
import com.lous.weathercollectionserver.vo.WeatherResponse;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName : WeatherDataController
 * @Description :
 *
 * @author : Loushuai
 * @since : 2019-01-09
 **/

@RestController
@RequestMapping("/weather")
public class WeatherDataController {

    @Autowired
    WeatherDataCollectionService weatherDataCollectionService;

    @GetMapping("/cityId/{cityId}")
    @HystrixCommand(fallbackMethod = "defaultHystrixMether")
    WeatherResponse getWeatherDataByCityId(@PathVariable("cityId") String cityId){
        WeatherResponse weatherResponse = weatherDataCollectionService.getWeatherDataByCityId(cityId);
        return weatherResponse;
    };

    public String defaultHystrixMether(){
        return "City Data Server is Down!!!";
    }
}
