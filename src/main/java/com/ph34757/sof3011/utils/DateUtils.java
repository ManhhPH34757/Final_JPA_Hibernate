package com.ph34757.sof3011.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
public class DateUtils {
    static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    public static Date getDateFormat() throws ParseException {
        return format.parse(format.format(new Date()));
    }

}
