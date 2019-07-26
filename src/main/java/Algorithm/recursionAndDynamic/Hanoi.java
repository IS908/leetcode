package Algorithm.recursionAndDynamic;

/**
 * @Description: 汉诺塔问题
 * @Auther: kun
 * @Date: 2019-07-25 17:49
 */
public class Hanoi {

    public void hanoi(int n) {
        if (n > 0) {
            func(n, "left", "mid", "right");
        }
    }

    public void func(int n, String from, String mid, String to) {
        if (n == 1) {
            System.out.println("move from " + from + " to " + to);
        } else {
            func(n - 1, from, to, mid);
            func(1, from, mid, to);
            func(n - 1, mid, from, to);
        }
    }

}
