package com.lous.weathercollectionserver.vo;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @ClassName : City
 * @Description : TODO
 *
 * @author : Loushuai
 * @since : 2019-01-07
 **/
@Data
public class City {

    private String cityId;

    private String cityName;

    private String cityCode;

    private String province;

}
