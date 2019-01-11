package com.lous.weathercollectionserver.service;

import com.lous.weathercollectionserver.vo.City;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @ClassName : WeatherCityClient
 * @Description :
 *
 * @author : Loushuai
 * @since : 2019-01-09
 **/
@FeignClient(name = "weather-city-server", path = "/city", fallback = WeatherCityClient.WeatherCityClientHystrix.class)
public interface WeatherCityClient {

    @GetMapping("/cities")
    //@HystrixCommand(fallbackMethod = "defaultCities")
    List<City> listCity();

    @Component
    class WeatherCityClientHystrix implements WeatherCityClient{

        @Override
        public List<City> listCity() {
            throw new RuntimeException();
        }
    }

}
