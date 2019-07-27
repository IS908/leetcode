package Algorithm.string;

import JavaBasicKnowledge.TrieTree.TrieNode;

/**
 * @Description: 字典树（前缀树）的实现
 * <p>
 * 字典树又称为前缀树或Trie树，是处理字符串常见的数据结构。假设组成所有单词的字符仅是“a”~“z”，请实现字典树结构，并包含以下四个主要功能。
 * <p>
 * ● void insert（String word）：添加word，可重复添加。
 * <p>
 * ● void delete（String word）：删除word，如果word添加过多次，仅删除一个。
 * <p>
 * ● boolean search（String word）：查询word是否在字典树中。
 * <p>
 * ● int prefixNumber（String pre）：返回以字符串pre为前缀的单词数量。
 * @Auther: kun
 * @Date: 2019-07-27 15:21
 */
public class Trie {

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        if (word == null) {
            return;
        }
        char[] chs = word.toCharArray();
        TrieNode node = root;
        int index = 0;
        for (int i = 0; i < chs.length; i++) {
            index = chs[i] - 'a';
            if (node.map[index] == null) {
                node.map[index] = new TrieNode();
            }
            node = node.map[index];
            node.path++;
        }
        node.end++;
    }

    public void delete(String word) {
        if (search(word)) {
            char[] chs = word.toCharArray();
            TrieNode node = root;
            int index = 0;
            for (int i = 0; i < chs.length; i++) {
                index = chs[i] - 'a';
                if (node.map[index].path-- == 1) {
                    node.map[index] = null;
                    return;
                }
                node = node.map[index];
            }
            node.end--;
        }
    }

    public boolean search(String word) {
        if (word == null) {
            return false;
        }
        char[] chs = word.toCharArray();
        TrieNode node = root;
        int index = 0;
        for (int i = 0; i < chs.length; i++) {
            index = chs[i] - 'a';
            if (node.map[index] == null) {
                return false;
            }
            node = node.map[index];
        }
        return node.end != 0;
    }

    public int prefixNumber(String pre) {
        if (pre == null) {
            return 0;
        }
        char[] chs = pre.toCharArray();
        TrieNode node = root;
        int index = 0;
        for (int i = 0; i < chs.length; i++) {
            index = chs[i] - 'a';
            if (node.map[index] == null) {
                return 0;
            }
            node = node.map[index];
        }
        return node.path;
    }
}

