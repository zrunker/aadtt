package cc.banzhi.android.algorithmdemo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @program: AlgorithmDemo
 * @description: 二叉树 层次遍历 DFS/BFS
 * @author: zoufengli01
 * @create: 2022/8/8 09:14
 **/
public class Solution_34 {

    private static class Node {
        Node left, right;
        int value;

        public Node(int value) {
            this.value = value;
        }
    }

    public List<List<Integer>> dfs(Node root) {
        List<List<Integer>> list = new ArrayList<>();
        dfsLevel(root, list, 0);
        return list;
    }

    private void dfsLevel(Node root, List<List<Integer>> list, int level) {
        if (root == null) return;
        if (level == list.size()) {
            list.add(level, new ArrayList<>());
        }
        list.get(level).add(root.value);
        dfsLevel(root.left, list, level + 1);
        dfsLevel(root.right, list, level + 1);
    }

    public List<List<Integer>> bfs(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                if (node == null) continue;
                list.add(node.value);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
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

        Solution_34 solution_34 = new Solution_34();
        System.out.println(solution_34.dfs(root));
        System.out.println("--------------");
        System.out.println(solution_34.bfs(root));
    }
}
