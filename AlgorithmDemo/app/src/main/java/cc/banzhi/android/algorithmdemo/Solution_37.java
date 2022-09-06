package cc.banzhi.android.algorithmdemo;

/**
 * @program: AlgorithmDemo
 * @description: 求二叉树中最大值
 * @author: zoufengli01
 * @create: 2022/8/9 10:11
 **/
public class Solution_37 {

    private static class Node {
        Node left, right;
        int value;

        public Node(int value) {
            this.value = value;
        }
    }

    public int getMax(Node root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        } else {
            return Math.max(root.value, Math.max(getMax(root.left), getMax(root.right)));
        }
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

        Solution_37 solution_37 = new Solution_37();
        System.out.println(solution_37.getMax(root));
    }
}
