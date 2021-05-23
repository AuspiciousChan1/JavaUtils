package com.auspicious.chan.utils;

import android.util.Log;

import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertTrue;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class LogUtilTest {
    private final Throwable throwable = new IllegalArgumentException("iae");
    @Test
    public void i() {
        // Context of the app under test.
        LogUtil.i(null, null);
        LogUtil.i("", "");
        LogUtil.i("tag", "");
        LogUtil.i("", "msg");
        LogUtil.i("tag", "msg");

        LogUtil.i(null, null, null);
        LogUtil.i("", "", null);
        LogUtil.i("tag", "", null);
        LogUtil.i("", "msg", null);
        LogUtil.i("tag", "msg", null);
        LogUtil.i(null, null, throwable);
        LogUtil.i("", "", throwable);
        LogUtil.i("tag", "", throwable);
        LogUtil.i("", "msg", throwable);
        LogUtil.i("tag", "msg", throwable);
        assertTrue(true);
    }
    @Test
    public void println() {
        // Context of the app under test.
        LogUtil.println(Log.WARN, "TAG", "MSG", new NullPointerException("NPE"));
        assertTrue(true);
    }
}