package leetcode;

import org.junit.Test;

/**
 * Created by kevin on 2016/3/16.
 */
public class L032 {
    @Test
    public void test () {
        L032_LongestValidParentheses longestValidParentheses = new L032_LongestValidParentheses();
        String str = "((()()(";
        int res = longestValidParentheses.longestValidParentheses(str);
        System.out.println(res);
    }
}
