package dstywho.collection;

import java.util.List;

public class Lists {

    public static <E> E last(List<E> c) {
        int length = c.size();
        return c.get(length - 1);
    }
}
