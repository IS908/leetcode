package hihoCoder.MSTest;

import java.util.Scanner;

/**
 * Created by kevin on 2016/4/6.
 */
public class MS_FontSize {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int count = scan.nextInt();
        int N, P, W, H;
        for (int i = 0; i < count; i++) {
            N = scan.nextInt();
            P = scan.nextInt();
            W = scan.nextInt();
            H = scan.nextInt();
            int[] paragraph = new int[N];
            for (int j = 0; j < N; j++)
                paragraph[j] = scan.nextInt();
            int S = Math.min(W, H); // 字号大小
            while (S > 0) {
                int charPerRow = W / S;
                int linePerPage = H / S;
                int maxLine = P * linePerPage;
                int totalLine = 0;
                for (int m : paragraph)
                    totalLine += m / charPerRow + (m % charPerRow > 0 ? 1 : 0);
                if (totalLine <= maxLine) {
                    System.out.println(S);
                    break;
                }
                S--;
            }
        }
    }
}
