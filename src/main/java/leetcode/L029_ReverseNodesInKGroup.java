package leetcode;

import leetcode.Utils.ListNode;

/**
 * Created by kevin on 16-10-7.
 */
@Deprecated //todo 头插法存在问题
public class L029_ReverseNodesInKGroup {

    /**
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup01(ListNode head, int k) {
        int len = getListLength(head);
        if (len < k || k <= 1) return head;
        ListNode newHead = new ListNode(0);
        newHead.next = null;

        ListNode cur = newHead, tmp = head.next, cur_group_tail = head, group_first_node;
        int num_of_group = len / k;

        while (num_of_group-- > 0) {
            cur_group_tail = head;
            for (int i = 0; i < k; i++) {
                head.next = cur.next;
                cur.next = head;
                if (tmp == null) break;
                head = tmp;
                tmp = tmp.next;
            }
            cur = cur_group_tail;
        }
        if(head != null) {
            cur_group_tail.next = head;
        }

        return newHead.next;
    }


    /**
     * 链表的部分就地逆置
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode prev = null,
                curr = head,
                temp = null,
                last_group_tail = null,
                group_first_node = null;

        int len = getListLength(head);
        if (len < k)
            return head;
        int num_of_groups = len / k;

        while (num_of_groups-- > 0) {
            group_first_node = curr;

            for (int i = 1; i <= k; ++i) {
                temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
            }

            if (last_group_tail == null) {
                last_group_tail = group_first_node;
                head = prev;
            } else {
                last_group_tail.next = prev;
                last_group_tail = group_first_node;
            }

            prev = null;
        }

        if (len % k != 0) {
            last_group_tail.next = curr;
        }

        return head;
    }

    public int getListLength(ListNode node) {
        int len = 0;
        while (node != null) {
            node = node.next;
            ++len;
        }
        return len;
    }
}
