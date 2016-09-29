package leetcode;

import leetcode.Utils.ListNode;

import java.util.List;

/**
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 * <p/>
 * Created by kevin on 2016/3/3.
 */
public class L023_MergeKSortedLists {
    // 使用归并排序的思想合并链表
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        if (lists.length == 1) return lists[0];

        ListNode head = mergeKSortedList(lists, 0, lists.length - 1);
        return head;
    }

    // 归并排序的思想将链表合并
    private ListNode mergeKSortedList(ListNode[] lists, int left, int right) {
        if (left == right) return lists[left];
        else if (left + 1 >= right) return mergeTwoLists(lists[left], lists[right]);

        int mid = left + (right - left) / 2;
        ListNode list1 = mergeKSortedList(lists, left, mid);
        ListNode list2 = mergeKSortedList(lists, mid + 1, right);
        return mergeTwoLists(list1, list2);
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            if (l1 != null) return l1;
            else if (l2 != null) return l2;
            else return null;
        }
        ListNode head = new ListNode(-1);
        ListNode p = head;

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
        return head.next;
    }

    // 该算法超时
    public ListNode mergeKLists01(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        if (lists.length == 1) return lists[0];
        ListNode head, p, q;
        boolean flag = false;
        p = lists[0];
        int loc = 0, min = Integer.MAX_VALUE;
        for (int i = 1; i < lists.length; i++) {
            if (lists[i] != null) {
                if (lists[i].val < min) {
                    p = lists[i];
                    min = lists[i].val;
                    loc = i;
                }
                flag = true;
            } else {
                flag = false;
            }
        }
        head = p;
        q = p;
        if (flag) {
            lists[loc] = lists[loc].next;
        }

        while (q != null) {
            min = Integer.MAX_VALUE;
            for (int i = 1; i < lists.length; i++) {
                if (lists[i] != null) {
                    if (lists[i].val < min) {
                        q = lists[i];
                        min = lists[i].val;
                        loc = i;
                    }
                    flag = true;
                } else {
                    flag = false;
                }
            }
            if (flag) {
                p.next = q;
                p = q;
                q = q.next;
                lists[loc] = lists[loc].next;
            }
        }
        return head;
    }
}
