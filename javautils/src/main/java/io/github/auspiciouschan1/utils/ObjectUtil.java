package io.github.auspiciouschan1.utils;

public class ObjectUtil {
    public static boolean equals(Object a, Object b) {
        return (a == b) || (a != null && a.equals(b));
    }
}
