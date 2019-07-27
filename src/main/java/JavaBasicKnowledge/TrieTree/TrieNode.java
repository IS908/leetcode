package JavaBasicKnowledge.TrieTree;

/**
 * Trie树
 * <p/>
 * Created by kevin on 2016/3/15.
 */
public class TrieNode {

    // 表示多少个单词公用这个节点
    public int path;
    // 表示多少个单词以这个节点结尾
    public int end;

    public TrieNode[] map;

    public TrieNode() {
        path = 0;
        end = 0;
        map = new TrieNode[26];
    }

}
