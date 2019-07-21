package leetcode;

import leetcode.Utils.ListNode;

/**
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 * <p/>
 * Created by kevin on 2016/3/3.
 */
public class L023_MergeKSortedLists {
    // 使用归并排序的思想合并链表
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }

        ListNode head = mergeKSortedList(lists, 0, lists.length - 1);
        return head;
    }

    // 归并排序的思想将链表合并
    private ListNode mergeKSortedList(ListNode[] lists, int left, int right) {
        if (left == right) {
            return lists[left];
        } else if (left + 1 >= right) {
            return mergeTwoLists(lists[left], lists[right]);
        }

        int mid = left + (right - left) / 2;
        ListNode list1 = mergeKSortedList(lists, left, mid);
        ListNode list2 = mergeKSortedList(lists, mid + 1, right);
        return mergeTwoLists(list1, list2);
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            if (l1 != null) {
                return l1;
            } else if (l2 != null) {
                return l2;
            } else {
                return null;
            }
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

    /**
     * 比较次数过多，该算法超时
     */
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

    /**
     * @param lists
     * @return
     */
    public ListNode mergeKLists02(ListNode[] lists) {
        Heap heap = new Heap(lists.length, lists);
        ListNode head = heap.getMin();
        ListNode tmp = head;
        while (tmp != null) {
            tmp.next = heap.getMin();
            tmp = tmp.next;
        }
        return head;
    }

    /**
     * 小顶堆
     */
    private static class Heap {
        ListNode[] heap;

        public Heap(int n, ListNode[] lists) {
            heap = new ListNode[n + 1];
            init(lists);
        }

        public void init(ListNode[] lists) {
            if (lists == null || lists.length < 1) {
                heap[0] = null;
                return;
            } else if (lists.length == 1) {
                heap[0] = lists[0];
                return;
            }
            for (int i = 0; i < lists.length; i++) {
                heap[i + 1] = lists[i];
            }
            for (int i = lists.length; i >= lists.length >> 1; i--) {
                shiftUp(i);
            }
        }

        public ListNode getMin() {
            heap[0] = heap[1];
            heap[1] = heap[1].next;
            shiftDown(1, heap.length - 1);
            return heap[0];
        }

        private void shiftUp(int end) {
            int son = end;
            while (son > 1) {
                int parent = son >>> 1;
                if (heap[son].val < heap[parent].val) {
                    swap(parent, son);
                }
                son = parent;
            }
        }

        private void shiftDown(int start, int end) {
            int parent = start;
            while (parent < end) {
                int left = parent >> 1;
                int right = left + 1;
                int min = left;
                if (right <= end) {
                    if (heap[left] != null && heap[right] != null) {
                        min = heap[left].val < heap[right].val ? left : right;
                    } else if (heap[right] != null) {
                        min = right;
                    }
                } else if (left > end) {
                    break;
                }
                if (min <= end) {
                    if (heap[parent] != null && heap[min] != null) {
                        if (heap[parent].val > heap[min].val) {
                            swap(parent, min);
                        }
                    } else if (heap[parent] != null) {
                        swap(parent, min);
                    }
                }
            }
        }

        private void swap(int left, int right) {
            ListNode tmp = heap[left];
            heap[left] = heap[right];
            heap[right] = tmp;
        }
    }

    public static void main(String[] args) {

    }
}
