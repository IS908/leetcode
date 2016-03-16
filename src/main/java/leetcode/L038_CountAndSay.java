package leetcode;

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
        return count(String.valueOf(n));
    }

    private String count(String str) {
        if (str.length() < 2) {
            return "1" + str;
        }
        StringBuilder sb = new StringBuilder();
        int count;
        char ch;
        for (int i = 0; i < str.length(); i++) {
            ch = str.charAt(i);
            count = 1;
            while (i < str.length() - 1 && ch == str.charAt(i + 1)) {
                count++;
                i++;
            }
            sb.append(count).append(ch);
        }
        return sb.toString();
    }
}
