package leetcode;

/**
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 * <p/>
 * For example,
 * "A man, a plan, a canal: Panama" is a palindrome.
 * "race a car" is not a palindrome.
 * <p/>
 * Note:
 * Have you consider that the string might be empty? This is a good question to ask during an interview.
 * <p/>
 * For the purpose of this problem, we define empty string as valid palindrome.
 * <p/>
 * Created by kevin on 2016/3/13.
 */
public class L125_ValidPalindrome {
    public boolean isPalindrome(String s) {
        if (s.trim().length() < 2) return true;
        int low = 0, high = s.length() - 1;
        char[] arr = s.toLowerCase().toCharArray();
        while (low < high) {
            while (!isValid(arr[low]) && low < high) low++;
            while (!isValid(arr[high]) && low < high) high--;
            if (arr[low] != arr[high] && low < high) {
                return false;
            }
            low++;
            high--;
        }
        return true;
    }

    private boolean isValid(char a) {
        if (a >= 'a' && a <= 'z') return true;
        if (a >= '0' && a <= '9') return true;
        return false;
    }
}
