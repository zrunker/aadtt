package cc.banzhi.android.algorithmdemo;

/**
 * @program: AlgorithmDemo
 * @description: 力扣 98. 验证二叉搜索树
 * @author: zoufengli01
 * @create: 2022/8/15 15:47
 **/
public class Solution_73 {

    private static class Node {
        int val;
        Node left, right;

        public Node(int val) {
            this.val = val;
        }
    }

    public boolean isValidBST(Node root) {
        return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public boolean isValidBST(Node root, int lower, int upper) {
        if (root == null) return true;
        if (lower >= root.val || upper <= root.val) {
            return false;
        }
        return isValidBST(root.left, lower, root.val)
                && isValidBST(root.right, root.val, upper);
    }

    public static void main(String[] args) {
        Node node = new Node(5);
        Node left = new Node(6);
        Node right = new Node(7);
        Node left1 = new Node(1);
        Node right1 = new Node(4);
        node.left = left;
        node.right = right;
        left.left = left1;
        left.right = right1;

        Solution_73 solution_73 = new Solution_73();
        System.out.println(solution_73.isValidBST(node));
    }
}
