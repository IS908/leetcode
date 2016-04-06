package hihoCoder;

import java.util.Scanner;

/**
 * 给出一棵二叉树的前序和中序遍历的结果，还原这棵二叉树并输出其后序遍历的结果。
 * <p/>
 * Created by kevin on 2016/4/6.
 */
public class N1049_PostOrder {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        char[] preorder = scan.nextLine().toCharArray();
        char[] inorder = scan.nextLine().toCharArray();
        if (preorder.length < 1 || preorder.length != inorder.length)  return;
        TreeNode root = getPostOrder(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
        StringBuilder sb = new StringBuilder();
        postOrder(root, sb);
        System.out.println(sb.toString());
    }

    private static TreeNode getPostOrder(char[] preorder, int p_s, int p_e, char[] inorder, int i_s, int i_e) {
        if (p_e < p_s) return null;
        char cur = preorder[p_s];
        int i = i_s;
        for (; i <= i_e; i++) {
            if (inorder[i] == cur) break;
        }
        int len = i - i_s;
        TreeNode node = new TreeNode(cur);
        node.left = getPostOrder(preorder, p_s + 1, p_s + len, inorder, i_s, i - 1);
        node.right = getPostOrder(preorder, p_s + len + 1, p_e, inorder, i + 1, i_e);
        return node;
    }

    private static void postOrder(TreeNode node, StringBuilder sb) {
        if (node.left == null && node.right == null) {
            sb.append(node.val);
            return;
        }
        if (node.left != null) postOrder(node.left, sb);
        if (node.right != null) postOrder(node.right, sb);
        sb.append(node.val);
    }
}

class TreeNode {
    public char val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(char x) {
        val = x;
    }
}
