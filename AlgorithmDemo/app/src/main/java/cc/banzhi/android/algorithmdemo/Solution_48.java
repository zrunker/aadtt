package cc.banzhi.android.algorithmdemo;

/**
 * @program: AlgorithmDemo
 * @description: 力扣 剑指 Offer II 024. 反转链表
 * @author: zoufengli01
 * @create: 2022/8/9 21:51
 **/
public class Solution_48 {

    private static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public Node reverseList(Node head) {
        if (head == null) return null;
        if (head.next == null) {
            return head;
        }

        Node preNode = null;
        while (head != null) {
            Node next = head.next;
            head.next = preNode;
            preNode = head;
            head = next;
        }

        return preNode;
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

        Solution_48 solution_48 = new Solution_48();
        System.out.println(solution_48.reverseList(head));
    }
}
