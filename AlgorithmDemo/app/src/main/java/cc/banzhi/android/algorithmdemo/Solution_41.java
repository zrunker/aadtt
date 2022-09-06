package cc.banzhi.android.algorithmdemo;

/**
 * @program: AlgorithmDemo
 * @description: 力扣 剑指 Offer 55 - II. 平衡二叉树
 * @author: zoufengli01
 * @create: 2022/8/9 11:13
 **/
public class Solution_41 {

    private static class Node {
        Node left, right;
        int value;

        public Node(int value) {
            this.value = value;
        }
    }

    public boolean isBalanced(Node root) {
        return maxDepth(root) != -1;
    }

    // 后序遍历
    private int maxDepth(Node root) {
        if (root == null) return 0;

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        if (left == -1 || right == -1 || Math.abs(right - left) > 1) {
            return -1;
        }
        return Math.max(left, right) + 1;
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

        Solution_41 solution_41 = new Solution_41();
        System.out.println(solution_41.isBalanced(root));
    }
}
