package hihoCoder;

import java.util.Scanner;

/**
 * Trie树的构建及使用
 * Created by kevin on 2016/4/19.
 */
public class N1014_TrieTree {
    private static final int MAX_CHILDREN_NUM = 26;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        scan.nextLine();
        N1014_TrieTree trieTree = new N1014_TrieTree();
        TrieNode root = trieTree.buildTrie();
        for (int i = 0; i < num; i++) {
            String word = scan.nextLine().toLowerCase();
            trieTree.addWord(root, word);
        }
        int count = scan.nextInt();
        scan.nextLine();
        int[] res = new int[count];
        for (int i = 0; i < count; i++) {
            String word = scan.nextLine().toLowerCase();
            res[i] = trieTree.matchCount(root, word);
        }
        for (int i : res) {
            System.out.println(i);
        }
    }

    /**
     * 判断给定字符串或前缀串是否在树中，若在则返回以该字符串为前缀的树的匹配节点，若树中没有则返回null
     *
     * @param s
     * @return
     */
    public int matchCount(TrieNode root, String s) {
        if (s == null || s.length() < 1) return 0;
        TrieNode node = root;
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            if (node.nodes[index] == null) return 0;
            node = node.nodes[index];
        }
        return node.count;
    }

    /**
     * 创建Trie树
     */
    public TrieNode buildTrie() {
        TrieNode node = new TrieNode();
        return node;
    }

    /**
     * 向树中添加单词
     *
     * @param s 待添加的单词
     * @return 若树中没有该单词，则添加并返回true；若树中有该单词，则不添加返回false
     */
    public void addWord(TrieNode root, String s) {
        TrieNode node = root;
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            if (node.nodes[index] == null) {
                node.nodes[index] = new TrieNode();
            }
            node = node.nodes[index];
            node.count++;
        }
        node.exist = true;
    }

    private class TrieNode {
        int count;
        TrieNode[] nodes;
        boolean exist;

        public TrieNode() {
            count = 0;
            nodes = new TrieNode[MAX_CHILDREN_NUM];
            exist = false;
        }
    }
}


