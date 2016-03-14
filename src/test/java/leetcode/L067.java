package leetcode;

import org.junit.Test;

/**
 * Created by kevin on 2016/3/14.
 */
public class L067 {
    @Test
    public void test() {
        L067_AddBinary addBinary = new L067_AddBinary();
        String str01 = "1";
        String str02 = "111";
        String res = addBinary.addBinary(str01, str02);
        System.out.println(res);
    }
}
