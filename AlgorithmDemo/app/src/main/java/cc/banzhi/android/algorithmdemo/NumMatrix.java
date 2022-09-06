package cc.banzhi.android.algorithmdemo;

/**
 * @program: AlgorithmDemo
 * @description: 力扣 304. 二维区域和检索 - 矩阵不可变
 * @author: zoufengli01
 * @create: 2022/8/14 11:25
 **/
public class NumMatrix {
    private int[][] sums;

    public NumMatrix(int[][] matrix) {
        if (matrix == null) return;

        int row = matrix.length;
        if (row > 0) {
            int col = matrix[0].length;
            sums = new int[row + 1][col + 1];

            // 初始化前缀和首项
            for (int i = 0; i < row; i++) {
                sums[i][0] = 0;
            }
            for (int i = 0; i < col; i++) {
                sums[0][i] = 0;
            }

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    sums[i + 1][j + 1] = sums[i + 1][j] + sums[i][j + 1] - sums[i][j] + matrix[i][j];
                }
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sums[row2 + 1][col2 + 1] - sums[row1][col2 + 1] - sums[row2 + 1][col1] + sums[row1][col1];
    }
}
