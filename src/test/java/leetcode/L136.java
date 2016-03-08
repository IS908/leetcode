package leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by kevin on 2016/3/8.
 */
public class L136 {
    @Test
    public void test () {
        L136_SingleNumber l136_singleNumber = new L136_SingleNumber();
        int[] nums = {1, 2, 3, 4, 5, 1, 2, 3, 4};

        assertEquals(5, l136_singleNumber.singleNumber(nums));
    }
}
