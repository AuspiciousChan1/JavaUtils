package io.github.auspiciouschan1.utils.iterableutil;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Random;

import io.github.auspiciouschan1.utils.IterableUtil;

public class Get {
    @Test
    public void getInvalid() {
        Assert.assertNull(IterableUtil.get(null, -1));
        Assert.assertNull(IterableUtil.get(null, 0));
        Assert.assertNull(IterableUtil.get(null, 1));

        ArrayList<Integer> list = new ArrayList<>();
        Assert.assertNull(IterableUtil.get(list, -1));
        Assert.assertNull(IterableUtil.get(list, 0));
        Assert.assertNull(IterableUtil.get(list, 1));

        Integer value = new Random().nextInt();
        list.add(value);
        Assert.assertNull(IterableUtil.get(list, -1));
        Assert.assertEquals(value, IterableUtil.get(list, 0));
        Assert.assertNull(IterableUtil.get(list, 1));
    }

    @Test
    public void getRandom() {
        ArrayList<Integer> list;
        for (int i = 0; i < 100; ++i) {
            list = IterableUtil.createRandomIntegerArrayList(10, Integer.MAX_VALUE, Integer.MIN_VALUE);
            for (int j = 0; j < list.size(); ++j) {
                Assert.assertEquals(list.get(j), IterableUtil.get(list, j));
            }
        }
    }
}
