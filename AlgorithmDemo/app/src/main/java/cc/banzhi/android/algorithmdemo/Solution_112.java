package cc.banzhi.android.algorithmdemo;

/**
 * @program: AlgorithmDemo
 * @description: 力扣 124. 二叉树中的最大路径和
 * @author: zoufengli01
 * @create: 2022/9/5 10:27
 **/
public class Solution_112 {

    private static class Node {
        int value;
        Node left, right;

        public Node(int value) {
            this.value = value;
        }
    }

    int result = Integer.MIN_VALUE;

    public int maxPathSum(Node root) {
        maxGain(root);
        return result;
    }

    public int maxGain(Node node) {
        if (node == null) {
            return 0;
        }

        // 递归计算左右子节点的最大贡献值
        // 只有在最大贡献值大于 0 时，才会选取对应子节点
        int leftGain = Math.max(maxGain(node.left), 0);
        int rightGain = Math.max(maxGain(node.right), 0);

        // 节点的最大路径和取决于该节点的值与该节点的左右子节点的最大贡献值
        int priceNewpath = node.value + leftGain + rightGain;

        // 更新答案
        result = Math.max(result, priceNewpath);

        // 返回节点的最大贡献值
        return node.value + Math.max(leftGain, rightGain);
    }

    public static void main(String[] args) {
        Solution_112 solution_112 = new Solution_112();

        Node root = new Node(-10);
        root.left = new Node(9);
        Node right = new Node(20);
        root.right = right;
        right.left = new Node(15);
        right.right = new Node(7);

        System.out.println(solution_112.maxPathSum(root));
    }
}
