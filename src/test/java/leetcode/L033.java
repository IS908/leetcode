package leetcode;

import org.junit.Test;

/**
 * Created by kevin on 2016/3/3.
 */
public class L033 {
    @Test
    public void test() {
        L033_SearchInRotatedSortedArray l033 = new L033_SearchInRotatedSortedArray();
        int[] nums = {1, 3, 5};
        int res = l033.search(nums, 1);
        System.out.println(res);
    }
}
