package leetcode;

import leetcode.Utils.ListNode;

/**
 * Sort a linked list using insertion sort.
 * Subscribe to see which companies asked this question
 * <p/>
 * Created by kevin on 2016/4/11.
 */
public class L147_InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode sortedHead = head, sortedTail = head;
        head = head.next;
        sortedHead.next = null;

        while (head != null) {
            ListNode tmp = head;
            head = head.next;
            tmp.next = null;
            if (tmp.val <= sortedHead.val) {
                tmp.next = sortedHead;
                sortedHead = tmp;
            } else if (tmp.val >= sortedTail.val) {
                sortedTail.next = tmp;
                sortedTail = tmp;
            } else {
                ListNode node = sortedHead;
                while (node.next != null) {
                    if (tmp.val > node.val && tmp.val <= node.next.val) {
                        tmp.next = node.next;
                        node.next = tmp;
                        break;
                    }
                    node = node.next;
                }
            }
        }
        return sortedHead;
    }
}
