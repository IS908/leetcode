package leetcode;

/**
 * Given an array of integers, every element appears twice except for one. Find that single one.
 * <p/>
 * Note:
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 * <p/>
 * Created by kevin on 2016/3/8.
 */
public class L136_SingleNumber {
    public int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0)   return 0;
        int num = nums[0];
        for (int i = 1; i < nums.length; i++) {
            num ^= nums[i];
        }
        return num;
    }
}
