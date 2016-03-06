package leetcode;

import org.junit.Test;

/**
 * Created by kevin on 2016/2/26.
 */
public class L008 {
    @Test
    public void test() {
        L008_StringToInteger_atoi l008 = new L008_StringToInteger_atoi();
        int res = l008.myAtoi("2147483648");
        System.out.println(res);
    }
}
