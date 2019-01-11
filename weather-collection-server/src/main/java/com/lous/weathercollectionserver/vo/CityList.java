package com.lous.weathercollectionserver.vo;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * @ClassName : CityList
 * @Description : TODO
 *
 * @author : Loushuai
 * @since : 2019-01-07
 **/
@Data
public class CityList {

    private List<City> cityList;

}
