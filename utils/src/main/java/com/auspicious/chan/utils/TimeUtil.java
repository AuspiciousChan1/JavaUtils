package com.auspicious.chan.utils;

import android.os.SystemClock;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class TimeUtil {
    public static long currentTimeMillis() {
        return System.currentTimeMillis();
    }

    public static long nanoTime() {
        return System.nanoTime();
    }

    public static long currentThreadTimeMillis() {
        return SystemClock.currentThreadTimeMillis();
    }

    public static long elapsedRealtime() {
        return SystemClock.elapsedRealtime();
    }

    public static long elapsedRealtimeNanos() {
        return SystemClock.elapsedRealtimeNanos();
    }

    public static long uptimeMillis() {
        return SystemClock.uptimeMillis();
    }

    public static String currentTimeStr() {
        return currentTimeStr(Locale.getDefault());
    }

    public static String currentTimeStr(Locale locale) {
        if (locale == null) {
            locale = Locale.getDefault();
        }
        SimpleDateFormat format = new SimpleDateFormat("yyy-MM-dd hh:mm:ss.SSS", locale);
        Date date = new Date(currentTimeMillis());
        return format.format(date);
    }
}
