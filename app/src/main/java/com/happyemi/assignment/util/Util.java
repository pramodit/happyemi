package com.happyemi.assignment.util;

import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Util {

    public static String getDayString(String dateString){
        String dayName="";
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.US); //Date and time
            Date date = sdf.parse(dateString);
            SimpleDateFormat sdf_ = new SimpleDateFormat("EEEE", Locale.US);
            dayName = sdf_.format(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Log.e("Weather", "getDayString: DAY_STRING  "+dayName);
        return dayName;

    }
}
