package cc.banzhi.android.algorithmdemo;

/**
 * @program: AlgorithmDemo
 * @description: 力扣 876. 链表的中间结点
 * @author: zoufengli01
 * @create: 2022/8/9 19:14
 **/
public class Solution_45 {

    private static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public Node middleNode(Node head) {
        if (head == null) return null;

        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
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

        Solution_45 solution_45 = new Solution_45();
        System.out.println(solution_45.middleNode(head));
    }
}
