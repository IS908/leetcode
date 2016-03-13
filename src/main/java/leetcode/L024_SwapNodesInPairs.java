package leetcode;

import leetcode.Utils.ListNode;

/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 * <p/>
 * For example,
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 * <p/>
 * Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
 * <p/>
 * Created by kevin on 2016/3/10.
 */
@Deprecated
public class L024_SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newHead = head.next, a = head, b = head.next, c = null;
        while (b != null) {
            a.next = b.next;
            b.next = a;
            if (c != null) c.next = b;
            if (a.next == null) break;
            b = a.next.next;
            c = a;
            a = a.next;
        }
        return newHead;
    }
}
