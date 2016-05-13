package leetcode;

/**
 * Write a function that takes a string as input and returns the string reversed.
 * 
 * Example:
 * Given s = "hello", return "olleh".
 * 
 * Created by chenkunsi2782 on 2016/5/13.
 */
public class L344_ReverseString {
	public String reverseString(String s) {
		if (s == null || s.length() < 1) {
			return s;
		}
		char[] arr = s.toCharArray();
		int len = arr.length - 1;
		for (int i = 0; i < (arr.length >> 1); i++) {
			char tmp = arr[i];
			arr[i] = arr[len - i];
			arr[len - i] = tmp;
		}
        return String.valueOf(arr);
	}
}
