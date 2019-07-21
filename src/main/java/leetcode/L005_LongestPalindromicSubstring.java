package leetcode;

/**
 * Given a string S, find the longest palindromic substring in S.
 * You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.
 * <p>
 * Created by kevin on 2016/2/21.
 */
public class L005_LongestPalindromicSubstring {
    /*public String longestPalindrome(String s) {
        int maxPalinLength = 0;
        String longestPalindrome = null;
        int length = s.length();

        for (int i=0; i<length; ++i) {
            for (int j=s.length(); j>i; --j) {
                String tmp = s.substring(i, j);
                if (isPalindrome(tmp)) {
                    if (maxPalinLength < (j-i)){
                        maxPalinLength = j-i;
                        longestPalindrome = tmp;
                    }
                    break;
                }
            }
        }
        return longestPalindrome;
    }

    private boolean isPalindrome(String s) {
        int len = s.length();
        int tail = len - 1;
        for (int i=0; i< len/2; i++) {
            if (s.charAt(i) != s.charAt(tail))
                return false;
            tail--;
        }
        return true;
    }*/

    int palinStart = 0;
    int palinLen = 0;

    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length - 1; i++) {
            checkThisPos(chars, i, i);
            checkThisPos(chars, i, i + 1);
        }
        return s.substring(palinStart, palinStart + palinLen);
    }

    public void checkThisPos(char[] chars, int left, int right) {
        while (left >= 0 && right < chars.length && chars[left] == chars[right]) {
            left--;
            right++;
        }
        if (right - left - 1 > palinLen) {
            palinLen = right - left - 1;
            palinStart = left + 1;
        }
    }

    public String longestPalindrome2(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        int[] tmp = new int[]{0, 1};
        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length - 1; i++) {
            checkPos(chars, i, i, tmp);
            checkPos(chars, i, (i + 1), tmp);
        }
        return s.substring(tmp[0], tmp[0] + tmp[1]);
    }

    private void checkPos(char[] chars, int left, int right, int[] res) {
        while (left >= 0 && right < chars.length && chars[left] == chars[right]) {
            left--;
            right++;
        }

        if (right - left - 1 > res[1]) {
            res[0] = left + 1;
            res[1] = right - left - 1;
        }
    }
}
