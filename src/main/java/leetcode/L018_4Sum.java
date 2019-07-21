package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target?
 * Find all unique quadruplets in the array which gives the sum of target.
 * <p/>
 * Created by kevin on 2016/3/2.
 */
public class L018_4Sum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        int sum;
        for (int i = 0; i < nums.length - 3; i++) {
            for (int j = i + 1; j < nums.length - 2; j++) {
                for (int m = j + 1, n = nums.length - 1; m < n; ) {
                    sum = nums[i] + nums[j] + nums[m] + nums[n];
                    if (sum < target) {
                        m++;
                    } else if (sum > target) {
                        n--;
                    } else {
                        List<Integer> list = new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[m], nums[n]));
                        result.add(list);
                        m++;
                        n--;
                        while ((m < n) && nums[n] == nums[n + 1]) {
                            n--;
                        }
                        while ((m < n) && nums[m] == nums[m - 1]) {
                            m++;
                        }
                    }
                }
                while (j < nums.length - 2 && nums[j] == nums[j + 1]) {
                    j++;
                }
            }
            while (i < nums.length - 2 && nums[i] == nums[i + 1]) {
                i++;
            }
        }
        return result;
    }
}
