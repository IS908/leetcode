package leetcode;

import leetcode.Utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary tree, find its maximum depth.
 * <p/>
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 * <p/>
 * Created by kevin on 2016/4/2.
 */
public class L104_MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        return getMaxDepth(root);
    }

    /**
     * 层次遍历求树的最大深度
     * @param root
     * @return
     */
    private int getMaxDepth(TreeNode root) {
        int depth = 0, len;
        if (root == null) return depth;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            len = queue.size();
            while (len-- > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            depth++;
        }
        return depth;
    }
}
