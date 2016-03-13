package leetcode;

import leetcode.Utils.ListNode;

/**
 * 快慢指针解法
 * <p/>
 * Given a linked list, remove the nth node from the end of list and return its head.
 * <p/>
 * Created by kevin on 2016/3/2.
 */
public class L019_RemoveNthNodFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }

        ListNode fast = head;
        ListNode slow = head;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        if (fast == null) {
            head = head.next;
            return head;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;

        return head;
    }
}

