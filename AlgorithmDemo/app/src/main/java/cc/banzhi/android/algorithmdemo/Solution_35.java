package cc.banzhi.android.algorithmdemo;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: AlgorithmDemo
 * @description: 力扣 111. 二叉树的最小深度
 * @author: zoufengli01
 * @create: 2022/8/8 10:56
 **/
public class Solution_35 {

    private static class Node {
        Node left, right;
        int value;

        public Node(int value) {
            this.value = value;
        }
    }

    // DFS（递归）
    public int minDepth(Node root) {
        if (root == null) return 0;

        if (root.left != null && root.right != null) {
            return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
        }

        if (root.left == null) {
            return minDepth(root.right) + 1;
        }

        // root.right == null
        return minDepth(root.left) + 1;

//        int left = minDepth(root.left);
//        int right = minDepth(root.right);
//
//        // 左侧深度到底
//        if (left == 0) {
//            return right + 1;
//        }
//
//        // 右侧深度到底
//        if (right == 0) {
//            return left + 1;
//        }
//
//        return Math.min(left, right) + 1;
    }

    // BFS（while）
    public int minDepth2(Node root) {
        if (root == null) return 0;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        int level = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                if (node == null) continue;
                // 到达叶子节点
                if (node.left == null && node.right == null) {
                    return level;
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            level++;
        }
        return level;
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

        Solution_35 solution_35 = new Solution_35();
        System.out.println(solution_35.minDepth(root));
        System.out.println("--------------");
        System.out.println(solution_35.minDepth2(root));
    }
}
