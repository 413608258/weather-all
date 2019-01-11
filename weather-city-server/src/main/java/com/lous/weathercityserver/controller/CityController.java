package com.lous.weathercityserver.controller;

import com.lous.weathercityserver.service.CityDataService;
import com.lous.weathercityserver.vo.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName : CityController
 * @Description :
 *
 * @author : Loushuai
 * @since : 2019-01-08
 **/
@RestController
@RequestMapping("/cities")
public class CityController {
    
    @Autowired
    CityDataService cityDataService;

    @GetMapping
    public List<City> listCity() throws Exception {
        List<City> cities = cityDataService.listCity();
        return cities;
    }

}
