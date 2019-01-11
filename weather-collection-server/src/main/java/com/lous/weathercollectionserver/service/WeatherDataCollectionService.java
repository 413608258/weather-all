package com.lous.weathercollectionserver.service;

import com.lous.weathercollectionserver.vo.WeatherResponse;

/**
 * @ClassName : WeatherDataCollectionService
 * @Description :
 *
 * @author : Loushuai
 * @since : 2019-01-08
 **/
 
public interface WeatherDataCollectionService {

    /**
     * 根据城市ID同步天气
     * @param cityId
     */
    WeatherResponse syncDataByCityId(String cityId);

    WeatherResponse getWeatherDataByCityId(String cityId);
}
