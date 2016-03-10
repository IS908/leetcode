package leetcode;

/**
 * Given a list, rotate the list to the right by k places, where k is non-negative.
 * <p/>
 * For example:
 * Given 1->2->3->4->5->NULL and k = 2,
 * return 4->5->1->2->3->NULL.
 * <p/>
 * Created by kevin on 2016/3/9.
 */
public class L061_RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k <= 0)
            return head;

        ListNode tail = head;
        int len = 1;//
        while (tail.next != null) {// 计算表长并找到尾结点，使其next域指向第一个节点
            len++;
            tail = tail.next;
        }
        tail.next = head;//
        k = k % len;// k可能是比链表长度要大的数字，因此实际旋转的位置就是k%len;
        ListNode p = head;
        for (int i = 0; i < len - k - 1; i++)
            p = p.next; // 找到第n-k个结点

        head = p.next;// 断链
        p.next = null;
        return head;

        /*if (k == 0 || head == null) return head;
        ListNode p, q;
        p = head;
        q = p;
        while (p.next != null) {
            if (k>0) {
                k--;
            } else {
                q = q.next;
            }
            p = p.next;
        }
        p.next = head;
        head = q.next;
        q.next = null;
        return head;*/
    }
}
