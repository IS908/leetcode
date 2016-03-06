package leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by kevin on 2016/2/24.
 */
public class L006 {
    @Test
    public void test() {
        L006_ZigZagConversion l006 = new L006_ZigZagConversion();
        String s = "PAYPALISHIRING";
        String res = l006.convert(s, 3);
        //Assert.assertEquals();
        System.out.println(res);
    }
}
