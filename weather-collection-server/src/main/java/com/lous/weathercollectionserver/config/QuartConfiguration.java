package com.lous.weathercollectionserver.config;

import com.lous.weathercollectionserver.job.WeatherDataSyncJob;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName : QuartConfiguration
 * @Description :
 *
 * @author : Loushuai
 * @since : 2019-01-07
 **/
@Configuration
public class QuartConfiguration {

    private static final int TIME = 60*30; //1800s

    @Bean
    public JobDetail weatherDataSyncJobDetail(){
        return JobBuilder.newJob(WeatherDataSyncJob.class).withIdentity("weatherDataSyncJob")
                .storeDurably().build();
    }
    @Bean
    public Trigger weatherDataSyncTrigger() {
        ScheduleBuilder schedBuilder = SimpleScheduleBuilder
                .simpleSchedule()
                .withIntervalInSeconds(TIME)
                .repeatForever();
        return TriggerBuilder.newTrigger()
                .forJob(weatherDataSyncJobDetail())
                .withIdentity("weatherDataSyncTrigger")
                .withSchedule(schedBuilder)
                .build();
    }
}
