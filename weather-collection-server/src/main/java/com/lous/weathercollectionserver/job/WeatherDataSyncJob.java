package com.lous.weathercollectionserver.job;

import com.lous.weathercollectionserver.service.WeatherCityClient;
import com.lous.weathercollectionserver.service.WeatherDataCollectionService;
import com.lous.weathercollectionserver.vo.City;
import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName : WeatherDataSyncJob
 * @Description :
 *
 * @author : Loushuai
 * @since : 2019-01-07
 **/
@Slf4j
public class WeatherDataSyncJob extends QuartzJobBean {

    @Autowired
    private WeatherDataCollectionService weatherDataCollectionService;
    @Autowired
    private WeatherCityClient weatherCityClient;

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        List<City> cityList = new ArrayList<>();
        try {
            cityList = weatherCityClient.listCity();
            /*//TODO: 改为由城市服务API微服务来提供数据
            City city = new City();
            city.setCityId("101010100");
            cityList.add(city);*/
        } catch (Exception e) {
            log.error("[获取cityList Exception]: {}", e.getMessage());
        }
        cityList.stream()
                .map(City::getCityId)
                .peek(s -> System.out.println(s))
                .forEach(cityId -> {
                    weatherDataCollectionService.syncDataByCityId(cityId);
                });
        System.out.println("END...");
    }
}
