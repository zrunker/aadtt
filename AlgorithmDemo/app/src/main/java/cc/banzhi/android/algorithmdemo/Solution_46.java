package cc.banzhi.android.algorithmdemo;

/**
 * @program: AlgorithmDemo
 * @description: 力扣 剑指 Offer 22. 链表中倒数第k个节点
 * @author: zoufengli01
 * @create: 2022/8/9 19:43
 **/
public class Solution_46 {

    private static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public Node getKthFromEnd(Node head, int k) {
        if (head == null) return null;

        Node fast = head;
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }

        Node slow = head;
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        return slow;
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

        Solution_46 solution_46 = new Solution_46();
        System.out.println(solution_46.getKthFromEnd(head, 2));
    }
}
