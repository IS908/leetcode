package leetcode;

import leetcode.Utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kevin on 2017-08-27 21:17.
 */
public class L655_PrintBinaryTree {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    public List<List<String>> printTree(TreeNode root) {
        if (root == null) return null;
        int h = high(root); // 高度
        int w = (2 << h) - 1; // 宽度
        List<List<String>> lists = new ArrayList<>();
        for (int floor = 0; floor < h - 1; floor++) {
            List<String> list = new ArrayList<>();

        }
        return lists;
    }

    private int high(TreeNode node) {
        if (node == null) return 0;
        int left = high(node.left);
        int right = high(node.right);
        return ((left > right) ? left : right) + 1;
    }
}
