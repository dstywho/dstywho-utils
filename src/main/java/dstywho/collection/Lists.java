package dstywho.collection;

import java.util.ArrayList;
import java.util.List;

import dstywho.functional.Closure;
import dstywho.functional.Closure2;
import dstywho.functional.Closure3;

public class Lists {

    public static <E> E last(List<E> c)
        {
            int length = c.size();
            return c.get(length - 1);
        }

    public static <E> E first(List<E> c)
        {
            return c.get(0);
        }

    public static <E, V> void eachWithIndex(List<E> list, Closure3<E, E, Integer> c)
        {
            for (int i = 0; i < list.size(); i++)
                {
                    c.call(list.get(i), i);
                }
        }

    public static <E, T> List<T> map(List<E> list, Closure2<T, E> block)
        {
            List<T> result = new ArrayList<T>();
            for (E item : list)
                {
                    result.add(block.call(item));
                }
            return result;

        }
}
