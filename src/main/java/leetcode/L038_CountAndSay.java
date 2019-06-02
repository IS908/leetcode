package leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * The count-and-say sequence is the sequence of integers beginning as follows:
 * 1, 11, 21, 1211, 111221, ...
 * <p/>
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 * Given an integer n, generate the nth sequence.
 * <p/>
 * Note: The sequence of integers will be represented as a string.
 * <p/>
 * Created by kevin on 2016/3/16.
 */

public class L038_CountAndSay {

    public String countAndSay(int n) {
        String str = "1";
        List<Character> chars = new LinkedList<>();
        List<Integer> counts = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < n; i++) {
            chars.clear();
            counts.clear();
            for (int j = 0; j < str.length(); j++) {
                int count = 1;
                while (j < str.length() - 1 && str.charAt(j) == str.charAt(j + 1)) {
                    count++;
                    j++;
                }
                chars.add(str.charAt(j));
                counts.add(count);
            }
            sb.setLength(0);
            for (int j = 0; j < chars.size(); j++) {
                sb.append(counts.get(j)).append(chars.get(j));
            }
            str = sb.toString();
        }
        return str;
    }
}
