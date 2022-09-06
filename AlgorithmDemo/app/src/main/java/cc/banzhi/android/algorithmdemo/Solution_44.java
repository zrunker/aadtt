package cc.banzhi.android.algorithmdemo;

/**
 * @program: AlgorithmDemo
 * @description: 力扣 剑指 Offer II 022. 链表中环的入口节点
 * @author: zoufengli01
 * @create: 2022/8/9 18:56
 **/
public class Solution_44 {

    private static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public Node detectCycle(Node head) {
        if (head == null) return null;

        boolean isCycle = false;
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                isCycle = true;
                break;
            }
        }

        if (!isCycle) return null;

        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
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

        Solution_44 solution_44 = new Solution_44();
        System.out.println(solution_44.detectCycle(head));
    }
}
