package com.lous.weathereureka2server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class WeatherEureka2ServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(WeatherEureka2ServerApplication.class, args);
    }

}

