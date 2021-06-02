package io.github.auspiciouschan1.utils;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.common.collect.Iterators;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;


public class IterableUtil {
    private static final String TAG = "IterableUtil";

    @NonNull
    public static <T> ArrayList<T> createSingleArrayList(@Nullable T t) {
        ArrayList<T> iterable = new ArrayList<>(1);
        iterable.add(t);
        return iterable;
    }

    @NonNull
    public static <T> LinkedList<T> createSingleLinkedList(@Nullable T t) {
        LinkedList<T> iterable = new LinkedList<>();
        iterable.add(t);
        return iterable;
    }

    @NonNull
    public static ArrayList<Integer> createRandomIntegerArrayList(final int sizeBound, final int upLimit, final int downLimit) {
        if (sizeBound <= 0 || upLimit <= downLimit) {
            return new ArrayList<>(0);
        }
        Random random = new Random();
        int size = random.nextInt(sizeBound);
        final int valueBound = (int) Math.min(Integer.MAX_VALUE, (long) upLimit - downLimit);
        ArrayList<Integer> arrayList = new ArrayList<>(size);
        for (int i = 0; i < size; ++i) {
            arrayList.add(random.nextInt(valueBound) + downLimit);
        }
        return arrayList;
    }

    @NonNull
    public static ArrayList<Double> createRandomDoubleArrayList(final int sizeBound, final double upLimit, final double downLimit) {
        if (sizeBound <= 0 || upLimit <= downLimit) {
            return new ArrayList<>(0);
        }
        Random random = new Random();
        int siz = random.nextInt(sizeBound);
        double valueBound = upLimit - downLimit;
        ArrayList<Double> arrayList = new ArrayList<>(siz);
        for (int i = 0; i < siz; ++i) {
            arrayList.add(random.nextDouble() * valueBound + downLimit);
        }
        return arrayList;
    }

    @Nullable
    public static <T> T get(@Nullable final Iterable<T> iterable, final int position) {
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

    public static <T> boolean equals(Iterable<T> iterable1, Iterable<T> iterable2) {
        if (iterable1 == null || iterable2 == null) {
            return iterable1 == iterable2;
        }
        Iterator<T> iterator1 = iterable1.iterator();
        Iterator<T> iterator2 = iterable2.iterator();
        T t1, t2;
        while (iterator1.hasNext()) {
            // 大小不同
            if (!iterator2.hasNext()) {
                return false;
            }
            t1 = iterator1.next();
            t2 = iterator2.next();
            if (!ObjectUtil.equals(t1, t2)) {
                return false;
            }
        }
        // 比较大小
        return !iterator2.hasNext();
    }
}
