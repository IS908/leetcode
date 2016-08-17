package saima;

import java.util.Scanner;

/**
 * 求前 n 项数列的和
 * <p>
 * Created by kevin on 16-8-17.
 */
public class Main2 {
    public static void main(String args[]) {
        int m;
        double sum, n;
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            n = sc.nextInt();
            m = sc.nextInt();
            sum = 0;
            for (int i = 0; i < m; i++) {
                sum = sum + n;
                n = Math.sqrt(n);
            }
            System.out.printf("%.2f", sum);
            System.out.println();
        }
    }
}
