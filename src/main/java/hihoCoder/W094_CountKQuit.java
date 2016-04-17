package hihoCoder;

import java.util.Scanner;

/**
 * Created by kevin on 2016/4/17.
 */
public class W094_CountKQuit {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int count = scan.nextInt();
        scan.nextLine();
        int[][] nums = new int[count][2];
        for (int i = 0; i < count; i++) {
            nums[i][0] = scan.nextInt();
            nums[i][1] = scan.nextInt();
            scan.nextLine();
        }
        int res;
        for (int i = 0; i < count; i++) {
//            res = countKquit(nums[i][0], nums[i][1]);
            res = Josephus(nums[i][0], nums[i][1]);
            System.out.println(res);
        }
    }

    // 约瑟夫环最终优化解法
    private static int Josephus(int n, int k) {
        if (n < 2) return 0;
        int res = 0;
        if (n < k) {
            for (int i = 2; i <= n; i++) {
                res = (res + k) % i;
            }
            return res;
        }
        res = Josephus(n-n/k, k);
        if (res < n % k) {
            res = res - n % k + n;
        } else {
            res = res - n % k + (res - n % k) / (k-1);
        }
        return res;
    }

    // 约瑟夫环初步解法
    private static int quitOne(int n, int k) {
        if (n < 2) return 0;
        int count = 0;
        for (int i = 2; i <= n; i++) {
            count = (count + k) % i;
        }
        return count;
    }

    // 链表方式的解法
    private static int countKquit(int n, int k) {
        LinkedList head = new LinkedList(0);
        LinkedList node = head;
        for (int i = 1; i < n; i++) {
            node.next = new LinkedList(i);
            node = node.next;
        }
        node.next = head;
        node = head;
        int count = n, j = 1;
        while (count > 1) {
            j++;
            if (j == k) {
                node.next = node.next.next;
                count--;
                j = 1;
            }
            node = node.next;
        }
        return node.val;
    }

}

class LinkedList {
    int val;
    LinkedList next;

    public LinkedList(int val) {
        this.val = val;
    }
}
