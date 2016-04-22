package Algorithm;

import java.util.Scanner;

/**
 * 打印1到最大的n位数
 * Created by kevin on 2016/4/20.
 */
public class printNCountsNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        printNCountsNumber print = new printNCountsNumber();
        char[] number = new char[num];
        for (int i = 0; i < number.length; i++) number[i] = '0';
        while (print.increment(number)) print.printNumber(number);
    }

    private boolean increment(char[] number) {
        int nTakeOver = 0;
        for (int i = number.length - 1; i >= 0; i--) {
            int tmp = number[i] - '0' + nTakeOver;
            if (i == number.length - 1) tmp++;
            if (tmp > 9) {
                if (i == 0) return false;
                number[i] = '0';
                nTakeOver = 1;
            } else {
                number[i] = (char) (tmp + '0');
                break;
            }
        }
        return true;
    }

    private void printNumber(char[] nums) {
        String number = String.valueOf(nums);
        int start = 0;
        while (number.charAt(start) == '0') start++;
        System.out.print(number.substring(start) + "\t");
        if (number.charAt(number.length() - 1) == '0') System.out.println();
    }
}
