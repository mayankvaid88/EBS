package org.ebs.utils;

import java.util.Calendar;
import java.util.Date;

public class JwtUtils {

    public static final Date getJwtTokenExpiry(){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.HOUR,1);
        return calendar.getTime();
    }

    public static final String getJwtSecretKey(){
        return "XHUB12331";
    }
}
