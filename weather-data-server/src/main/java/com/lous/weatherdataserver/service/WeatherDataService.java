package com.lous.weatherdataserver.service;

import com.lous.weatherdataserver.vo.WeatherResponse;

/**
 * @ClassName : WeatherDataService
 * @Description :
 *
 * @author : Loushuai
 * @since : 2019-01-04
 **/
 
public interface WeatherDataService {

    WeatherResponse getDataByCityId(String cityId);

    WeatherResponse getDataByCityName(String cityName);

}
