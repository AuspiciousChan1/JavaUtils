package io.github.auspiciouschan1.utils.iterableutil;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import io.github.auspiciouschan1.utils.IterableUtil;

public class CreateRandomIntegerArrayList {
    @Test
    public void createEmptyList() {
        Assert.assertEquals(0, IterableUtil.createRandomIntegerArrayList(0, 0, 0).size());
        Assert.assertEquals(0, IterableUtil.createRandomIntegerArrayList(-1, 0, 0).size());
        Assert.assertEquals(0, IterableUtil.createRandomIntegerArrayList(1, 0, 0).size());
        Assert.assertEquals(0, IterableUtil.createRandomIntegerArrayList(1, 1, 1).size());
        Assert.assertEquals(0, IterableUtil.createRandomIntegerArrayList(1, 2, 3).size());
        Assert.assertEquals(0, IterableUtil.createRandomIntegerArrayList(1, -3, -2).size());
    }

    @Test
    public void createList() {
        boolean hasEmptyList = false;
        boolean hasFullSizeList = false;
        boolean fetchDownLimit = false;
        boolean closeToUpLimit = false;
        int sizeBound = 10;
        int upLimit = 5;
        int downLimit = -5;
        ArrayList<Integer> list;
        for (int i = 0; i < 100; ++i) {
            list = IterableUtil.createRandomIntegerArrayList(sizeBound, upLimit, downLimit);
            System.out.println(list);
            Assert.assertNotNull(list);
            if (list.isEmpty()) {
                hasEmptyList = true;
            }
            if (list.size() == sizeBound) {
                hasFullSizeList = true;
            }
            Assert.assertTrue(list.size() <= sizeBound);
            for (Integer integer : list) {
                Assert.assertNotNull(integer);
                Assert.assertTrue(integer < upLimit);
                Assert.assertTrue(integer >= downLimit);
                if (integer == upLimit - 1) {
                    closeToUpLimit = true;
                }
                if (integer == downLimit) {
                    fetchDownLimit = true;
                }
            }
        }
        Assert.assertTrue(hasEmptyList);
        Assert.assertTrue(hasFullSizeList);
        Assert.assertTrue(fetchDownLimit);
        Assert.assertTrue(closeToUpLimit);
    }

    @Test
    public void createBig() {
        int sizeBound = 10000;
        int upLimit = Integer.MAX_VALUE;
        int downLimit = Integer.MIN_VALUE;
        ArrayList<Integer> list = IterableUtil.createRandomIntegerArrayList(sizeBound, upLimit, downLimit);
        for (int i = 0; i < 100; ++i) {
            System.out.println(list);
            Assert.assertNotNull(list);
        }
    }
}
