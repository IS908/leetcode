package leetcode;

import leetcode.Utils.TreeLinkNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary tree
 * <p/>
 * struct TreeLinkNode {
 * TreeLinkNode *left;
 * TreeLinkNode *right;
 * TreeLinkNode *next;
 * }
 * Populate each next pointer to point to its next right node.
 * If there is no next right node, the next pointer should be set to NULL.
 * <p/>
 * Initially, all next pointers are set to NULL.
 * <p/>
 * Created by kevin on 2016/3/30.
 */
public class L116_PopulatingNextRightPointersInEachNode {
    public void connect(TreeLinkNode root) {
        if (root == null) return;
        Queue<TreeLinkNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeLinkNode node = queue.poll();
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
                if (i != size - 1) {
                    node.next = queue.peek();
                } else {
                    node.next = null;
                }
            }
        }
    }
}
