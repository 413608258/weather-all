package com.lous.weatherreportserver.service;

import com.lous.weatherreportserver.vo.Weather;

/**
 * @ClassName : WeatherReportServiceImpl
 * @Description : TODO
 *
 * @author : Loushuai
 * @since : 2019-01-07
 **/
 
public interface WeatherReportService {

    Weather getDataByCityId(String cityId);
}
