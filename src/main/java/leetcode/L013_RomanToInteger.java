package leetcode;

/**
 * Given a roman numeral, convert it to an integer.
 * <p/>
 * Input is guaranteed to be within the range from 1 to 3999.
 * <p/>
 * Created by kevin on 2016/2/29.
 */
public class L013_RomanToInteger {
    public int romanToInt(String s) {
        final int[] radix = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        final String[] roman = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            String tmp;
            int j = 0;
            boolean flag = false;
            if (i < s.length() - 1) {
                tmp = s.substring(i, i + 2);
                for (; j < roman.length; j++) {
                    if (roman[j].equals(tmp)) {
                        flag = true;
                        break;
                    }
                }
                if (flag) {
                    result += radix[j];
                    i++;
                    continue;
                }
            }

            tmp = s.substring(i, i + 1);
            j = 0;
            flag = false;
            for (; j < roman.length; j++) {
                if (roman[j].equals(tmp)) {
                    flag = true;
                    break;
                }
            }
            if (flag) result += radix[j];
        }
        return result;
    }
}
