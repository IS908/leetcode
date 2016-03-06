package leetcode;

/**
 * Follow up for "Search in Rotated Sorted Array":
 * What if duplicates are allowed?
 * <p/>
 * Would this affect the run-time complexity? How and why?
 * <p/>
 * Write a function to determine if a given target is in the array.
 * <p/>
 * Created by kevin on 2016/3/3.
 */
public class L081_SearchInRotatedSortedArrayII {
    public boolean search(int[] nums, int target) {
        int first = 0, last = nums.length, mid;
        while (first != last) {
            mid = (first + last) / 2;
            if (nums[mid] == target) return true;
            if (nums[first] < nums[mid]) {
                if (nums[first] <= target && target < nums[mid]) {
                    last = mid;
                } else {
                    first = mid + 1;
                }
            } else if (nums[first] > nums[mid]){
                if (nums[mid] < target && target <= nums[last - 1]) {
                    first = mid + 1;
                } else {
                    last = mid;
                }
            } else {
                first++;
            }
        }
        return false;
    }
}
