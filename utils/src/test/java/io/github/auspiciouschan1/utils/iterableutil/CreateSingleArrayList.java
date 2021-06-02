package io.github.auspiciouschan1.utils.iterableutil;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.UUID;

import io.github.auspiciouschan1.utils.IterableUtil;

public class CreateSingleArrayList {
    @Test
    public void create() {
        final String element = UUID.randomUUID().toString();
        ArrayList<String> list = IterableUtil.createSingleArrayList(element);
        Assert.assertEquals(1, list.size());
        Assert.assertEquals(element, list.get(0));

        list = IterableUtil.createSingleArrayList(null);
        Assert.assertEquals(1, list.size());
        Assert.assertNull(list.get(0));
    }
}
