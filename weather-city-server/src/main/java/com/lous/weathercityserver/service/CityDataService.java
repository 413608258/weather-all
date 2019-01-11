package com.lous.weathercityserver.service;


import com.lous.weathercityserver.vo.City;

import java.util.List;

/**
 * @ClassName : CityDataService
 * @Description : TODO
 *
 * @author : Loushuai
 * @since : 2019-01-07
 **/
 
public interface CityDataService {

    List<City> listCity() throws Exception;
}
