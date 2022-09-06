package cc.banzhi.android.algorithmdemo;

import java.util.HashMap;

/**
 * @program: AlgorithmDemo
 * @description: 力扣 146. LRU 缓存
 * @author: zoufengli01
 * @create: 2022/8/7 09:31
 **/
public class LRUCache {

    private static class Node {
        int key;
        int value;
        Node prevNode;
        Node nextNode;

        public Node() {
            super();
        }

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final Node headNode = new Node();
    private final Node tailNode = new Node();
    private final HashMap<Integer, Node> map = new HashMap<>();
    private final int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.headNode.nextNode = tailNode;
        this.tailNode.prevNode = headNode;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node node = map.get(key);
        if (node == null) {
            map.remove(key);
            return -1;
        }
        node.prevNode.nextNode = node.nextNode;
        node.nextNode.prevNode = node.prevNode;
        moveToTail(node);
        return node.value;
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        if (node == null) {
            node = new Node(key, value);
        } else {
            node.value = value;
        }
        map.put(key, node);

        while (map.size() > capacity) {
            Node item = headNode.nextNode;
            headNode.nextNode = headNode.nextNode.nextNode;
            headNode.nextNode.prevNode = headNode;
            map.remove(item.key);
        }

        moveToTail(node);
    }

    private void moveToTail(Node node) {
        node.prevNode = tailNode.prevNode;
        node.nextNode = tailNode;
        tailNode.prevNode.nextNode = node;
        tailNode.prevNode = node;
    }
}
