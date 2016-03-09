package leetcode;

/**
 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
 * <p/>
 * For example,
 * Given 1->2->3->3->4->4->5, return 1->2->5.
 * Given 1->1->1->2->3, return 2->3.
 * <p/>
 * Created by kevin on 2016/3/8.
 */
public class L082_RemoveDuplicatesFromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0), p = dummy;
        while(head != null) {
            int val = head.val;
            if (head.next != null && head.next.val == val) {// if we have duplicates in pair of values
                head = head.next; //get on last duplicate in pair of values
                while(head != null && head.val == val) head = head.next; // iteratively we get the next value
            } else {
                p.next = head; // head points to unique value
                p = p.next;
                head = head.next;
            }
        }
        p.next = null; //cut off the chain of nodes within original linked list
        return dummy.next;
    }
}
