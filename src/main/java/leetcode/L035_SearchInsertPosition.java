package leetcode;

/**
 * Given a sorted array and a target value, return the index if the target is found.
 * If not, return the index where it would be if it were inserted in order.
 * <p/>
 * You may assume no duplicates in the array.
 * <p/>
 * Here are few examples.
 * [1,3,5,6], 5 → 2
 * [1,3,5,6], 2 → 1
 * [1,3,5,6], 7 → 4
 * [1,3,5,6], 0 → 0
 * <p/>
 * Created by kevin on 2016/4/22.
 */
public class L035_SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        if (nums == null) return 0;
        int left = 0, right = nums.length - 1;
        if (nums[left] > target)   return 0;
        if (nums[right] < target) return nums.length;
        while (left < right) {
            if (nums[right - 1] < target && nums[right] >= target) return right;
            int mid = (left + right) >> 1;
            if (nums[mid] > target && mid > 0 && nums[mid - 1] >= target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid;
                if (mid < nums.length - 1 && nums[mid + 1] <= target) {
                    left = mid + 1;
                }

            } else {
                right = mid;
            }
        }
        return right;
    }
}
