package cc.banzhi.android.algorithmdemo;

/**
 * @program: AlgorithmDemo
 * @description: 剑指 Offer 68 - I. 二叉搜索树的最近公共祖先
 * @author: zoufengli01
 * @create: 2022/8/13 17:47
 **/
public class Solution_60 {

    private static class Node {
        int val;
        Node left, right;

        public Node(int val) {
            this.val = val;
        }
    }

    public Node lowestCommonAncestor(Node root, Node p, Node q) {
        if (root == null) return null;

        if (p.val == root.val || q.val == root.val) {
            return root;
        }

        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return root;
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

        Solution_60 solution_60 = new Solution_60();
        System.out.println(solution_60.lowestCommonAncestor(root, left, right));
    }
}
