package com.lous.weatherreportserver.service;

import com.lous.weatherreportserver.vo.WeatherResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @ClassName : WeatherCollectionClient
 * @Description :
 *
 * @author : Loushuai
 * @since : 2019-01-09
 **/

@FeignClient(name = "weather-collection-server", path = "/collection")
//@FeignClient(name = "weather-zuul-server", path = "/collection")
public interface WeatherCollectionClient {

    @GetMapping("/weather/cityId/{cityId}")
    WeatherResponse getWeatherDataByCityId(@PathVariable("cityId") String cityId);
}
