package Algorithm.tree;

import leetcode.Utils.TreeNode;

/**
 * @Description: 统计完全二叉树的节点数
 * @Auther: kun
 * @Date: 2019-07-23 22:35
 */
public class TreeCounter {

    public int nodeNum(TreeNode head) {
        if (head == null) {
            return 0;
        }
        return bs(head, 1, mostLeftLevel(head, 1));
    }

    public int bs(TreeNode node, int l, int h) {
        if (l == h) {
            return 1;
        }
        if (mostLeftLevel(node.right, l + 1) == h) {
            return (1 << (h - l)) + bs(node.right, l + 1, h);
        } else {
            return (1 << (h - l - 1)) + bs(node.left, l + 1, h);
        }
    }

    public int mostLeftLevel(TreeNode node, int level) {
        while (node != null) {
            level++;
            node = node.left;
        }
        return level - 1;
    }

}
