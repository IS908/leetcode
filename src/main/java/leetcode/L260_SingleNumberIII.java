package leetcode;

/**
 * Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice.
 * Find the two elements that appear only once.
 * <p/>
 * For example:
 * <p/>
 * Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].
 * <p/>
 * Note:
 * The order of the result is not important. So in the above example, [5, 3] is also correct.
 * Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?
 * Credits:
 * Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.
 * <p/>
 * Created by kevin on 2016/3/8.
 */
public class L260_SingleNumberIII {
    public int[] singleNumber(int[] nums) {
        if (nums == null || nums.length < 2)    return null;
        int cur = 0, tmp, m = 0, n = 0;
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            cur ^= nums[i];
        }
        tmp = cur - (cur & (cur - 1));
        for (int i = 0; i < nums.length; i++) {
            if (0 == (tmp & nums[i])) {
                m ^= nums[i];
            } else {
                n ^= nums[i];
            }
        }
        res[0] = m < n ? m : n;
        res[1] = m > n ? m : n;
        return res;
    }
}
