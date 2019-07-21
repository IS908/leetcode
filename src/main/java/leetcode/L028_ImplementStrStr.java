package leetcode;

/**
 * Implement strStr().
 * <p/>
 * Returns the index of the first occurrence of needle in haystack,
 * or -1 if needle is not part of haystack.
 * <p/>
 * Created by kevin on 2016/3/13.
 */
public class L028_ImplementStrStr {
    public int strStr(String haystack, String needle) {
        // 暴力解法
        if (needle.isEmpty()) return 0;
        final int N = haystack.length() - needle.length() + 1;
        for (int i = 0; i < N; i++) {
            int k = 0;
            for (int j = i; j < haystack.length() && haystack.charAt(j) == needle.charAt(k); j++, k++) {
                if (k == needle.length() - 1) return i;
            }
        }
        return -1;
    }

    public int strStr01(String haystack, String needle) {
        if (needle.isEmpty()) return 0;
        // KMP算法
        int[] next = compute_prefix(needle.toCharArray());

        /*for (int i =0;i<next.length;i++) {
            System.out.print(next[i] + ", ");
        }*/

        for (int i = 0, j = 0; i < haystack.length(); i++) {
            while (j > 0 && needle.charAt(j) != haystack.charAt(i)) j = next[j - 1];

            if (haystack.charAt(i) == needle.charAt(j)) j++;
            if (j == needle.length()) return i - j + 1;
        }

        return -1;
    }

    private int[] compute_prefix(char[] pattern) {
        int len = pattern.length;
        int[] next = new int[len];
        next[0] = 0;
        for (int i = 1, j = 0; i < len; i++) {
            while (j > 0 && pattern[j] != pattern[i]) j = next[j - 1];
            if (pattern[i] == pattern[j]) j++;
            next[i] = j;
        }
        return next;
    }
}
