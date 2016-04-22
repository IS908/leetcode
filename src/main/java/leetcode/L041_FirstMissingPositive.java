package leetcode;

/**
 * Given an unsorted integer array, find the first missing positive integer.
 * <p/>
 * For example,
 * Given [1,2,0] return 3,
 * and [3,4,-1,1] return 2.
 * <p/>
 * Your algorithm should run in O(n) time and uses constant space.
 * <p/>
 * Created by kevin on 2016/4/14.
 */
@Deprecated
public class L041_FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 1;
        }
        int temp = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0 || (nums[i] - 1) > nums.length) {
                continue;
            } else {
                if (nums[i] <= nums.length && nums[nums[i] - 1] != nums[i]) {
                    temp = nums[nums[i] - 1];
                    nums[nums[i] - 1] = nums[i];
                    while (temp > 0 && temp < nums.length) {
                        int temp1 = nums[temp - 1];
                        if (temp == temp1) break;
                        nums[temp - 1] = temp;
                        temp = temp1;
                    }
                }
            }
        }
        int i = 0;
        for (; i < nums.length; i++) {
            if (i + 1 != nums[i]) {
                return i + 1;
            }
        }
        return i + 1;
    }

    /*private void bucketSort(int[] nums) {
        int pos = 0;
        while (pos < nums.length) {
            if (nums[pos] > 0 && nums[pos] != pos + 1 && nums[pos] - 1 < nums.length && nums[pos] != nums[nums[pos] - 1])
                swap(nums, nums[pos], nums[nums[pos] - 1]);
            else ++pos;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }*/
}
