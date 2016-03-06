package leetcode;

import org.junit.Test;

/**
 * Created by kevin on 2016/3/2.
 */
public class L020 {
    @Test
    public void test() {
        L020_ValidParentheses l020 = new L020_ValidParentheses();
        boolean flag = l020.isValid("()[]{}");
        System.out.println(flag);
    }
}
