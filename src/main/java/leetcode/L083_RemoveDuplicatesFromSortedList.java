package leetcode;

import leetcode.Utils.ListNode;

/**
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 * <p/>
 * For example,
 * Given 1->1->2, return 1->2.
 * Given 1->1->2->3->3, return 1->2->3.
 * <p/>
 * Created by kevin on 2016/3/8.
 */
// 换一种思路，相等时向后移动指针，不相等时将指针指向当前位置
public class L083_RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            ListNode next = cur.next;
            while (next != null && cur.val == next.val) {
                next = next.next;
            }
            cur.next = next;
            cur = cur.next;
        }
        return head;
    }
}
