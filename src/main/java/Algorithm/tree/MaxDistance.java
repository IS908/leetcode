package Algorithm.tree;

import leetcode.Utils.TreeNode;

/**
 * @Description: 二叉树节点间的最大距离问题
 * @Auther: kun
 * @Date: 2019-07-25 10:40
 */
public class MaxDistance {

    public int maxDistance(TreeNode head) {
        int[] record = new int[1];
        return posOrder(head, record);
    }

    public int posOrder(TreeNode head, int[] record) {
        if (head == null) {
            record[0] = 0;
            return 0;
        }
        int lMax = posOrder(head.left, record);
        int maxFromLeft = record[0];
        int rMax = posOrder(head.right, record);
        int maxFromRight = record[0];
        int curNodeMax = maxFromLeft + maxFromRight + 1;
        record[0] = Math.max(maxFromLeft, maxFromRight) + 1;
        return Math.max(Math.max(lMax, rMax), curNodeMax);
    }

}
