package leetcode;

/**
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.
 * <p/>
 * If the last word does not exist, return 0.
 * <p/>
 * Note: A word is defined as a character sequence consists of non-space characters only.
 * <p/>
 * For example,
 * Given s = "Hello World",
 * return 5.
 * <p/>
 * Created by kevin on 2016/3/16.
 */
public class L058_LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        if (s == null || s.trim().length() == 0)    return 0;
        String[] strs = s.trim().split(" ");
        return strs[strs.length - 1].toCharArray().length;
    }
}
