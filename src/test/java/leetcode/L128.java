package leetcode;

import org.junit.Test;

/**
 * Created by kevin on 2016/3/4.
 */
public class L128 {
    @Test
    public void test() {
        L128_LongestConsecutiveSequence l128 = new L128_LongestConsecutiveSequence();
        int[] nums = {1, 3, 2, 6};
        int res = l128.longestConsecutive(nums);
        System.out.println(res);
    }
}