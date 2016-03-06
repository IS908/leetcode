package leetcode;

/**
 * Given an array and a value, remove all instances of that value in place and return the new length.
 * <p/>
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 * <p/>
 * Created by kevin on 2016/3/4.
 */
public class L027_RemoveElement {
    public int removeElement(int[] nums, int val) {
        int index = 0;
        for (int i=0;i<nums.length;i++){
            if (nums[i] != val) {
                nums[index++] = nums[i];
            }
        }
        return index;
    }
}
