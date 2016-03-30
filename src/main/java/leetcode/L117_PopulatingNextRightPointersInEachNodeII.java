package leetcode;

import leetcode.Utils.TreeLinkNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by kevin on 2016/3/30.
 */
public class L117_PopulatingNextRightPointersInEachNodeII {
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
