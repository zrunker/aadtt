package cc.banzhi.android.algorithmdemo;

/**
 * @program: AlgorithmDemo
 * @description: 力扣 160. 相交链表
 * @author: zoufengli01
 * @create: 2022/8/10 09:48
 **/
public class Solution_53 {

    private static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public Node getIntersectionNode(Node headA, Node headB) {
        if (headA == null || headB == null) return null;

        int lengthA = 0;
        Node tempA = headA;
        while (tempA != null) {
            lengthA++;
            tempA = tempA.next;
        }

        int lengthB = 0;
        Node tempB = headB;
        while (tempB != null) {
            lengthB++;
            tempB = tempB.next;
        }

        Node startA = headA, startB = headB;
        while (lengthA > lengthB) {
            startA = startA.next;
            lengthA--;
        }
        while (lengthA < lengthB) {
            startB = startB.next;
            lengthB++;
        }

        while (startA != startB) {
            startA = startA.next;
            startB = startB.next;
        }

        return startA;
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

        Node headB = new Node(34);
        headB.next = node1;

        Solution_53 solution_53 = new Solution_53();
        System.out.println(solution_53.getIntersectionNode(head, headB));
    }
}
