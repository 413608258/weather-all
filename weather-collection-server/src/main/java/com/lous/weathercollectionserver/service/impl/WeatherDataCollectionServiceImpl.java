package com.lous.weathercollectionserver.service.impl;

import com.alibaba.fastjson.JSON;
import com.lous.weathercollectionserver.service.WeatherDataCollectionService;
import com.lous.weathercollectionserver.vo.WeatherResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName : WeatherDataCollectionServiceImpl
 * @Description :
 *
 * @author : Loushuai
 * @since : 2019-01-08
 **/
@Service
@Slf4j
public class WeatherDataCollectionServiceImpl implements WeatherDataCollectionService {

    @Autowired
    private RestTemplate restTemplate;

    @CachePut(cacheNames = "weather", key = "T(com.lous.weathercollectionserver.util.DateUtil).getNowDay() + ':' + #cityId", unless = "#result.getStatus() != 1000")
    @Override
    public WeatherResponse syncDataByCityId(String cityId) {
        WeatherResponse weatherResponse = this.getDataByCityId(cityId);
        return weatherResponse;
    }

    private WeatherResponse getDataByCityId(String cityId) {
        String uri = "http://wthrcdn.etouch.cn/weather_mini?citykey=" + cityId;
        ResponseEntity<String> weatherResponseResponseEntity = null;
        try {
            weatherResponseResponseEntity = restTemplate.getForEntity(uri, String.class);
        } catch (RestClientException e) {
            log.error("HttpClient Request CityID:{} Error : {}", cityId, e.getMessage());
            e.printStackTrace();
        }
        //System.out.println("weatherResponseResponseEntity = " + weatherResponseResponseEntity.getBody());
        //WeatherResponse weatherResponse = weatherResponseResponseEntity.getBody();
        WeatherResponse weatherResponse = JSON.parseObject(weatherResponseResponseEntity.getBody(), WeatherResponse.class);
        return weatherResponse;
    }

    @Cacheable(cacheNames = "weather", key = "T(com.lous.weathercollectionserver.util.DateUtil).getNowDay() + ':' + #cityId")
    @Override
    public WeatherResponse getWeatherDataByCityId(String cityId){
        throw new RuntimeException("Redis has no data. CityId: " + cityId);
    }
}
