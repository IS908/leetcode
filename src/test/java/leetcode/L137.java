package leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by kevin on 2016/3/8.
 */
public class L137 {
    @Test
    public void test() {
        L137_SingleNumberII l137_singleNumberII = new L137_SingleNumberII();
        int[] nums = {1, 2, 3, 4, 5, 1, 2, 3, 4, 4, 3, 2, 1};

        assertEquals(5, l137_singleNumberII.singleNumber(nums));
        assertEquals(5, l137_singleNumberII.singleNumber02(nums));
    }
}
