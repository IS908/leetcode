package leetcode;

/**
 * Given a non-negative number represented as an array of digits, plus one to the number.
 * <p/>
 * The digits are stored such that the most significant digit is at the head of the list.
 * <p/>
 * Created by kevin on 2016/3/6.
 */
public class L066_PlusOne {
    public int[] plusOne(int[] digits) {
        int flag = 1;
        int tmp;
        for (int i = digits.length - 1; i >= 0; i--) {
            tmp = digits[i] + flag;
            digits[i] = tmp % 10;
            flag = tmp / 10;
        }
        if (flag > 0) {
            int[] result = new int[digits.length + 1];
            System.arraycopy(digits, 0, result, 1, digits.length);
            result[0] = flag;
            digits = result;
        }
        return digits;
    }
}
