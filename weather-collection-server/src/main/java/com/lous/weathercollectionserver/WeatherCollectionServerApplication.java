package com.lous.weathercollectionserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @ClassName : WeatherCollectionServerApplication
 *
 * @author : Loushuai
 * @since : 2019-01-08
 **/
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableCaching
@EnableCircuitBreaker
public class WeatherCollectionServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(WeatherCollectionServerApplication.class, args);
    }
}
