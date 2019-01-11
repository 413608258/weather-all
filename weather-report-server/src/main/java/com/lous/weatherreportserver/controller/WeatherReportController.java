package com.lous.weatherreportserver.controller;

import com.lous.weatherreportserver.service.WeatherCityClient;
import com.lous.weatherreportserver.service.WeatherReportService;
import com.lous.weatherreportserver.service.WeatherZuulClient;
import com.lous.weatherreportserver.vo.City;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @ClassName : WeatherReportController
 * @Description :
 *
 * @author : Loushuai
 * @since : 2019-01-04
 **/
@Controller
@RequestMapping("/report")
//@CacheConfig(cacheNames = "weather")
@Slf4j
public class WeatherReportController {

    /*@Autowired
    private CityDataService cityDataService;*/
    @Autowired
    private WeatherReportService weatherReportService;
    @Autowired
    private WeatherCityClient weatherCityClient;
    @Autowired
    private WeatherZuulClient weatherZuulClient;

    @GetMapping("/cityId/{cityId}")
    public ModelAndView getWeatherByCityId(@PathVariable("cityId") String cityId, Map<String, Object> map) throws Exception {
        //TODO:改为由城市数据API微服务来提供数据
        List<City> cityList = new ArrayList<>();
        try {
            //直接请求 服务客户端
            //cityList = weatherCityClient.listCity();
            //通过 Zuul 来访问服务
            cityList = weatherZuulClient.listCity();
        } catch (Exception e) {
            log.error("[获取cityList Exception]: {}", e.getMessage());
        }

        map.put("title", "Lous的天气预报");
        map.put("cityId", cityId);
        //map.put("cityList", cityDataService.listCity());
        map.put("cityList", cityList);
        map.put("report", weatherReportService.getDataByCityId(cityId));
        return new ModelAndView("weather/report", map);
    }

}
