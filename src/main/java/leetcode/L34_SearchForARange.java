package leetcode;

/**
 * Given a sorted array of integers, find the starting and ending position of a given target value.
 * <p/>
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * <p/>
 * If the target is not found in the array, return [-1, -1].
 * <p/>
 * For example,
 * Given [5, 7, 7, 8, 8, 10] and target value 8,
 * return [3, 4].
 * <p/>
 * Created by kevin on 2016/4/22.
 */
public class L34_SearchForARange {
    public int[] searchRange(int[] nums, int target) {
        // 循环实现，比较巧妙
        int[] res = new int[]{-1, -1};
        int left = 0, right = nums.length - 1;
        while (nums[left] < nums[right]) {
            int mid = (left + right) >> 1;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                if (nums[left] == nums[mid]) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        if (nums[left] == target && nums[right] == nums[left]) {
            res[0] = left;
            res[1] = right;
        }
        return res;
        //return searchRanges(nums, target, 0, nums.length - 1);
    }

    /**
     * 递归实现，比较笨拙
     * @param nums
     * @param target
     * @param left
     * @param right
     * @return
     */
    private int[] searchRanges(int[] nums, int target, int left, int right) {
        if (left > right) return new int[]{-1, -1};

        int mid = (left + right) >>> 1;
        if (nums[mid] < target) {
            return searchRanges(nums, target, mid + 1, right);
        } else if (nums[mid] > target) {
            return searchRanges(nums, target, left, mid - 1);
        } else {
            left = right = mid;
            while (left > 0 && nums[left - 1] == target) left--;
            while (right < nums.length - 1 && nums[right + 1] == target) right++;
            return new int[]{left, right};
        }
    }
}
