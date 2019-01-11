package com.lous.weatherdataserver.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName : WeatherResponse
 * @Description : TODO
 *
 * @author : Loushuai
 * @since : 2019-01-04
 **/
@Data
public class WeatherResponse implements Serializable {
    private static final long serialVersionUID = -3164691153655190112L;

    private Weather data;
    private Integer status;
    private String desc;
}
