package leetcode;

import leetcode.Utils.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given a binary tree, return the inorder traversal of its nodes' values.
 * <p/>
 * For example:
 * Given binary tree {1,#,2,3},
 * 1
 * \
 * 2
 * /
 * 3
 * return [1,3,2].
 * <p/>
 * Note: Recursive solution is trivial, could you do it iteratively?
 * <p/>
 * Created by kevin on 16-3-17.
 */
public class L094_BinaryTreeInorderTraversal {
    /**
     * 非递归实现 中序遍历
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                node = stack.pop();
                list.add(node.val);
                node = node.right;
            }
        }
        return list;
    }

    /**
     * 递归实现 中序遍历
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal01(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorderTraversalTree(root, list);
        return list;
    }

    private void inorderTraversalTree(TreeNode node, List<Integer> list) {
        if (node == null) return;
        inorderTraversalTree(node.left, list);
        list.add(node.val);
        inorderTraversalTree(node.right, list);
    }
}
