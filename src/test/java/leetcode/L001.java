package leetcode;

import org.junit.Test;

/**
 * Created by kevin on 2016/3/4.
 */
public class L001 {
    @Test
    public void test() {
        L001_TwoSum l001 = new L001_TwoSum();
        int[] nums = {2, 7, 11, 15};
        int[] res = l001.twoSum(nums, 9);
        for (int i: res){
            System.out.println(i);
        }
    }
}
