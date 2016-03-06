package leetcode;

/**
 * Determine whether an integer is a palindrome. Do this without extra space.
 * <p/>
 * Created by kevin on 2016/2/26.
 */
public class L009_PalindromeNumber {
    public boolean isPalindrome(int x) {
        String str = String.valueOf(Math.abs(x));
        int len = str.length();
        for (int i = 0; i <= len/2; i++) {
            if (str.charAt(i) != str.charAt(len - i - 1))
                return false;
        }
        return true;

        /*if (x < 0)
            return false;
        int y = 0, x1 = 1;
        while (x / x1 != 0) {
            y = y * 10 + x % 10;
            x /= 10;
            x1 *= 10;
        }
        return y < 10 * x ? y == x : y / 10 == x;*/
    }
}
