package leetcode;

import leetcode.Utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary tree, find its minimum depth.
 * <p/>
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 * <p/>
 * Created by kevin on 2016/4/2.
 */
public class L111_MinimumDepthOfBinaryTree {
    public int minDepth(TreeNode root) {
        return getMinDepth(root);
    }

    /**
     * 层次遍历求树的最小深度
     * @param root
     * @return
     */
    private int getMinDepth(TreeNode root) {
        int depth = 0, len;
        if (root == null) return depth;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            len = queue.size();
            depth++;
            while (len-- > 0) {
                TreeNode node = queue.poll();
                if (node.left == null && node.right == null) return depth;
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
        }
        return depth;
    }
}
