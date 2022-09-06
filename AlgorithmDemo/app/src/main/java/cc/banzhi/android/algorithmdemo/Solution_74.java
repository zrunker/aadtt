package cc.banzhi.android.algorithmdemo;

import java.util.LinkedList;

/**
 * @program: AlgorithmDemo
 * @description: 力扣 230. 二叉搜索树中第K小的元素
 * @author: zoufengli01
 * @create: 2022/8/15 17:53
 **/
public class Solution_74 {

    private static class Node {
        int val;
        Node left, right;

        public Node(int val) {
            this.val = val;
        }
    }

    // 中序遍历，非递归
    public int kthSmallest(Node root, int k) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        LinkedList<Node> list = new LinkedList<>();
        int i = 0;
        while (!list.isEmpty() || root != null) {
            if (root != null) {
                list.add(root);
                root = root.left;
            } else {
                Node node = list.removeLast();
                i++;
                if (i == k) {
                    return node.val;
                }
                root = node.right;
            }
        }
        return Integer.MIN_VALUE;
    }

    public static void main(String[] args) {
        Node root = new Node(3);
        Node left = new Node(1);
        Node right = new Node(4);
        Node rLeft = new Node(2);
        root.left = left;
        root.right = right;
        left.right = rLeft;

        Solution_74 solution_74 = new Solution_74();
        System.out.println(solution_74.kthSmallest(root, 1));
    }
}
