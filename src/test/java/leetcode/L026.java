package leetcode;

import org.junit.Test;

/**
 * Created by kevin on 2016/3/3.
 */
public class L026 {
    @Test
    public void test() {
        L026_RemoveDuplicatesFromSortedArray l026 = new L026_RemoveDuplicatesFromSortedArray();
        int[] nums = {1, 1, 2, 2, 3, 3, 4};
        int res = l026.removeDuplicates(nums);
        System.out.println(res);
    }
}
