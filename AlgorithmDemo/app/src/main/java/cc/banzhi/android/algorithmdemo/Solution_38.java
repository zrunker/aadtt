package cc.banzhi.android.algorithmdemo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @program: AlgorithmDemo
 * @description: 力扣 剑指 Offer II 044. 二叉树每层的最大值
 * @author: zoufengli01
 * @create: 2022/8/9 10:22
 **/
public class Solution_38 {

    private static class Node {
        Node left, right;
        int value;

        public Node(int value) {
            this.value = value;
        }
    }

    public List<Integer> largestValues(Node root) {
        if (root == null) return null;
        List<Integer> res = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int max = Integer.MIN_VALUE;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                if (node == null) continue;
                max = Math.max(node.value, max);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            res.add(max);
        }
        return res;
    }

    public static void main(String[] args) {
        Node root = new Node(23);

        Node left = new Node(43);
        left.left = new Node(3);
        left.right = new Node(56);

        Node right = new Node(89);
        right.left = new Node(34);
        right.right = new Node(2);

        root.left = left;
        root.right = right;

        Solution_38 solution_38 = new Solution_38();
        System.out.println(solution_38.largestValues(root));
    }
}
