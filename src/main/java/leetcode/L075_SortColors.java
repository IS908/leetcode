package leetcode;

/**
 * Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.
 * <p/>
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 * <p/>
 * Note:
 * You are not suppose to use the library's sort function for this problem.
 * <p/>
 * Created by kevin on 2016/4/22.
 */
public class L075_SortColors {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length < 2) return;
        int s = 0, e = nums.length - 1;
        while (s < e) {
            while (s < e && nums[s] == 0) s++;
            while (s < e && nums[e] > 0) e--;
            swap(nums, s, e);
        }
        s = nums[s] == 0 ? s + 1 : s;
        e = nums.length - 1;
        while (s < e) {
            while (s < e && nums[s] == 1) s++;
            while (s < e && nums[e] > 1) e--;
            swap(nums, s, e);
        }
    }

    private void swap(int[] nums, int index1, int index2) {
        int tmp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = tmp;
    }

    /**
     * 双指针，遍历一遍
     * 由于只有三中颜色，可以设置两个index， 一个是red的index，一个是blue的index， 两边往中间走。时间复杂度O(n)， 空间复杂度O(1)
     * @param nums
     */
    public void sortColors1(int[] nums) {
        if (nums == null || nums.length < 2) return;
        int red = 0, blue = nums.length - 1;
        for (int i = 0; i < blue + 1; ) {
            switch (nums[i]) {
                case 0:
                    swap(nums, i++, red++);
                    break;
                case 2:
                    swap(nums, i, blue--);
                    break;
                default:
                    i++;
                    break;
            }
        }
    }
}
