package cc.banzhi.android.algorithmdemo;

/**
 * @program: AlgorithmDemo
 * @description: 力扣 剑指 Offer 07. 重建二叉树
 * @author: zoufengli01
 * @create: 2022/8/20 01:54
 **/
public class Solution_99 {

    private static class Node {
        int val;
        Node left, right;

        public Node(int val) {
            this.val = val;
        }
    }

    // 前序遍历：[ 根节点, [左子树的前序遍历结果], [右子树的前序遍历结果] ]
    // 中序遍历：[ [左子树的前序遍历结果], 根节点, [右子树的前序遍历结果] ]
    public Node buildTree(int[] preorder, int[] inorder) {
        if (preorder == null ||
                inorder == null) return null;
        return buildTree(preorder, inorder,
                0, preorder.length - 1,
                0, inorder.length - 1);
    }

    public Node buildTree(int[] preorder, int[] inorder,
                          int pre_start, int pre_end, int in_start, int in_end) {
        if (pre_start > pre_end || in_start > in_end) return null;

        int pVal = preorder[pre_start];
        Node node = new Node(pVal);

        int pIndex = 0;
        for (int i = in_start; i <= in_end; i++) {
            if (pVal == inorder[i]) {
                pIndex = i;
                break;
            }
        }

        int index = pre_start;
        for (int i = in_start; i < pIndex; i++) {
            index++;
        }

        node.left = buildTree(preorder, inorder, pre_start + 1, index, in_start, pIndex - 1);

        node.right = buildTree(preorder, inorder, index + 1, pre_end, pIndex + 1, in_end);

        return node;
    }

    public static void main(String[] args) {
        Solution_99 solution_99 = new Solution_99();
        Node node = solution_99.buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
        print(node);
    }

    private static void print(Node root) {
        if (root == null) {
            System.out.println("null");
        } else {
            System.out.println(root.val);
            print(root.left);
            print(root.right);
        }
    }
}
