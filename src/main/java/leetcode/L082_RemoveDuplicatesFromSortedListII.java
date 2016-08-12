package leetcode;

import leetcode.Utils.ListNode;

import java.util.HashSet;

/**
 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
 * <p/>
 * For example,
 * Given 1->2->3->3->4->4->5, return 1->2->5.
 * Given 1->1->1->2->3, return 2->3.
 * <p/>
 * Created by kevin on 2016/3/8.
 */
@Deprecated
public class L082_RemoveDuplicatesFromSortedListII {
    // TODO: 16-8-12 比较巧妙，建议多推敲下
    // 参照讨论区的解决方案
    public ListNode deleteDuplicates1(ListNode head) {
        ListNode newHead = new ListNode(0);
        ListNode cur = newHead;
        ListNode next = head;
        ListNode following = null;
        while (next != null) {
            following = next.next;
            if (following == null || next.val != following.val) {
                cur.next = next;
                cur = cur.next;
                cur.next = null;
            } else {
                while (following != null && following.val == next.val) {
                    following = following.next;
                }
            }
            next = following;
        }
        return newHead.next;
    }

    // 用 HashSet 比较低效
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode cur = head;
        HashSet<Integer> set = new HashSet<>();
        while (cur.next != null) {
            if (cur.val == cur.next.val) set.add(cur.val);
            cur = cur.next;
        }

        while (head != null && set.contains(head.val)) {
            head = head.next;
        }

        if (head == null || head.next == null) return head;

        cur = head;
        ListNode next = cur.next;

        while (next != null) {
            boolean flag = set.contains(next.val);
            while (flag && next != null && next.next != null) {
                next = next.next;
                flag = set.contains(next.val);
            }
            if (flag) {
                cur.next = null; // next == null
                break;
            } else {
                cur.next = next;
                cur = cur.next;
                next = next.next;
            }
        }

        return head;
    }
}
