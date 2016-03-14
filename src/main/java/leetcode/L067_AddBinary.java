package leetcode;

/**
 * Given two binary strings, return their sum (also a binary string).
 * <p/>
 * For example,
 * a = "11"
 * b = "1"
 * Return "100".
 * <p/>
 * Created by kevin on 2016/3/14.
 */
public class L067_AddBinary {
    public String addBinary(String a, String b) {
        char[] A = a.toCharArray();
        char[] B = b.toCharArray();
        StringBuilder sb = new StringBuilder();
        int flag = 0, m, n;
        int i = A.length - 1, j = B.length - 1;
        for (; i >= 0 && j >= 0; i--, j--) {
            m = A[i] - '0';
            n = B[j] - '0';
            flag += m + n;
            sb.insert(0, String.valueOf(flag % 2));
            flag /= 2;
        }
        while (i >= 0) {
            flag += A[i] - '0';
            sb.insert(0, String.valueOf(flag%2));
            flag /= 2;
            i--;
        }
        while (j >= 0) {
            flag += B[j] - '0';
            sb.insert(0, String.valueOf(flag%2));
            flag /= 2;
            j--;
        }
        if (flag > 0) {
            sb.insert(0, String.valueOf(flag));
        }
        return sb.toString();
    }
}
