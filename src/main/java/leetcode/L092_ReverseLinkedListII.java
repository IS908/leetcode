package leetcode;

import leetcode.Utils.ListNode;

/**
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.
 * <p/>
 * For example:
 * Given 1->2->3->4->5->NULL, m = 2 and n = 4,
 * <p/>
 * return 1->4->3->2->5->NULL.
 * <p/>
 * Note:
 * Given m, n satisfy the following condition:
 * 1 ≤ m ≤ n ≤ length of list.
 * <p/>
 * Created by kevin on 2016/3/8.
 */
@Deprecated // 细节处理，很多边界检查，15分钟做到 bug free 很有难度
public class L092_ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode dummy = newHead;
        for (int i = 1; i < m; i++) dummy = dummy.next;

        ListNode pre = dummy.next, cur = pre.next;
        for (int j = m; j < n; j++) {   // 头插法实现翻转
            pre.next = cur.next;
            cur.next = dummy.next;
            dummy.next = cur;
            cur = pre.next;
        }
        return newHead.next;
    }
}
