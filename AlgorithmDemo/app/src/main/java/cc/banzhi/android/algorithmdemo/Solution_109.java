package cc.banzhi.android.algorithmdemo;

import java.util.Arrays;

/**
 * @program: AlgorithmDemo
 * @description: 力扣 面试题 17.24. 最大子矩阵
 * @author: zoufengli01
 * @create: 2022/8/23 16:50
 **/
public class Solution_109 {

    public int[] getMaxMatrix(int[][] matrix) {
        int rl = matrix.length;
        int cl = matrix[0].length;

        // 前缀和
        int[][] sums = new int[rl + 1][cl + 1];
        for (int i = 0; i < rl; i++) {
            sums[i][0] = 0;
        }
        for (int i = 0; i < cl; i++) {
            sums[0][i] = 0;
        }
        for (int i = 0; i < rl; i++) {
            for (int j = 0; j < cl; j++) {
                sums[i + 1][j + 1] = sums[i + 1][j] + sums[i][j + 1] - sums[i][j] + matrix[i][j];
            }
        }

        // 穷举所有结果
        int[] res = new int[4];
        int max = Integer.MIN_VALUE;
        // 上下
        for (int top = 0; top < rl; top++) {
            for (int bottom = top; bottom < rl; bottom++) {

                // 左右
                for (int left = 0; left < cl; left++) {
                    for (int right = left; right < cl; right++) {

                        int sum = sums[bottom + 1][right + 1] - sums[top][right + 1] -
                                sums[bottom + 1][left] + sums[top][left];

                        if (max < sum) {
                            max = sum;
                            res[0] = top;
                            res[1] = left;
                            res[2] = bottom;
                            res[3] = right;
                        }

                    }
                }

            }
        }

        return res;
    }

    public static void main(String[] args) {
        Solution_109 solution_109 = new Solution_109();
        System.out.println(Arrays.toString(solution_109.getMaxMatrix(new int[][]{
                {9, -8, 1, 3, -2}, {-3, 7, 6, -2, 4}, {6, -4, -4, 8, -7}
        })));
    }
}
