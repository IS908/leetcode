package leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by kevin on 2016/3/8.
 */
public class L260 {
    @Test
    public void test() {
        L260_SingleNumberIII l260_singleNumberIII = new L260_SingleNumberIII();
        int[] nums = {1, 1, 2, 3, 4, 5, 6, 5, 4, 2};

        assertEquals(3, l260_singleNumberIII.singleNumber(nums)[0]);
        assertEquals(6, l260_singleNumberIII.singleNumber(nums)[1]);
    }
}
