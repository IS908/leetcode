package leetcode;

/**
 * Implement regular expression matching with support for '.' and '*'.
 * <p/>
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 * <p/>
 * The matching should cover the entire input string (not partial).
 * <p/>
 * The function prototype should be:
 * bool isMatch(const char *s, const char *p)
 * <p/>
 * Some examples:
 * isMatch("aa","a") → false
 * isMatch("aa","aa") → true
 * isMatch("aaa","aa") → false
 * isMatch("aa", "a*") → true
 * isMatch("aa", ".*") → true
 * isMatch("ab", ".*") → true
 * isMatch("aab", "c*a*b") → true
 * <p/>
 * Created by kevin on 2016/2/26.
 */
@Deprecated
public class L010_RegularExpressionMatching {
    public boolean isMatch01(String s, String p) {
        /**
         * This solution is assuming s has no regular expressions.
         *
         * dp: res[i][j]=is s[0,...,i-1] matched with p[0,...,j-1];
         *
         * If p[j-1]!='*', res[i][j] = res[i-1][j-1] &&
         * (s[i-1]==p[j-1]||p[j-1]=='.'). Otherwise, res[i][j] is true if
         * res[i][j-1] or res[i][j-2] or
         * res[i-1][j]&&(s[i-1]==p[j-2]||p[j-2]=='.'), and notice the third
         * 'or' case includes the first 'or'.
         *
         *
         * Boundaries: res[0][0]=true;//s=p="". res[i][0]=false, i>0.
         * res[0][j]=is p[0,...,j-1] empty, j>0, and so res[0][1]=false,
         * res[0][j]=p[j-1]=='*'&&res[0][j-2].
         *
         * O(n) space is enough to store a row of res.
         */

        int m = s.length(), n = p.length();
        boolean[] res = new boolean[n + 1];
        res[0] = true;

        int i, j;
        for (j = 2; j <= n; j++) {
            res[j] = res[j - 2] && p.charAt(j - 1) == '*';
        }

        char pc, sc, tc;
        boolean pre, cur; // pre=res[i - 1][j - 1], cur=res[i-1][j]

        for (i = 1; i <= m; i++) {
            pre = res[0];
            res[0] = false;
            sc = s.charAt(i - 1);
            for (j = 1; j <= n; j++) {
                cur = res[j];
                pc = p.charAt(j - 1);
                if (pc != '*')
                    res[j] = pre && (sc == pc || pc == '.');
                else {
                    // pc == '*' then it has a preceding char, i.e. j>1
                    tc = p.charAt(j - 2);
                    res[j] = res[j - 2] || (res[j] && (sc == tc || tc == '.'));
                }
                pre = cur;
            }
        }
        return res[n];
    }

    public boolean isMatch(String s, String p) {
        int slen = s.length();
        int plen = p.length();

        if (slen == 0 && plen == 0) return true;

        char c0 = getChar(s, 0);
        char p0 = getChar(p, 0), p1 = getChar(p, 1);

        if (match(c0, p0) || p1 == '*') {
            if (p1 != '*') {
                if (slen == 0) return false;
                return isMatch(s.substring(1), p.substring(1));
            }
            // if p1 is *, * means 0 ~ n
            int i = 0;
            boolean ret = isMatch(s.substring(0), p.substring(2)); // try 0
            if (ret) return ret;
            while (i < slen && match(getChar(s, i), p0)) {
                ret = isMatch(s.substring(i + 1), p.substring(2)); // try for every available position
                if (ret) return ret;
                i++;
            }
        }
        return false;
    }

    private boolean match(char a, char b) {
        return a == b || b == '.';
    }

    private char getChar(String s, int p) {
        if (s.length() > p) return s.charAt(p);
        return 0;
    }
}
