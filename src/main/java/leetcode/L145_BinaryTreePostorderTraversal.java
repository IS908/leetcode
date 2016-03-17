package leetcode;

import leetcode.Utils.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given a binary tree, return the postorder traversal of its nodes' values.
 * <p/>
 * For example:
 * Given binary tree {1,#,2,3},
 * 1
 * \
 * 2
 * /
 * 3
 * return [3,2,1].
 * <p/>
 * Created by kevin on 16-3-17.
 */
public class L145_BinaryTreePostorderTraversal {
    /**
     * 非递归实现 后序遍历
     * (不同于前序、中序遍历，后序遍历需要有一个标志量标记节点是访问还是继续压栈)
     * 需要仔细琢磨一下
     *
     * @param root
     * @return
     */
    @Deprecated
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        TreeNode pre = node;    // 记录当前节点的右子树是否被访问过，若访问过则该节点的左子树、右子树都被访问到了，可以访问该节点了
        boolean flag = true;    // 指示是否沿着该节点的左子树压栈
        while (node != null || !stack.empty()) {
            if (node != null && flag) {
                stack.push(node);
                node = node.left;
            } else {
                if (stack.empty()) return list;
                node = stack.peek();
                if (node.right != null && node.right != pre) {
                    node = node.right;
                    flag = true;
                } else {
                    node = stack.pop();
                    list.add(node.val);
                    flag = false;
                    pre = node;
                }
            }
        }
        return list;
    }

    /**
     * 递归实现 后序遍历
     *
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal01(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        postorderTraversalTree(root, list);
        return list;
    }

    private void postorderTraversalTree(TreeNode node, List<Integer> list) {
        if (node == null) return;
        postorderTraversalTree(node.left, list);
        postorderTraversalTree(node.right, list);
        list.add(node.val);
    }
}
