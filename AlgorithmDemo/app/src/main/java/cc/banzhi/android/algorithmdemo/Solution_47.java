package cc.banzhi.android.algorithmdemo;

/**
 * @program: AlgorithmDemo
 * @description: 力扣 237. 删除链表中的节点
 * @author: zoufengli01
 * @create: 2022/8/9 20:44
 **/
public class Solution_47 {

    private static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public void deleteNode(Node node) {
        if (node == null) return;

        if (node.next == null) {
            node = null;
            return;
        }

        node.value = node.next.value;
        node.next = node.next.next;
    }

    public static void main(String[] args) {
        Node head = new Node(3);
        Node node = new Node(2);
        Node node1 = new Node(0);
        Node node2 = new Node(-4);
        head.next = node;
        node.next = node1;
        node1.next = node2;
        node2.next = node;

        Solution_47 solution_47 = new Solution_47();
        solution_47.deleteNode(node1);
        System.out.println(head);
    }
}
