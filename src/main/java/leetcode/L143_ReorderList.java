package leetcode;

import leetcode.Utils.ListNode;

/**
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
 * reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
 * <p/>
 * You must do this in-place without altering the nodes' values.
 * <p/>
 * For example,
 * Given {1,2,3,4}, reorder it to {1,4,2,3}.
 * <p/>
 * Created by kevin on 2016/3/11.
 * <p/>
 * 题目要求without using extra space
 * 可以将链表从中间断开，然后将后半个链表reverse一下，再合并两个链表
 */
public class L143_ReorderList {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        int len = 1;
        ListNode curr = head, list;
        while (curr != null) {
            curr = curr.next;
            len++;
        }
        curr = head;
        for (int i = 1; i < len / 2; i++) {
            curr = curr.next;
        }

        // 翻转后半部分链表
        ListNode postList = revorseList(curr.next);
        curr.next = null;
        //head.print();

        // 合并两个链表
        mergeLists(head, postList);
        //head.print();
    }

    private void mergeLists(ListNode a, ListNode b) {
        if (b == null) return;
        ListNode curr_b = b;
        b = b.next;
        while (b != null) {
            curr_b.next = a.next;
            a.next = curr_b;
            a = curr_b.next;
            curr_b = b;
            b = b.next;
        }
        b = a.next;
        a.next = curr_b;
        curr_b.next = b;
    }

    private ListNode revorseList(ListNode list) {
        if (list == null || list.next == null) return list;
        ListNode p, q, r;
        p = list;
        q = list.next;
        list.next = null;
        while (q.next != null) {
            r = q.next;
            q.next = p;
            p = q;
            q = r;
            r = r.next;
        }
        q.next = p;
        //q.print();
        return q;
    }
}
