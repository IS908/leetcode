package leetcode;

/**
 * Created by Kevin on 2017-08-27 21:42.
 */
public class L520_DetectCapital {
    public boolean detectCapitalUse(String word) {
        char[] chars = word.toCharArray();
        if (chars.length <= 1) return true;
        boolean flagLow = false, flagUpper = false;
        boolean firstUpper = isUpperCase(chars[0]);
        for (int i = 1; i < chars.length; i++) {
            if (firstUpper) { // 首字母是大写，后续可以全大写或全小写
                if (isUpperCase(chars[i])) {
                    if (flagLow) return false;
                    flagUpper = true;
                } else {
                    if (flagUpper) return false;
                    flagLow = true;
                }
            } else { // 首字母是小写，后续全是小写
                if (isUpperCase(chars[i])) return false;
            }
        }
        return true;
    }

    private boolean isUpperCase(char c) {
        return c >= 'A' && c <= 'Z';
    }
}
