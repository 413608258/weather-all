package com.lous.weatherdataserver.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName : RestConfiguration
 * @Description :
 *
 * @author : Loushuai
 * @since : 2019-01-04
 **/

@Configuration
public class RestConfiguration {
    @Autowired
    private RestTemplateBuilder builder;

    @Bean
    public RestTemplate restTemplate() {
        return builder.build();
    }
}
