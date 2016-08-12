package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 递归类
 * <p>
 * Given a digit string, return all possible letter combinations that the number could represent.
 * <p/>
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 * <p/>
 * Created by kevin on 2016/3/2.
 */
@Deprecated
public class L017_LetterCombinationsOfAPhoneNumber {
    // 递归解决方案
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        String[] map = new String[]{" ", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        StringBuilder sb = new StringBuilder();
        if (digits == null || digits.length() == 0) {
            return result;
        }
        helper(result, sb, digits, map, 0);
        return result;
    }

    private void helper(List<String> result, StringBuilder single, String digits, String[] map, int start) {
        if (start >= digits.length()) {
            result.add(single.toString());
            return;
        }
        int index = digits.charAt(start) - '0';
        String current = map[index];
        for (int i = 0; i < current.length(); i++) {
            single = single.append(current.charAt(i));
            helper(result, single, digits, map, start + 1);
            single = single.deleteCharAt(start);
        }
    }

    // 迭代解决方案
    public List<String> letterCombinations1(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.length() < 1)    return result;
        String[] map = new String[]{" ", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        String str = map[digits.charAt(0) - '0'];
        for (int i = 0;i<str.length();i++) {
            result.add(String.valueOf(str.charAt(i)));
        }
        for (int i = 1; i < digits.length(); i++) {
            List<String> tmp = result;
            String curStr = map[digits.charAt(i) - '0'];
            int nSize = result.size();
            int mSize = curStr.length();
            result = new ArrayList<>(nSize * mSize);
            for (String tmpStr : tmp) {
                for (int j = 0; j < mSize; j++) {
                    result.add(tmpStr + curStr.charAt(j));
                }
            }
        }
        return result;
    }

}
