package leetcode;

/**
 * Follow up for "Remove Duplicates":
 * What if duplicates are allowed at most twice?
 * <p/>
 * For example,
 * Given sorted array nums = [1,1,1,2,2,3],
 * <p/>
 * Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3.
 * It doesn't matter what you leave beyond the new length.
 * <p/>
 * Created by kevin on 2016/3/3.
 */
public class L080_RemoveDuplicatesFromSortedArrayII {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return 1;
        int index = 0, m = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[++index] = nums[i];
                m = 0;
            } else {
                m++;
                if (m < 2) {
                    nums[++index] = nums[i];
                }
            }
        }
        /*for (int t: nums) {
            System.out.print(t + ",");
        }*/
        return index + 1;
    }
}
