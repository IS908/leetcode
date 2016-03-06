package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 递归类
 *
 * Given a digit string, return all possible letter combinations that the number could represent.
 * <p/>
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 * <p/>
 * Created by kevin on 2016/3/2.
 */
@Deprecated
public class L017_LetterCombinationsOfAPhoneNumber {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        String[][] map = new String[][]{{}, {}, {"a", "b", "c"}, {"d", "e", "f"},
                {"g", "h", "i"}, {"j", "k", "l"}, {"m", "n", "o"},
                {"p", "q", "r", "s"}, {"t", "u", "v"}, {"w", "x", "y", "z"}};
        String single = "";
        if (digits == null || digits.length() == 0) {
            return result;
        }
        helper(result, single, digits, map, 0);
        return result;
    }

    private void helper(List<String> result, String single, String digits, String[][] map, int start) {
        if (start >= digits.length()) {                                     // go out condition
            result.add(single);
            return;
        }
        int index = digits.charAt(start) - '0';
        String[] current = map[index];                                  //get letter collection of current digit
        for (int i = 0; i < current.length; i++) {
            single = single + current[i];                                //add one letter to current prefix
            helper(result, single, digits, map, start + 1);    //go recursive
            single = single.substring(0, single.length() - 1);    //remove the last digit, prepare to change to another letter
        }
    }

}
