package dstywho.collection;

import java.util.List;

public class Lists {

    public static <E> E last(List<E> c) {
        int length = c.size();
        return c.get(length - 1);
    }
    public static <E> E first(List<E> c) {
        return c.get(0);
    }
}
