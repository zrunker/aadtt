package cc.banzhi.android.algorithmdemo;

/**
 * @program: AlgorithmDemo
 * @description: 力扣 剑指 Offer 68 - I. 二叉树的最近公共祖先
 * @author: zoufengli01
 * @create: 2022/8/12 22:46
 **/
public class Solution_59 {

    private static class Node {
        int val;
        Node left, right;

        public Node(int val) {
            this.val = val;
        }
    }

    public Node lowestCommonAncestor(Node root, Node p, Node q) {
        if (root == null) return null;

        if (root == q || root == p) return root;

        Node lSon = lowestCommonAncestor(root.left, p, q);
        Node rSon = lowestCommonAncestor(root.right, p, q);

        if (lSon == null) return rSon;
        if (rSon == null) return lSon;

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

        Solution_59 solution_59 = new Solution_59();
        System.out.println(solution_59.lowestCommonAncestor(root, left, right));
    }
}
