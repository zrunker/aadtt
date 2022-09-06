package cc.banzhi.android.algorithmdemo;

/**
 * @program: AlgorithmDemo
 * @description: 力扣 剑指 Offer 25. 合并两个排序的链表
 * @author: zoufengli01
 * @create: 2022/8/9 22:07
 **/
public class Solution_49 {

    private static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public Node mergeTwoLists(Node l1, Node l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        Node node = new Node(0);
        Node lastNode = node;

        while (l1 != null && l2 != null) {
            if (l1.value > l2.value) {
                lastNode.next = l2;
                l2 = l2.next;
            } else {
                lastNode.next = l1;
                l1 = l1.next;
            }
            lastNode = lastNode.next;
        }
        if (l1 != null) {
            lastNode.next = l1;
        }
        if (l2 != null) {
            lastNode.next = l2;
        }
        return node.next;
    }

    public static void main(String[] args) {
        Node l1 = new Node(0);
        Node node = new Node(1);
        Node node1 = new Node(2);
        Node node2 = new Node(3);
        l1.next = node;
        node.next = node1;
        node1.next = node2;
        node2.next = node;

        Node l2 = new Node(-4);
        l2.next = new Node(5);

        Solution_49 solution_49 = new Solution_49();
        System.out.println(solution_49.mergeTwoLists(l1, l2));
    }
}
