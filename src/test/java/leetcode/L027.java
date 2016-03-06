package leetcode;

import org.junit.Test;

/**
 * Created by kevin on 2016/3/5.
 */
public class L027 {
    @Test
    public void test() {
        L027_RemoveElement l027 = new L027_RemoveElement();
        int[] nums = {1, 3, 5, 7, 2, 3, 4, 5, 6};
        int res = l027.removeElement(nums, 3);
        System.out.println(res);
    }
}
