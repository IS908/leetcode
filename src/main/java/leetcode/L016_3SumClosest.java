package leetcode;

import java.util.Arrays;

/**
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target.
 * Return the sum of the three integers. You may assume that each input would have exactly one solution.
 * <p/>
 * Created by kevin on 2016/2/29.
 */
public class L016_3SumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result = nums[0] + nums[1] + nums[2], tmp;
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1, k = nums.length - 1; j < k; ) {
                tmp = nums[i] + nums[j] + nums[k];
                if (Math.abs(tmp - target) < Math.abs(result - target)) {
                    result = tmp;
                }

                if (tmp > target) k--;
                else if (tmp < target) j++;
                else return target;
            }
            /*for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    tmp = nums[i] + nums[j] + nums[k];
                    if (Math.abs(tmp - target) < Math.abs(result - target)) {
                        result = tmp;
                    }
                }
            }*/
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-3,-2,-5,3,-4};
        L016_3SumClosest sumClosest = new L016_3SumClosest();
        int res = sumClosest.threeSumClosest(nums, -1);
        System.out.println(res);
    }
}
