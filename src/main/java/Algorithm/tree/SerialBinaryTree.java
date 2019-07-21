package Algorithm.tree;

import Algorithm.entity.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description: 二叉树的序列化和反序列化
 * @Auther: kun
 * @Date: 2019-07-21 15:16
 */
public class SerialBinaryTree {

    /**
     * 层次遍历实现二叉树的序列化
     *
     * @param head
     * @return
     */
    public String serialByLevel(TreeNode head) {
        if (head == null) {
            return "#!";
        }
        String res = head.value + "!";
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(head);
        while (!queue.isEmpty()) {
            head = queue.poll();
            if (head.left != null) {
                res += head.left.value + "!";
                queue.offer(head.left);
            } else {
                res += "#!";
            }
            if (head.right != null) {
                res += head.right.value + "!";
                queue.offer(head.right);
            } else {
                res += "#!";
            }
        }
        return res;
    }

    /**
     * 二叉树的反序列化
     *
     * @param levelStr
     * @return
     */
    public TreeNode reconByLevelString(String levelStr) {
        String[] values = levelStr.split("!");
        int index = 0;
        TreeNode head = generateNodeByString(values[index++]);
        Queue<TreeNode> queue = new LinkedList<>();
        if (head != null) {
            queue.offer(head);
        }
        TreeNode node;
        while (!queue.isEmpty()) {
            node = queue.poll();
            node.left = generateNodeByString(values[index++]);
            node.right = generateNodeByString(values[index++]);
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        return head;
    }

    public TreeNode generateNodeByString(String val) {
        if (val.equals("#")) {
            return null;
        }
        return new TreeNode(Integer.valueOf(val));
    }


}
