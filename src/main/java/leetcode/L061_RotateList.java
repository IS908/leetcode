package leetcode;

/**
 * Given a list, rotate the list to the right by k places, where k is non-negative.
 * <p/>
 * For example:
 * Given 1->2->3->4->5->NULL and k = 2,
 * return 4->5->1->2->3->NULL.
 * <p/>
 * Created by kevin on 2016/3/9.
 */
public class L061_RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0) return head;
        ListNode p, q, r, s;
        p = head;
        q = p;
        r = head;
        while (p.next != null) {
            if (k>0) {
                q = p;
                r = q.next;
            }
            p = p.next;
            k--;
        }
        p.next = head;
        q.next = null;
        return r;
    }
}
