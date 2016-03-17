package leetcode.Utils;

/**
 * Created by kevin on 2016/3/2.
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public void print() {
        if (this.next == null) {
            System.out.println(this.val);
            return;
        }
        ListNode tmp = this;
        while (tmp.next != null) {
            System.out.print(tmp.val + "->");
            tmp = tmp.next;
        }
        System.out.println(tmp.val);
    }
}
