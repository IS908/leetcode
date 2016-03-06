package leetcode;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 * <p/>
 * Created by kevin on 2016/2/29.
 */
public class L014_LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        char[] res = strs[0].toCharArray();
        int len = res.length;
        for (int i = 1; i < strs.length; i++) {
            if (strs[i].length() < len) {
                len = strs[i].length();
            }
            for (int j = 0; j < len && j < strs[i].length(); j++) {
                if (res[j] == strs[i].charAt(j)){
                    continue;
                } else {
                    len = j < len ? j : len;
                    break;
                }
            }
        }
        String result = String.valueOf(res).substring(0, len);
        return result;
    }
}
