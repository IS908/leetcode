package leetcode;

import leetcode.Utils.ListNode;

/**
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 * <p/>
 * Created by kevin on 2016/3/3.
 */
@Deprecated
public class L023_MergeKSortedLists {
    // 该算法超时
    public ListNode mergeKLists(ListNode[] lists) {
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

        /*if (lists == null || lists.length == 0) return null;
        if (lists.length == 1) return lists[0];
        ListNode head = lists[0];
        L021_MergeTwoSortedLists l021 = new L021_MergeTwoSortedLists();
        for (int i = 1; i < lists.length; i++) {
            head = l021.mergeTwoLists(head, lists[i]);
        }
        return head;*/
    }
}
