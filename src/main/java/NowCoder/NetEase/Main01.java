package NowCoder.NetEase;

import java.util.Scanner;

/**
 * Created by kevin on 16-8-6.
 */
public class Main01 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int res = countSteps(N);
        System.out.println(res);
    }

    public static int countSteps(int n) {
        int pre = 0, cur = 1, next;
        if (n < pre) {
            return pre - n;
        }
        while (n > cur) {
            next = pre + cur;
            pre = cur;
            cur = next;
        }

        return Math.min(n - pre, cur - n);
    }
}
