package leetcode;

import org.junit.Test;

/**
 * Created by kevin on 2016/3/3.
 */
public class L081 {
    @Test
    public void test() {
        L081_SearchInRotatedSortedArrayII l081 = new L081_SearchInRotatedSortedArrayII();
        int[] nums = {4, 5, 6, 6, 1, 2, 3, 3, 3};
        boolean res = l081.search(nums, 3);
        System.out.println(res);
    }
}
