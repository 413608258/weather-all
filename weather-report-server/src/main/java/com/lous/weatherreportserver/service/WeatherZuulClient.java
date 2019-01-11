package com.lous.weatherreportserver.service;

import com.lous.weatherreportserver.vo.City;
import com.lous.weatherreportserver.vo.WeatherResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @ClassName : WeatherZuulClient
 * @Description :
 *
 * @author : Loushuai
 * @since : 2019-01-10
 **/
@FeignClient("weather-zuul-server")
public interface WeatherZuulClient {

    @GetMapping("/city/cities")
    List<City> listCity();

    @GetMapping("/collection/weather/cityId/{cityId}")
    WeatherResponse getWeatherDataByCityId(@PathVariable("cityId") String cityId);
}
