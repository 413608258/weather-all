package com.lous.weathercollectionserver.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName : DateUtil
 * @Description :
 *
 * @author : Loushuai
 * @since : 2019-01-05
 **/
 
public class DateUtil {

    public static String pattern = "yyyyMMdd";
    private static SimpleDateFormat format = new SimpleDateFormat(pattern);

    public static String getNowDay(){
        String format = DateUtil.format.format(new Date());
        return format;
    }
}
