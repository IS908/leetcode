package leetcode;

import leetcode.Utils.TreeNode;
import sun.reflect.generics.tree.Tree;

/**
 * Given two binary trees, write a function to check if they are equal or not.
 * <p/>
 * Two binary trees are considered equal if they are structurally identical and the nodes have the same value.
 * <p/>
 * Created by kevin on 2016/3/21.
 */
public class L100_SameTree {
    // 非递归版后续遍历方式检测
    public boolean isSameTree(TreeNode p, TreeNode q) {


        return false;
    }

    public boolean isSameTree01(TreeNode p, TreeNode q) {
        return preorderTravel(p, q);
    }

    // 递归先序遍历方式检测
    private boolean preorderTravel(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;
        return preorderTravel(p.left, q.left) && preorderTravel(p.right, q.right);
    }

    // 递归中序遍历方式检测
    private boolean inorderTravel(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (!preorderTravel(p.left, q.left)) return false;
        if (p.val != q.val) return false;
        return preorderTravel(p.right, q.right);
    }

    // 递归后序遍历方式检测
    private boolean postorderTravel(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (!preorderTravel(p.left, q.left)) return false;
        if (!preorderTravel(p.right, q.right)) return false;
        return p.val == q.val;
    }
}
