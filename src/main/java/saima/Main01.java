package saima;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * 队列还原
 * <p>
 * Created by kevin on 16-8-17.
 */
public class Main01 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        for (int i = 0; i < num; i++) {
            getOriginal(in.nextInt());
        }
    }

    private static void getOriginal(int n) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(n);
        for (int i = n - 1; i > 0; i--) {
            int tmp = list.removeLast();
            list.addFirst(i);
            list.addFirst(tmp);
        }
        StringBuilder sb = new StringBuilder();
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            sb.append(it.next() + " ");
        }
        String str = sb.toString();
        System.out.println(str.substring(0, str.length() - 1));
    }
}
