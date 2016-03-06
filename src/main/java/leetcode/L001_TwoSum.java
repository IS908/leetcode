package leetcode;

import java.util.HashMap;

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
        int[] res = null;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int tmp = target - nums[i];
            if (map.get(tmp) != null && map.get(tmp) != i) {
                int gap = map.get(tmp);
                int higher = i > gap ? i : gap;
                int lower = i < gap ? i : gap;
                res = new int[]{lower, higher};
                break;
            }
        }
        return res;
    }
}
