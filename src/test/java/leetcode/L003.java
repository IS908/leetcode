package leetcode;

import org.junit.Test;

/**
 * Created by kevin on 2016/2/21.
 */
public class L003 {
    @Test
    public void LongestSubstringWithoutRepeatingCharacters() {
        String s = "abcabcbbbaaa";
        L003_LongestSubstringWithoutRepeatingCharacters l003 = new L003_LongestSubstringWithoutRepeatingCharacters();
        int result = l003.lengthOfLongestSubstring(s);
        System.out.println(result);
    }
}
