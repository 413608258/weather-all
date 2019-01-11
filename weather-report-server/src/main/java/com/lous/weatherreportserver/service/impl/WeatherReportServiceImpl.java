package com.lous.weatherreportserver.service.impl;

import com.lous.weatherreportserver.service.WeatherCityClient;
import com.lous.weatherreportserver.service.WeatherCollectionClient;
import com.lous.weatherreportserver.service.WeatherReportService;
import com.lous.weatherreportserver.service.WeatherZuulClient;
import com.lous.weatherreportserver.vo.Forecast;
import com.lous.weatherreportserver.vo.Weather;
import com.lous.weatherreportserver.vo.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName : WeatherReportServiceImpl
 * @Description :
 *
 * @author : Loushuai
 * @since : 2019-01-07
 **/
@Service
public class WeatherReportServiceImpl implements WeatherReportService {

   /* @Autowired
    private WeatherDataService weatherDataService;*/
   @Autowired
   private WeatherCollectionClient weatherCollectionClient;
   @Autowired
   private WeatherZuulClient weatherZuulClient;

    @Override
    public Weather getDataByCityId(String cityId) {
        //WeatherResponse weatherResponse = weatherDataService.syncDataByCityId(cityId);
        //return weatherResponse.getData();
        //直接请求 服务端
        //WeatherResponse weatherResponse = weatherCollectionClient.getWeatherDataByCityId(cityId);
        //通过 Zuul 访问
        WeatherResponse weatherResponse = weatherZuulClient.getWeatherDataByCityId(cityId);

        return weatherResponse.getData();
    }
}
