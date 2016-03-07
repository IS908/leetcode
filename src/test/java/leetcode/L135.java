package leetcode;

import org.junit.Test;

/**
 * Created by kevin on 2016/3/7.
 */
public class L135 {
    @Test
    public void test() {
        L135_Candy l135 = new L135_Candy();
        int[] ratings = {1,3,4,3,2,1};
        int res = l135.candy(ratings);
        System.out.println(res);
    }
}
