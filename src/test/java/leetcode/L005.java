package leetcode;

import org.junit.Test;

/**
 * Created by kevin on 2016/2/21.
 */
public class L005 {
    @Test
    public void L005Test() {
        String s = "abcccba";
        L005_LongestPalindromicSubstring l005 = new L005_LongestPalindromicSubstring();
        String res = l005.longestPalindrome(s);
        System.out.println(res);
    }

}
