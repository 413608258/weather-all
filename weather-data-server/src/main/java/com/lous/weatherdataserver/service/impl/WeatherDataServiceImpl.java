package com.lous.weatherdataserver.service.impl;

import com.alibaba.fastjson.JSON;
import com.lous.weatherdataserver.service.WeatherDataService;
import com.lous.weatherdataserver.vo.WeatherResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;


/**
 * @ClassName : WeatherDataServiceImpl
 * @Description :
 *
 * @author : Loushuai
 * @since : 2019-01-04
 **/
@Service
@Slf4j
public class WeatherDataServiceImpl implements WeatherDataService {

    @Autowired
    private RestTemplate restTemplate;
    /*
    * http://wthrcdn.etouch.cn/weather_mini?city=杭州
    * http://wthrcdn.etouch.cn/weather_mini?citykey=101280601
    * */
    @Override
    //@Cacheable(cacheNames = "weather", key="123456")
    @Cacheable(cacheNames = "weather", key = "T(com.lous.weatherdataserver.util.DateUtil).getNowDay() + ':' + #cityId")
    public WeatherResponse getDataByCityId(String cityId) {
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

    @Override
    public WeatherResponse getDataByCityName(String cityName) {
        /*String uri = "http://wthrcdn.etouch.cn/weather_mini?city=" + cityName;
        ResponseEntity<String> weatherResponseResponseEntity = restTemplate.getForEntity(uri, String.class);
        System.out.println("weatherResponseResponseEntity = " + weatherResponseResponseEntity.getBody());
        //WeatherResponse weatherResponse = weatherResponseResponseEntity.getBody();
        WeatherResponse weatherResponse = JSON.parseObject(weatherResponseResponseEntity.getBody(), WeatherResponse.class);
        return weatherResponse;*/
        return null;
    }

}
