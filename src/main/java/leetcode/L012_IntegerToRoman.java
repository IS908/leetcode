package leetcode;

/**
 * Given an integer, convert it to a roman numeral.
 * <p/>
 * Input is guaranteed to be within the range from 1 to 3999.
 * <p/>
 * Created by kevin on 2016/2/29.
 */
@Deprecated
public class L012_IntegerToRoman {
    public String intToRoman(int num) {
        final int[] radix = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        final String[] roman = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder sb = new StringBuilder();
        for (int i = 0; num > 0; i++) {
            int count = num / radix[i];
            num %= radix[i];
            while (count > 0) {
                sb.append(roman[i]);
                count--;
            }
        }
        return sb.toString();
    }
}
