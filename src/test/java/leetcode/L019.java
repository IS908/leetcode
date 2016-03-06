package leetcode;

import org.junit.Test;

/**
 * Created by kevin on 2016/3/2.
 */
public class L019 {
    @Test
    public void test() {
        L019_RemoveNthNodFromEndOfList l019 = new L019_RemoveNthNodFromEndOfList();
        ListNode head = new ListNode(1);
        ListNode p = head;
        for (int i = 2; i < 6; i++) {
            p.next = new ListNode(i);
            p = p.next;
        }
        l019.removeNthFromEnd(head, 2);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
