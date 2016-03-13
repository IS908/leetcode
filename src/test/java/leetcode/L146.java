package leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by kevin on 2016/3/13.
 */
public class L146 {
    @Test
    public void test() {
        L146_LRUCache l146_lruCache = new L146_LRUCache(2);
        l146_lruCache.set(2, 1);
        l146_lruCache.set(2, 2);
        int a = l146_lruCache.get(2);
        l146_lruCache.set(3, 1);
        l146_lruCache.set(1, 2);
        int b= l146_lruCache.get(2);
        System.out.println(a);
        System.out.println(b);
        assertEquals(new Integer[]{2, -1}, new Integer[]{a, b});
    }
}
