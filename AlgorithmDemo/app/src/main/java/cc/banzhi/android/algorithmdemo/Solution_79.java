package cc.banzhi.android.algorithmdemo;

import java.util.Arrays;

/**
 * @program: AlgorithmDemo
 * @description: 力扣 面试题 10.01. 合并排序的数组
 * @author: zoufengli01
 * @create: 2022/8/17 00:26
 **/
public class Solution_79 {

    public void merge(int[] A, int m, int[] B, int n) {
        int size = m + n;
        while (m > 0 && n > 0) {
            int A1 = A[m - 1];
            int B1 = B[n - 1];
            if (A1 > B1) {
                m--;
                A[--size] = A1;
            } else {
                n--;
                A[--size] = B1;
            }
        }
        while (m > 0) {
            A[--size] = A[--m];
        }
        while (n > 0) {
            A[--size] = B[--n];
        }
    }

    public static void main(String[] args) {
        Solution_79 solution_79 = new Solution_79();
        int[] A = new int[]{1, 2, 3, 0, 0, 0};
        solution_79.merge(A, 3, new int[]{2, 5, 6}, 3);
        System.out.println(Arrays.toString(A));
    }
}
