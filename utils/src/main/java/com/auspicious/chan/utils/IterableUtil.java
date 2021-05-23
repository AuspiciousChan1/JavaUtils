package com.auspicious.chan.utils;

import androidx.annotation.Nullable;

import com.google.common.collect.Iterators;


public class IterableUtil {
    private static final String TAG = "IterableUtil";

    @Nullable
    public static <T> T get(final Iterable<T> iterable, final int position) {
        if (iterable == null || position < 0) {
            LogUtil.i(TAG, String.format("get failed, iterable=%s, position=%s", iterable, position));
            return null;
        }
        T t = null;
        try {
            t = Iterators.get(iterable.iterator(), position);
        } catch (Throwable e) {
            LogUtil.i(TAG, "get error", e);
        }
        return t;
    }
}
