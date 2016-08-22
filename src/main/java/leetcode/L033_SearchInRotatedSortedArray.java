package leetcode;

/**
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 * You may assume no duplicate exists in the array.
 * <p/>
 * Created by kevin on 2016/3/3.
 */
public class L033_SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int first = 0, last = nums.length, mid;
        while (first != last) {
            mid = (first + last) / 2;
            if (nums[mid] == target) return mid;
            if (nums[first] <= nums[mid]) { // 突变点在 mid 右边
                if (nums[first] <= target && target <= nums[mid]) {
                    last = mid;
                } else first = mid + 1;
            } else {                        // 突变点在 mid 左边
                if (nums[mid] < target && target <= nums[last - 1]) {
                    first = mid + 1;
                } else last = mid;
            }
        }
        return -1;
    }
}
