package leetcode;

import org.junit.Test;

/**
 * Created by kevin on 2016/2/29.
 */
public class L011 {
    @Test
    public void test() {
        L011_ContainerWithMostWater l011 = new L011_ContainerWithMostWater();
        int[] height = new int[]{1, 1, 2, 3, 1};
        int res = l011.maxArea(height);
        System.out.println(res);
    }
}
