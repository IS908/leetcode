package Algorithm;

import Algorithm.entity.Node;

import java.util.Stack;

/**
 * @Description: // TODO
 * @Auther: kun
 * @Date: 2019-07-20 15:57
 */
public class Algorithm {

    /**
     * 判断链表是否符合回文
     *
     * @param head
     * @return
     */
    public boolean isPalindrome1(Node head) {
        Stack<Node> stack = new Stack<Node>();
        Node cur = head;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        while (head != null) {
            if (head.value != stack.pop().value) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    /**
     * 判断链表是否符合回文
     *
     * @param head
     * @return
     */
    public boolean isPalindrome2(Node head) {
        if (head == null || head.next == null) {
            return true;
        }
        Node right = head.next;
        Node cur = head;
        while (cur.next != null && cur.next.next != null) {
            right = right.next;
            cur = cur.next.next;
        }
        Stack<Node> stack = new Stack<Node>();
        while (right != null) {
            stack.push(right);
            right = right.next;
        }
        while (!stack.isEmpty()) {
            if (head.value != stack.pop().value) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    /**
     * 判断链表是否符合回文，时间复杂度为O(n)，空间复杂度为O(1)
     *
     * @param head
     * @return
     */
    public boolean isPalindrome3(Node head) {
        if (head == null || head.next == null) {
            return true;
        }
        Node n1 = head;
        Node n2 = head;
        while (n2.next != null && n2.next.next != null) { // 查找中间节点
            n1 = n1.next; // n1 -> 中部
            n2 = n2.next.next; // n2 -> 结尾
        }
        n2 = n1.next; // n2 -> 右部分第一个节点
        n1.next = null; // mid.next -> null
        Node n3 = null;
        while (n2 != null) { // 右半区反转
            n3 = n2.next; // n3 -> 保存下一个节点
            n2.next = n1; // 下一个反转节点
            n1 = n2; // n1 移动
            n2 = n3; // n2 移动
        }
        n3 = n1; // n3 -> 保存最后一个节点
        n2 = head;// n2 -> 左边第一个节点
        boolean res = true;
        while (n1 != null && n2 != null) { // 检查回文
            if (n1.value != n2.value) {
                res = false;
                break;
            }
            n1 = n1.next; // 从左到中部
            n2 = n2.next; // 从右到中部
        }
        n1 = n3.next;
        n3.next = null;
        while (n1 != null) { // 恢复列表
            n2 = n1.next;
            n1.next = n3;
            n3 = n1;
            n1 = n2;
        }
        return res;
    }

}
