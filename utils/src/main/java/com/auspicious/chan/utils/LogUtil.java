package com.auspicious.chan.utils;

import android.os.Looper;
import android.util.Log;

/**
 * 日志通用方法
 */
public class LogUtil {
    private static final String TAG = "LogUtil";

    public static void v(String tag, String msg) {
        v(tag, msg, null);
    }

    public static void v(String tag, String msg, Throwable e) {
        println(Log.VERBOSE, tag, msg, e);
    }

    public static void d(String tag, String msg) {
        d(tag, msg, null);
    }

    public static void d(String tag, String msg, Throwable e) {
        println(Log.DEBUG, tag, msg, e);
    }

    public static void i(String tag, String msg) {
        i(tag, msg, null);
    }

    public static void i(String tag, String msg, Throwable e) {
        println(Log.INFO, tag, msg, e);
    }

    public static void w(String tag, String msg) {
        w(tag, msg, null);
    }

    public static void w(String tag, String msg, Throwable e) {
        println(Log.WARN, tag, msg, e);
    }

    public static void e(String tag, String msg) {
        e(tag, msg, null);
    }

    public static void e(String tag, String msg, Throwable e) {
        println(Log.ERROR, tag, msg, e);
    }

    public static void wtf(String tag, String msg) {
        wtf(tag, msg, null);
    }

    public static void wtf(String tag, String msg, Throwable e) {
        println(Log.ASSERT, tag, msg, e);
    }

    public static void println(int priority, String tag, String msg, Throwable e) {
        long threadId = Thread.currentThread().getId();
        long mainThreadId = Looper.getMainLooper().getThread().getId();
        msg = msg == null ? "" : msg;
        if (e != null) {
            msg += "\n" + e;
        }
        msg = String.format("%s(%s) %s", threadId, mainThreadId, msg);
        Log.println(priority, tag, msg);
    }
}
