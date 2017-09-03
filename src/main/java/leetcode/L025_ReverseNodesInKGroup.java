package leetcode;

import leetcode.Utils.ListNode;

/**
 * Created by Kevin on 2017-08-29 19:47.
 */
@Deprecated
public class L025_ReverseNodesInKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        // TODO: 2017/9/3 好好理一理，用递归实现一把
        if (head == null) return head;
        ListNode first = new ListNode(0);
        ListNode newHead = first;
        first.next = head;
        ListNode pre, cur, next, tail;
        pre = first;
        cur = head;
        while (cur != null) {
            tail = cur;
            for (int i = 0; i < k && cur != null; i++) {
                next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }
            tail.next = pre;
        }
        return first.next;
    }

    /**
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup1(ListNode head, int k) {
        ListNode curr = head;
        int count = 0;
        while (curr != null && count != k) { // find the k+1 node
            curr = curr.next;
            count++;
        }
        if (count == k) { // if k+1 node is found
            curr = reverseKGroup(curr, k); // reverse list with k+1 node as head
            // head - head-pointer to direct part,
            // curr - head-pointer to reversed part;
            while (count-- > 0) { // reverse current k-group:
                ListNode tmp = head.next; // tmp - next head in direct part
                head.next = curr; // preappending "direct" head to the reversed list
                curr = head; // move head of reversed part to a new node
                head = tmp; // move "direct" head to the next node in direct part
            }
            head = curr;
        }
        return head;
    }
}
