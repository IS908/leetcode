package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * <p/>
 * You may assume that each input would have exactly one solution.
 * <p/>
 * Created by kevin on 2016/3/4.
 */
public class L001_TwoSum {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0) return null;
        int[] res = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) map.put(nums[i], i);

        for (int i = 0; i < nums.length; i++) {
            int gap = target - nums[i];
            Integer index = map.get(gap);
            if (index != null && index != i) {
                res[0] = Math.min(i, index);
                res[1] = Math.max(i, index);
                break;
            }
        }

        return res;
    }
}
