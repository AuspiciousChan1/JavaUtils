package io.github.auspiciouschan1.utils.iterableutil;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.UUID;

import io.github.auspiciouschan1.utils.IterableUtil;

public class CreateSingleLinkedList {
    @Test
    public void create() {
        final String element = UUID.randomUUID().toString();
        LinkedList<String> list = IterableUtil.createSingleLinkedList(element);
        Assert.assertEquals(1, list.size());
        Assert.assertEquals(element, list.get(0));

        list = IterableUtil.createSingleLinkedList(null);
        Assert.assertEquals(1, list.size());
        Assert.assertNull(list.get(0));
    }
}
