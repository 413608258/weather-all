package com.lous.weathercollectionserver.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassName : Weather
 * @Description : 天气信息
 *
 * @author : Loushuai
 * @since : 2019-01-04
 **/
@Data
public class Weather implements Serializable {
    private static final long serialVersionUID = -7788482433198234609L;

    private String city;
    private String ganmao;
    private String wendu;
    private Yesterday yesterday;
    private List<Forecast> forecast;
}
