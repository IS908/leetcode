package leetcode;

import org.junit.Test;

/**
 * Created by kevin on 2016/3/13.
 */
public class L125 {
    @Test
    public void test() {
        L125_ValidPalindrome validPalindrome = new L125_ValidPalindrome();
        String str = "A man, a plan, a canal: Panama";
        boolean flag = validPalindrome.isPalindrome(str);
        System.out.println(flag);
    }
}
