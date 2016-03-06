package leetcode;

/**
 * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
 * <p/>
 * Created by kevin on 2016/3/2.
 */
public class L021_MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            if (l1 != null) return l1;
            else if (l2 != null) return l2;
            else return null;
        }
        ListNode head, p;
        if (l1.val > l2.val) {
            head = l2;
            l2 = l2.next;
        } else {
            head = l1;
            l1 = l1.next;
        }
        p = head;
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                p.next = l2;
                p = p.next;
                l2 = l2.next;
            } else {
                p.next = l1;
                p = p.next;
                l1 = l1.next;
            }
        }
        while (l1 != null) {
            p.next = l1;
            p = p.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            p.next = l2;
            p = p.next;
            l2 = l2.next;
        }
        return head;
    }

}
