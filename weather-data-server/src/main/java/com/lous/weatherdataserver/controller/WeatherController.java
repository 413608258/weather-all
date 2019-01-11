package com.lous.weatherdataserver.controller;

import com.lous.weatherdataserver.service.WeatherDataService;
import com.lous.weatherdataserver.vo.WeatherResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName : WeatherController
 * @Description :
 *
 * @author : Loushuai
 * @since : 2019-01-04
 **/
@RestController
@RequestMapping("/weather")
@Slf4j
public class WeatherController {

    @Autowired
    WeatherDataService weatherDataService;
    @Autowired
    StringRedisTemplate redisTemplate;

    @GetMapping("/cityId/{cityId}")
    public WeatherResponse getWeatherByCityId(@PathVariable("cityId") String cityId){
        return weatherDataService.getDataByCityId(cityId);
    }

    @GetMapping("/cityName/{cityName}")
    public WeatherResponse getWeatherByCityName(@PathVariable("cityName") String cityName){
        return weatherDataService.getDataByCityName(cityName);
    }

}
