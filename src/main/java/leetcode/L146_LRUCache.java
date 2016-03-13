package leetcode;

import java.util.HashMap;

/**
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.
 * <p/>
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * set(key, value) - Set or insert the value if the key is not already present.
 * When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
 * <p/>
 * Created by kevin on 2016/3/11.
 */
public class L146_LRUCache {
    private int capacity;
    private HashMap<Integer, Node> map;
    private Node head, tail;

    public L146_LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>(capacity);
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node tmp = map.get(key);
            putToHead(tmp);
            return tmp.val;
        }
        return -1;
    }

    public void set(int key, int value) {
        if (map.containsKey(key)) {
            Node tmp = map.get(key);
            tmp.val = value;
            putToHead(tmp);
            return;
        }
        if (map.size() == capacity) {
            removeEnd();
        }
        Node newNode = new Node(key, value);
        map.put(key, newNode);
        newNode.pre = head;
        newNode.next = head.next;
        head.next.pre = newNode;
        head.next = newNode;
    }

    private void removeEnd() {
        Node tmp = tail.pre;
        tmp.pre.next = tail;
        tmp.next.pre = tmp.pre;
        tmp.next = null;
        tmp.pre = null;
        map.remove(tmp.k);
    }

    private void putToHead(Node current) {
        if (head.next == current) return;
        current.pre.next = current.next;
        current.next.pre = current.pre;

        current.pre = head;
        current.next = head.next;
        head.next.pre = current;
        head.next = current;
    }
}

class Node {
    Node pre;
    Node next;
    int k;
    int val;

    Node(int k, int val) {
        this.k = k;
        this.val = val;
    }
}