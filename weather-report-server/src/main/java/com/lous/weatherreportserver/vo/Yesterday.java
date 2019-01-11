package com.lous.weatherreportserver.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName : Yesterday
 * @Description : TODO
 *
 * @author : Loushuai
 * @since : 2019-01-04
 **/
@Data
public class Yesterday implements Serializable {
    private static final long serialVersionUID = -6537156541423681241L;

    private String date;
    private String high;
    private String fx;
    private String low;
    private String type;
}
