package leetcode;

import org.junit.Test;

/**
 * Created by kevin on 16-3-17.
 */
public class L084 {
    @Test
    public void test() {
        L084_LargestRectangleInHistogram largestRectangleInHistogram = new L084_LargestRectangleInHistogram();
        int[] height = {2, 1, 2};
        int res = largestRectangleInHistogram.largeestRestangleArea(height);
        System.out.println(res);
        System.out.println(largestRectangleInHistogram.largeestRestangleArea01(height));
    }
}
