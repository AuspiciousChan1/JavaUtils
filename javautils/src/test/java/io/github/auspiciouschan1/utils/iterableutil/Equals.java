package io.github.auspiciouschan1.utils.iterableutil;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;

import io.github.auspiciouschan1.utils.IterableUtil;

public class Equals {

    @Test
    public void empty() {
        ArrayList<String> arrayList = null;
        LinkedList<String> linkedList = null;
        Assert.assertTrue(IterableUtil.equals(arrayList, linkedList));

        arrayList = new ArrayList<>();
        linkedList = new LinkedList<>();
        Assert.assertTrue(IterableUtil.equals(arrayList, linkedList));

        Assert.assertFalse(IterableUtil.equals(null, linkedList));
        Assert.assertFalse(IterableUtil.equals(arrayList, null));

        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("123");
        Assert.assertFalse(IterableUtil.equals(hashSet, linkedList));
        Assert.assertFalse(IterableUtil.equals(arrayList, hashSet));
        Assert.assertFalse(IterableUtil.equals(null, hashSet));
        Assert.assertFalse(IterableUtil.equals(hashSet, null));
    }

    @Test
    public void common() {
        ArrayList<Integer> randomArrayList;
        ArrayList<Integer> arrayList;
        LinkedList<Integer> linkedList;
        for (int i = 0; i < 10; ++i) {
            randomArrayList = IterableUtil.createRandomIntegerArrayList(100, Integer.MAX_VALUE, Integer.MIN_VALUE);
            arrayList = new ArrayList<>(randomArrayList);
            linkedList = new LinkedList<>(randomArrayList);
            Assert.assertTrue(IterableUtil.equals(arrayList, linkedList));
            Assert.assertTrue(IterableUtil.equals(linkedList, arrayList));
            arrayList.add(1);
            Assert.assertFalse(IterableUtil.equals(arrayList, linkedList));
            Assert.assertFalse(IterableUtil.equals(linkedList, arrayList));
            linkedList.add(1);
            Assert.assertTrue(IterableUtil.equals(arrayList, linkedList));
            Assert.assertTrue(IterableUtil.equals(linkedList, arrayList));
            linkedList.add(2);
            Assert.assertFalse(IterableUtil.equals(arrayList, linkedList));
            Assert.assertFalse(IterableUtil.equals(linkedList, arrayList));
        }
    }
}
