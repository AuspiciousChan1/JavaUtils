package io.github.auspiciouschan1.utils.iterableutil;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import io.github.auspiciouschan1.utils.IterableUtil;

public class CreateRandomDoubleArrayList {
    @Test
    public void createEmptyList() {
        Assert.assertEquals(0, IterableUtil.createRandomDoubleArrayList(0, 0, 0).size());
        Assert.assertEquals(0, IterableUtil.createRandomDoubleArrayList(-1, 0, 0).size());
        Assert.assertEquals(0, IterableUtil.createRandomDoubleArrayList(1, 0, 0).size());
        Assert.assertEquals(0, IterableUtil.createRandomDoubleArrayList(1, 1, 1).size());
        Assert.assertEquals(0, IterableUtil.createRandomDoubleArrayList(1, 2, 3).size());
        Assert.assertEquals(0, IterableUtil.createRandomDoubleArrayList(1, -3, -2).size());
    }

    @Test
    public void createList() {
        boolean hasEmptyList = false;
        boolean hasFullSizeList = false;
        int sizeBound = 10;
        int upLimit = 5;
        int downLimit = -5;
        ArrayList<Double> list;
        for (int i = 0; i < 100; ++i) {
            list = IterableUtil.createRandomDoubleArrayList(sizeBound, upLimit, downLimit);
            System.out.println(list);
            Assert.assertNotNull(list);
            if (list.isEmpty()) {
                hasEmptyList = true;
            }
            if (list.size() == sizeBound) {
                hasFullSizeList = true;
            }
            Assert.assertTrue(list.size() <= sizeBound);
            for (Double value : list) {
                Assert.assertNotNull(value);
                Assert.assertTrue(value < upLimit);
                Assert.assertTrue(value >= downLimit);
            }
        }
        Assert.assertTrue(hasEmptyList);
        Assert.assertTrue(hasFullSizeList);
    }

    @Test
    public void createBig() {
        int sizeBound = 10000;
        int upLimit = Integer.MAX_VALUE;
        int downLimit = Integer.MIN_VALUE;
        ArrayList<Double> list = IterableUtil.createRandomDoubleArrayList(sizeBound, upLimit, downLimit);
        for (int i = 0; i < 100; ++i) {
            System.out.println(list);
            Assert.assertNotNull(list);
        }
    }
}
