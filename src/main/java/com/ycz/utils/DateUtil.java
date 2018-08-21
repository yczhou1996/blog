package com.ycz.utils;

import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class DateUtil {

    public static String dateFormat(Date date, String dateFormat){
        if(null != date){
            SimpleDateFormat format = new SimpleDateFormat(dateFormat);
            return format.format(date);
        }
        return "";
    }
}
