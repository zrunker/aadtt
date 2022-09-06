package cc.banzhi.android.algorithmdemo;

/**
 * @program: AlgorithmDemo
 * @description: 力扣 104. 二叉树的最大深度
 * @author: zoufengli01
 * @create: 2022/8/9 11:04
 **/
public class Solution_40 {

    private static class Node {
        Node left, right;
        int value;

        public Node(int value) {
            this.value = value;
        }
    }

    // DFS
    public int maxDepth(Node root) {
        if (root == null) return 0;

        if (root.left != null && root.right != null) {
            return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
        }
        if (root.left == null) {
            return maxDepth(root.right) + 1;
        }
        return maxDepth(root.left) + 1;
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

        Solution_40 solution_40 = new Solution_40();
        System.out.println(solution_40.maxDepth(root));
    }
}
