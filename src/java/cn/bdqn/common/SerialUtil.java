package com.store.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by ASUS on 2018/1/15.
 */
public class SerialUtil
{
    public static int index=1;
    public synchronized static String generateSerail()
    {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddhhmmssSSS");
        String dateStr=sdf.format(new Date());
        index=index+1;
        dateStr=dateStr+index;
        return  dateStr;
    }
}
