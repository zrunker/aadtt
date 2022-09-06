package cc.banzhi.android.algorithmdemo;

/**
 * @program: AlgorithmDemo
 * @description: 力扣 剑指 Offer II 021. 删除链表的倒数第 n 个结点
 * @author: zoufengli01
 * @create: 2022/8/10 09:14
 **/
public class Solution_52 {

    private static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public Node removeNthFromEnd(Node head, int n) {
        if (head == null) return null;
        if (n <= 0) return head;

        Node fast = head;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        Node slow = head;
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        if (slow.next == null) {
            slow = null;
        } else {
            slow.value = slow.next.value;
            slow.next = slow.next.next;
        }
        return head;
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

        Solution_52 solution_52 = new Solution_52();
        System.out.println(solution_52.removeNthFromEnd(head, 2));
    }
}
