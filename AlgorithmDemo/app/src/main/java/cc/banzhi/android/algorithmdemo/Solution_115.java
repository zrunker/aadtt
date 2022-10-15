package cc.banzhi.android.algorithmdemo;

/**
 * @program: AlgorithmDemo
 * @description: 牛客 删除链表中重复的结点
 * @author: zoufengli01
 * @create: 2022/9/7 10:26
 **/
public class Solution_115 {

    private static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null || pHead.next == null) return pHead;

        ListNode dNode = new ListNode(-1);
        ListNode lastNode = dNode;

        while (pHead != null) {
            if (pHead.next != null && pHead.val == pHead.next.val) {
                while (pHead.next != null && pHead.val == pHead.next.val) {
                    pHead = pHead.next;
                }
                pHead = pHead.next;
            } else {
                lastNode.next = pHead;
                lastNode = lastNode.next;

                pHead = pHead.next;
            }
        }

        lastNode.next = null;

        return dNode.next;
    }

    public static void main(String[] args) {
        ListNode pHead = new ListNode(1);
        ListNode next_1 = new ListNode(2);
        ListNode next_2 = new ListNode(3);
        ListNode next_3 = new ListNode(3);
        ListNode next_4 = new ListNode(4);
        ListNode next_5 = new ListNode(4);
        ListNode next_6 = new ListNode(5);
        pHead.next = next_1;
        next_1.next = next_2;
        next_2.next = next_3;
        next_3.next = next_4;
        next_4.next = next_5;
        next_5.next = next_6;
        Solution_115 solution_115 = new Solution_115();
        solution_115.deleteDuplication(pHead);
    }
}
