package leetcode;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 * For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3.
 * For "bbbbb" the longest substring is "b", with the length of 1.
 */
public class L003_LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        int max = 0, i = 0, j = 0, index;
        int[] hm = new int[128];
        while (j < s.length()) {
            if (hm[s.charAt(j)] == 0) {
                hm[s.charAt(j)] = j + 1;
                j++;
                if ((j - i) > max) {
                    max = j - i;
                }
            } else {
                index = hm[s.charAt(j)];
                hm[s.charAt(j)] = 0;
                if (i < index) {
                    i = index;
                }
            }
        }
        return max;
    }
}
