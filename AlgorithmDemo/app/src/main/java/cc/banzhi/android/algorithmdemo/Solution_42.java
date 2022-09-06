package cc.banzhi.android.algorithmdemo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: AlgorithmDemo
 * @description: 二叉树"Z"字遍历
 * @author: zoufengli01
 * @create: 2022/8/9 11:33
 **/
public class Solution_42 {

    private static class Node {
        Node left, right;
        int value;

        public Node(int value) {
            this.value = value;
        }
    }

    public List<List<Integer>> zigzagLevelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        LinkedList<Node> queue = new LinkedList<>();
        boolean isFromLeft = false;
        queue.offer(root);

        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node;
                if (isFromLeft) {
                    node = queue.pollFirst();
                } else {
                    node = queue.pollLast();
                }
                if (node == null) continue;
                list.add(node.value);
                if (isFromLeft) {
                    if (node.left != null) {
                        queue.offerLast(node.left);
                    }
                    if (node.right != null) {
                        queue.offerLast(node.right);
                    }
                } else {
                    if (node.right != null) {
                        queue.offerFirst(node.right);
                    }
                    if (node.left != null) {
                        queue.offerFirst(node.left);
                    }
                }
            }
            isFromLeft = !isFromLeft;
            res.add(list);
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

        Solution_42 solution_42 = new Solution_42();
        System.out.println(solution_42.zigzagLevelOrder(root));
    }
}
