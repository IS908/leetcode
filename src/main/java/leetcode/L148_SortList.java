package leetcode;

import leetcode.Utils.ListNode;

/**
 * Sort a linked list in O(n log n) time using constant space complexity.
 * <p/>
 * Created by kevin on 2016/4/13.
 * 链表 模拟 归并排序
 */
@Deprecated
public class L148_SortList {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode slow = head, fast = head, pre = head;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null;
        return merge(sortList(head), sortList(slow));
    }

    private ListNode merge(ListNode node1, ListNode node2) {
        if (node1 == null)  return node2;
        if (node2 == null)  return node1;
        if (node1.val <= node2.val) {
            node1.next = merge(node1.next, node2);
            return node1;
        } else {
            node2.next = merge(node1, node2.next);
            return node2;
        }
    }
}
