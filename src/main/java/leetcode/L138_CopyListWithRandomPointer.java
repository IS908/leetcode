//package leetcode;
//
//import leetcode.Utils.RandomListNode;
//
///**
// * Created by kevin on 16-10-7.
// */
//@Deprecated //// TODO: 16-10-7 思想：对每个node进行复制，并插入其原始node的后面，新旧交替，变成重复链表。对重复链表进行random链的复制
//public class L138_CopyListWithRandomPointer {
//    public RandomListNode copyRandomList(RandomListNode head) {
//        if (head == null) return null;
//        RandomListNode cur = head;
//        // 复制节点
//        while (cur != null) {
//            RandomListNode node = new RandomListNode(cur.label);
//            node.next = cur.next;
//            cur.next = node;
//            cur = node.next;
//        }
//
//        // random指针复制
//        cur = head;
//        while (cur != null) {
//            if (cur.random != null)
//                cur.next.random = cur.random.next;
//            cur = cur.next.next;
//        }
//
//        // 拆分两个链表
//        RandomListNode newHead = head.next;
//        cur = head;
//        while (cur != null) {
//            RandomListNode newNode = cur.next;
//            cur.next = newNode.next;
//            if (newNode.next != null)
//                newNode.next = newNode.next.next;
//            cur = cur.next;
//        }
//        return newHead;
//    }
//}
