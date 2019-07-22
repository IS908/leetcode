package Algorithm.tree;

import Algorithm.entity.TreeNode;

import java.util.Stack;

/**
 * @Description: // TODO
 * @Auther: kun
 * @Date: 2019-07-21 10:05
 */
public class VisitBinaryTree {

    /**
     * 二叉树的前序遍历（递归实现）
     *
     * @param root
     */
    public void preOrderRecur(TreeNode root) {
        if (root == null) {
            return;
        }
        visit(root);
        preOrderRecur(root.left);
        preOrderRecur(root.right);
    }

    /**
     * 二叉树的中序遍历（递归实现）
     *
     * @param root
     */
    public void inOrderRecur(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrderRecur(root.left);
        visit(root);
        inOrderRecur(root.right);
    }

    /**
     * 二叉树的后续遍历（递归实现）
     *
     * @param root
     */
    public void postOrderRecur(TreeNode root) {
        if (root == null) {
            return;
        }
        postOrderRecur(root.left);
        postOrderRecur(root.right);
        visit(root);
    }

    /**
     * 二叉树的前序遍历（非递归实现）
     *
     * @param root
     */
    public void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            visit(node);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
    }

    /**
     * 二叉树的中序遍历（非递归实现）
     *
     * @param root
     */
    public void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            visit(cur);
            cur = cur.right;
        }
    }

    /**
     * 二叉树的中序遍历（非递归实现）
     *
     * @param root
     */
    public void inOrderUnRecur(TreeNode root) {
        System.out.print("in-order: ");
        if (root != null) {
            Stack<TreeNode> stack = new Stack<>();
            while (!stack.isEmpty() || root != null) {
                if (root != null) {
                    stack.push(root);
                    root = root.left;
                } else {
                    root = stack.pop();
                    System.out.print(root.value + " ");
                    root = root.right;
                }
            }
        }
        System.out.println();
    }

    /**
     * 二叉树的后序遍历（非递归实现）
     * 方式1：用两个栈实现
     *
     * @param root
     */
    public void postOrderUnRecur1(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(root);
        while (!stack1.isEmpty()) {
            TreeNode node = stack1.pop();
            stack2.push(node);
            if (node.left != null) {
                stack1.push(node.left);
            }
            if (node.right != null) {
                stack1.push(node.right);
            }
        }
        while (!stack2.isEmpty()) {
            visit(stack2.pop());
        }
    }

    /**
     * 二叉树的后序遍历（非递归实现）
     * 方式2：用一个栈实现
     *
     * @param root
     */
    public void postOrderUnRecur2(TreeNode root) {
        System.out.print("pos-order: ");
        if (root != null) {
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            // c 代表stack的栈顶节点
            // h 代表最近一次弹出并访问的节点
            TreeNode c, h = root;
            while (!stack.isEmpty()) {
                c = stack.peek();
                if (c.left != null && h != c.left && h != c.right) {
                    stack.push(c.left);
                } else if (c.right != null && h != c.right) {
                    stack.push(c.right);
                } else {
                    visit(stack.pop());
                    h = c;
                }
            }
        }
        System.out.println();

    }

    /**
     * TODO 二叉树的中序神级遍历（时间复杂度为O(n)，空间复杂度为O(1)）
     *
     * @param head
     */
    public void morrisIn(TreeNode head) {
        if (head == null) {
            return;
        }
        TreeNode cur1 = head;
        TreeNode cur2 = null;
        while (cur1 != null) {
            cur2 = cur1.left;
            if (cur2 != null) {
                while (cur2.right != null && cur2.right != cur1) {
                    cur2 = cur2.right;
                }
                if (cur2.right == null) {
                    cur2.right = cur1;
                    cur1 = cur1.left;
                    continue;
                } else {
                    cur2.right = null;
                }
            }
            visit(cur1);
            cur1 = cur1.right;
        }
        System.out.println();
    }

    /**
     * TODO 二叉树的先序神级遍历（时间复杂度为O(n)，空间复杂度为O(1)）
     *
     * @param head
     */
    public void morrisPre(TreeNode head) {
        if (head == null) {
            return;
        }
        TreeNode cur1 = head;
        TreeNode cur2 = null;
        while (cur1 != null) {
            cur2 = cur1.left;
            if (cur2 != null) {
                while (cur2.right != null && cur2.right != cur1) {
                    cur2 = cur2.right;
                }
                if (cur2.right == null) {
                    cur2.right = cur1;
                    System.out.print(cur1.value + " ");
                    cur1 = cur1.left;
                    continue;
                } else {
                    cur2.right = null;
                }
            } else {
                visit(cur1);
            }
            cur1 = cur1.right;
        }
        System.out.println();
    }

    /**
     * TODO 二叉树的后序神级遍历（时间复杂度为O(n)，空间复杂度为O(1)）
     *
     * @param head
     */
    public void morrisPos(TreeNode head) {
        if (head == null) {
            return;
        }
        TreeNode cur1 = head;
        TreeNode cur2 = null;
        while (cur1 != null) {
            cur2 = cur1.left;
            if (cur2 != null) {
                while (cur2.right != null && cur2.right != cur1) {
                    cur2 = cur2.right;
                }
                if (cur2.right == null) {
                    cur2.right = cur1;
                    cur1 = cur1.left;
                    continue;
                } else {
                    cur2.right = null;
                    printEdge(cur1.left);
                }
            }
            cur1 = cur1.right;
        }
        printEdge(head);
        System.out.println();
    }

    public void printEdge(TreeNode head) {
        TreeNode tail = reverseEdge(head);
        TreeNode cur = tail;
        while (cur != null) {
            visit(cur);
            cur = cur.right;
        }
        reverseEdge(tail);
    }

    public TreeNode reverseEdge(TreeNode from) {
        TreeNode pre = null;
        TreeNode next = null;
        while (from != null) {
            next = from.right;
            from.right = pre;
            pre = from;
            from = next;
        }
        return pre;
    }


    public void visit(TreeNode node) {
        // 此处进行Node节点的访问
        System.out.println(node.value);
    }
}
