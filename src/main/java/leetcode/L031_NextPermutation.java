package leetcode;

/**
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 * <p/>
 * If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
 * <p/>
 * The replacement must be in-place, do not allocate extra memory.
 * <p/>
 * Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 * <p/>
 * Created by kevin on 2016/3/5.
 */
public class L031_NextPermutation {
    private void reverse(int[] nums, int start, int end) {
        int tmp;
        while (start < end) {
            tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
    }

    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int loc, len = nums.length, tmp;
        for (int i = len - 1; i > 0; i--) {
            if (nums[i - 1] < nums[i]) {
                loc = i - 1;
                for (int j = len - 1; j > loc; j--) {
                    if (nums[j] > nums[loc]) {
                        tmp = nums[loc];
                        nums[loc] = nums[j];
                        nums[j] = tmp;
                        break;
                    }
                }
                reverse(nums, loc + 1, len - 1);
                return;
            }
        }

        // 当前为最大排列，寻找最小排列
        reverse(nums, 0, len - 1);
    }
}
