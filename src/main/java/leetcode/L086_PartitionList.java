package leetcode;

import leetcode.Utils.ListNode;

/**
 * Created by kevin on 16-10-4.
 */
public class L086_PartitionList {
    public ListNode partition(ListNode head, int x) {
        ListNode left = new ListNode(0);
        ListNode right = new ListNode(0);

        ListNode leftNode = left, rightNode = right;
        while (head != null) {
            if (head.val < x) {
                leftNode.next = head;
                head = head.next;
                leftNode = leftNode.next;
                leftNode.next = null;
            } else {
                rightNode.next = head;
                head = head.next;
                rightNode = rightNode.next;
                rightNode.next = null;
            }
        }
        leftNode.next = right.next;
        return left.next;
    }
}
