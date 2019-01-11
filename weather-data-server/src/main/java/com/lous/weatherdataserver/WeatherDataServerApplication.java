package com.lous.weatherdataserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @ClassName : WeatherDataServerApplication
 * @Description : TODO
 *
 * @author : Loushuai
 * @since : 2019-01-08
 **/
@SpringBootApplication
@EnableDiscoveryClient
@EnableCaching
public class WeatherDataServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(WeatherDataServerApplication.class);
    }

}
