package Algorithm.tree;

import Algorithm.entity.TreeNode;

import java.util.HashMap;

/**
 * @Description: 在二叉树中找到累加和为指定值的最长路径长度
 * <p>
 * 给定一棵二叉树的头节点head和一个32位整数sum，二叉树节点值类型为整型，求累加和为sum的最长路径长度。
 * 路径是指从某个节点往下，每次最多选择一个孩子节点或者不选所形成的节点链。
 * @Auther: kun
 * @Date: 2019-07-21 18:09
 */
public class MaxSubRode {

    // 思路参见 “求未排序数组中累加和为规定值的最长子数组长度”

    public int getMaxLength(TreeNode head, int sum) {
        HashMap<Integer, Integer> sumMap = new HashMap<>();
        sumMap.put(0, 0); // 重要
        return preOrder(head, sum, 0, 1, 0, sumMap);
    }

    public int preOrder(TreeNode head, int sum, int preSum, int level, int maxLen, HashMap<Integer, Integer> sumMap) {
        if (head == null) {
            return maxLen;
        }
        int curSum = preSum + head.value;
        if (!sumMap.containsKey(curSum)) {
            sumMap.put(curSum, level);
        }
        if (sumMap.containsKey(curSum - sum)) {
            maxLen = Math.max(level - sumMap.get(curSum - sum), maxLen);
        }
        maxLen = preOrder(head.left, sum, curSum, level + 1, maxLen, sumMap);
        maxLen = preOrder(head.right, sum, curSum, level + 1, maxLen, sumMap);
        if (level == sumMap.get(curSum)) {
            sumMap.remove(curSum);
        }
        return maxLen;
    }

}
