package hihoCoder;

import java.util.Scanner;

/**
 * Created by kevin on 2016/4/19.
 */
public class N1000_SumAB {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int A, B;
        while (scan.hasNext()) {
            A = scan.nextInt();
            B = scan.nextInt();
            System.out.println(A + B);
            scan.nextLine();
        }
    }
}
