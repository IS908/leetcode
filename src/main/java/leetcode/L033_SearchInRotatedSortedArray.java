package leetcode;

/**
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * <p/>
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * <p/>
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 * <p/>
 * You may assume no duplicate exists in the array.
 * <p/>
 * Created by kevin on 2016/3/3.
 */
public class L033_SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        int first = 0, last = nums.length, mid;
        while (first != last) {
            mid = (first + last) / 2;
            if (nums[mid] == target) return mid;
            if (nums[first] <= nums[mid]) {
                if (nums[first] <= target && target <= nums[mid]) {
                    last = mid;
                } else {
                    first = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[last - 1]) {       //*******************
                    first = mid + 1;
                } else last = mid;
            }
        }
        return -1;
    }
}
