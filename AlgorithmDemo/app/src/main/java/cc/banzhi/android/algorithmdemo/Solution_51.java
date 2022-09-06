package cc.banzhi.android.algorithmdemo;

/**
 * @program: AlgorithmDemo
 * @description: 力扣 剑指 Offer II 077. 链表排序 - 快速排序
 * @author: zoufengli01
 * @create: 2022/8/10 00:21
 **/
public class Solution_51 {

    private static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public Node sortList(Node head) {
        if (head == null || head.next == null) return head;

        Node nNode = head;
        while (head != null) {
            Node minNode = head;
            Node right = head.next;

            while (right != null) {
                if (right.value >= minNode.value) {
                    right = right.next;
                } else {
                    minNode = right;
                }
            }

            int temp = minNode.value;
            minNode.value = head.value;
            head.value = temp;

            head = head.next;
        }
        return nNode;
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

        Solution_51 Solution_51 = new Solution_51();
        System.out.println(Solution_51.sortList(head));
    }
}
