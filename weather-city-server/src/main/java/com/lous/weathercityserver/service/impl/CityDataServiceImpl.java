package com.lous.weathercityserver.service.impl;

import com.lous.weathercityserver.service.CityDataService;
import com.lous.weathercityserver.util.XmlBuilder;
import com.lous.weathercityserver.vo.City;
import com.lous.weathercityserver.vo.CityList;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

/**
 * @ClassName : CityDataServiceImpl
 * @Description :
 *
 * @author : Loushuai
 * @since : 2019-01-07
 **/
@Service
public class CityDataServiceImpl implements CityDataService {
    @Override
    public List<City> listCity() throws Exception {
        // 读取XML文件
//        Resource resource = new ClassPathResource("static/citylist.xml");
        Resource resource = new ClassPathResource("citylist.xml");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(resource.getInputStream(), "utf-8"));
        StringBuffer stringBuffer = new StringBuffer();
        String line = "";

        while ((line = bufferedReader.readLine()) != null) {
            stringBuffer.append(line);
        }

        bufferedReader.close();

        CityList cityList = (CityList) XmlBuilder.xmlStrToObject(CityList.class, stringBuffer.toString());
        return cityList.getCityList();
    }
}
