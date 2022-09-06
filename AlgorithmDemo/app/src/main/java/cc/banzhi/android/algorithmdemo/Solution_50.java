package cc.banzhi.android.algorithmdemo;

/**
 * @program: AlgorithmDemo
 * @description: 力扣 剑指 Offer II 077. 链表排序 - 归并排序
 * @author: zoufengli01
 * @create: 2022/8/9 22:19
 **/
public class Solution_50 {

    private static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public Node sortList(Node head) {
        if (head == null || head.next == null) return head;

        Node preNode = head, fast = head, slow = head;
        while (fast != null && fast.next != null) {
            preNode = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        preNode.next = null;

        Node mid = slow;

        Node left = sortList(head);
        Node right = sortList(mid);

        return merge(left, right);
    }

    private Node merge(Node left, Node right) {
        Node node = new Node(0);
        Node lastNode = node;

        while (left != null && right != null) {
            if (left.value < right.value) {
                lastNode.next = left;
                left = left.next;
            } else {
                lastNode.next = right;
                right = right.next;
            }
            lastNode = lastNode.next;
        }
        if (left != null) {
            lastNode.next = left;
        }
        if (right != null) {
            lastNode.next = right;
        }

        return node.next;
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

        Solution_50 solution_50 = new Solution_50();
        System.out.println(solution_50.sortList(head));
    }
}
