package leetcode;

import org.junit.Test;

/**
 * Created by kevin on 2016/2/29.
 */
public class L014 {
    @Test
    public void test() {
        L014_LongestCommonPrefix l014 = new L014_LongestCommonPrefix();
        String[] strs = new String[]{"aa", "a", "aaa"};
        String str = l014.longestCommonPrefix(strs);
        System.out.println(str);
    }
}
