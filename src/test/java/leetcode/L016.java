package leetcode;

import org.junit.Test;

/**
 * Created by kevin on 2016/2/29.
 */
public class L016 {
    @Test
    public void test() {
        L016_3SumClosest l016 = new L016_3SumClosest();
        int[] arr = new int[] {-1, 2, 1, -4};
        int res = l016.threeSumClosest(arr, 2);
        System.out.println(res);
    }
}
