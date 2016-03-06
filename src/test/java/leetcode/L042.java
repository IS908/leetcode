package leetcode;

import org.junit.Test;

/**
 * Created by kevin on 2016/3/6.
 */
public class L042 {
    @Test
    public void test() {
        L042_TrappingRainWater l042 = new L042_TrappingRainWater();
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int res = l042.trap(height);
        System.out.println(res);
    }
}
