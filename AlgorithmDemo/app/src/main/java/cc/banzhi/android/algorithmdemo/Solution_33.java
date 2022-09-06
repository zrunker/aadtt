package cc.banzhi.android.algorithmdemo;

import java.util.LinkedList;

/**
 * @program: AlgorithmDemo
 * @description: DFS 二叉树深度遍历
 * @author: zoufengli01
 * @create: 2022/8/7 17:52
 **/
public class Solution_33 {

    private static class Node {
        Node left, right;
        int value;

        public Node(int value) {
            this.value = value;
        }
    }

    // 前序遍历，根->左->右，递归
    public void preTraverse(Node root) {
        if (root != null) {
            System.out.println(root.value);
            preTraverse(root.left);
            preTraverse(root.right);
        }
    }

    // 非递归
    public void preTraverse2(Node root) {
        if (root == null) return;
        LinkedList<Node> list = new LinkedList<>();
        while (!list.isEmpty() || root != null) {
            if (root != null) {
                System.out.println(root.value);
                list.add(root.right);
                root = root.left;
            } else {
                root = list.removeLast();
            }
        }
    }

    // 中序遍历，左->根->右
    public void inTraverse(Node root) {
        if (root != null) {
            inTraverse(root.left);
            System.out.println(root.value);
            inTraverse(root.right);
        }
    }

    // 非递归
    public void inTraverse2(Node root) {
        if (root == null) return;
        LinkedList<Node> list = new LinkedList<>();
        while (!list.isEmpty() || root != null) {
            if (root != null) {
                list.add(root);
                root = root.left;
            } else {
                Node node = list.removeLast();
                System.out.println(node.value);
                root = node.right;
            }
        }
    }

    // 后序遍历，左->右->根
    public void postTraverse(Node root) {
        if (root != null) {
            postTraverse(root.left);
            postTraverse(root.right);
            System.out.println(root.value);
        }
    }

    // 非递归
    public void postTraverse2(Node root) {
        if (root == null) return;
        LinkedList<Node> list1 = new LinkedList<>();
        LinkedList<Node> list2 = new LinkedList<>();
        list1.add(root);
        while (!list1.isEmpty()) {
            Node node = list1.removeLast();
            list2.add(node);
            if (node.left != null) {
                list1.add(node.left);
            }
            if (node.right != null) {
                list1.add(node.right);
            }
        }
        while (!list2.isEmpty()) {
            Node node = list2.removeLast();
            if (node == null) continue;
            System.out.println(node.value);
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

        Solution_33 solution_33 = new Solution_33();
        // 23，43，3，56，89，34，2
        solution_33.preTraverse(root);
        System.out.println("--------------");
        // 3，43，56，23，34，89，2
        solution_33.inTraverse(root);
        System.out.println("--------------");
        // 3，56，43，34，2，89，23
        solution_33.postTraverse(root);
    }
}
