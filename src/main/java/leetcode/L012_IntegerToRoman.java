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
        char[] roman = new char[]{'I', 'V', 'X', 'L', 'C', 'D', 'M'};
        String result = null;
        int current = num / 1000;
        for (int i = 0; i < current; i++) {
            result += "M";
        }
        num = num % 1000;

        current = num/100;
        if (current > 8) {

        }
        num = num % 100;

        return null;
    }
}
