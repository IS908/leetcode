package leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by kevin on 2016/3/7.
 */
public class L135 {
    @Test
    public void test() {
        L135_Candy l135 = new L135_Candy();
        int[] ratings01 = {1,3,4,3,2,1};
        int[] ratings02 = {1, 2, 4, 4, 3};

        assertEquals(13, l135.candy(ratings01));
        assertEquals(9, l135.candy(ratings02));
    }
}
