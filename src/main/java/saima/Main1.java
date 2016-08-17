package saima;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 计算水仙花数
 * <p>
 * Created by kevin on 16-8-17.
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int start, end;
        List<List<Integer>> lists = new ArrayList<>();
        while (in.hasNext()) {
            start = in.nextInt();
            end = in.nextInt();
            lists.add(countNum(start, end));
        }

        for (List<Integer> list : lists) {
            if (list.size() <= 0) {
                System.out.println("no");
            } else {
                for (int tmp : list) {
                    System.out.print(tmp + " ");
                }
                System.out.println();
            }
        }
    }

    private static List<Integer> countNum(int start, int end) {
        List<Integer> result = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            if (check(i)) {
                result.add(i);
            }
        }
        return result;
    }

    private static boolean check(int n) {
        String num = String.valueOf(n);
        int sum = 0;
        for (int i = 0; i < num.length(); i++) {
            int tmp = num.charAt(i) - '0';
            sum += tmp * tmp * tmp;
        }
        return sum == n;
    }
}
