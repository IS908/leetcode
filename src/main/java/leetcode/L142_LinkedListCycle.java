package leetcode;

/**
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 * <p/>
 * Note: Do not modify the linked list.
 * <p/>
 * Follow up:
 * Can you solve it without using extra space?
 * <p/>
 * Created by kevin on 2016/3/11.
 */
@Deprecated
public class L142_LinkedListCycle {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null)  return null;
        ListNode fast, slow, tmp;
        fast = head;
        slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                tmp = head;
                while (slow != tmp) {
                    slow = slow.next;
                    tmp = tmp.next;
                }
                return slow;
            }
        }
        return null;
    }
}
