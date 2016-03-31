package leetcode.Utils;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by kevin on 16-3-17.
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    /**
     * 二叉树的层次遍历打印
     * @param t
     */
    public void print(TreeNode t) {
        if (t == null) {
            System.out.println("Empty Tree!");
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(t);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null){
                System.out.print("#->");
                continue;
            }
            System.out.print(node.val + "->");
            if (node.left == null && node.right == null)    continue;
            queue.offer(node.left);
            queue.offer(node.right);
        }
    }
}
