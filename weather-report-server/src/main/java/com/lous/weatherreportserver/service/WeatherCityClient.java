package com.lous.weatherreportserver.service;

import com.lous.weatherreportserver.vo.City;
import com.lous.weatherreportserver.vo.WeatherResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @ClassName : WeatherCityClient
 * @Description :
 *
 * @author : Loushuai
 * @since : 2019-01-09
 **/
@FeignClient(name = "weather-city-server", path = "/city")
//@FeignClient(name = "weather-zuul-server", path = "/city")
public interface WeatherCityClient {

    @GetMapping("/cities")
    List<City> listCity();

}
