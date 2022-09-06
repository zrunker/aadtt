package cc.banzhi.android.algorithmdemo;

/**
 * @program: AlgorithmDemo
 * @description: 力扣 141. 环形链表
 * @author: zoufengli01
 * @create: 2022/8/9 18:38
 **/
public class Solution_43 {

    private static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public boolean hasCycle(Node head) {
        if (head == null) return false;
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }
        return false;
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

        Solution_43 solution_43 = new Solution_43();
        System.out.println(solution_43.hasCycle(head));
    }
}
