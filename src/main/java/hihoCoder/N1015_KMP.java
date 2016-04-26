package hihoCoder;

import java.util.Scanner;

/**
 * Created by kevin on 16-4-26.
 */
public class N1015_KMP {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        scan.nextLine();
        int[] res = new int[num];
        for (int i = 0; i < num; i++) {
            String partten = scan.nextLine();
            String str = scan.nextLine();
            res[i] = KMP(str, partten);
        }
        for (int i: res){
            System.out.println(i);
        }
    }

    private static int KMP(String ts, String ps) {
        char[] t = ts.toCharArray();
        char[] p = ps.toCharArray();
        int i = 0; // 主串的位置
        int j = 0; // 模式串的位置
        int[] next = getNext(ps);
        int count = 0;
        while (i < t.length) {
            if (j == p.length - 1 && t[i] == p[j]) {
                count++;
                j = 0;
            } else if (j == -1 || t[i] == p[j]) { // 当j为-1时，要移动的是i，当然j也要归0
                i++;
                j++;
            } else {
                // i不需要回溯了
                // i = i - j + 1;
                j = next[j]; // j回到指定位置
            }
        }
        return count;
    }

    private static int[] getNext(String ps) {
        char[] p = ps.toCharArray();
        int[] next = new int[p.length];
        next[0] = -1;
        int j = 0;
        int k = -1;
        while (j < p.length - 1) {
            if (k == -1 || p[j] == p[k]) {
                next[++j] = ++k;
            } else {
                k = next[k];
            }
        }
        return next;
    }

}
