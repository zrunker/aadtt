package cc.banzhi.android.algorithmdemo;

/**
 * @program: AlgorithmDemo
 * @description: 力扣 226. 翻转二叉树
 * @author: zoufengli01
 * @create: 2022/8/9 10:30
 **/
public class Solution_39 {

    private static class Node {
        Node left, right;
        int value;

        public Node(int value) {
            this.value = value;
        }
    }

    public Node invertTree(Node root) {
        if (root == null) return null;

        Node left = root.left;
        root.left = root.right;
        root.right = left;

        invertTree(root.left);
        invertTree(root.right);

        return root;
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

        Solution_39 solution_39 = new Solution_39();
        System.out.println(solution_39.invertTree(root));
    }
}
