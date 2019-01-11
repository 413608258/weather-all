package com.lous.weatherdataserver.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName : Forecast
 * @Description : TODO
 *
 * @author : Loushuai
 * @since : 2019-01-04
 **/
@Data
public class Forecast implements Serializable {
    private static final long serialVersionUID = 4198728317124003123L;

    private String date;
    private String high;
    private String fengli;
    private String low;
    private String fengxiang;
    private String type;
}
