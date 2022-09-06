package cc.banzhi.android.algorithmdemo;

import java.util.Arrays;

/**
 * @program: AlgorithmDemo
 * @description: 力扣 48. 旋转图像
 * @author: zoufengli01
 * @create: 2022/8/1 10:49
 **/
public class Solution_23 {

    /**
     * 假设n = 4
     * <p>
     * (0, 0) -> (0, 3)
     * (0, 1) -> (1, 3)
     * (0, 2) -> (2, 3)
     * <p>
     * (0, 3) -> (3, 3)
     * (1, 3) -> (3, 2)
     * (2, 3) -> (3, 1)
     * <p>
     * (3, 3) -> (3, 0)
     * (3, 2) -> (2, 0)
     * (3, 1) -> (1, 0)
     * <p>
     * (3, 0) -> (0, 0)
     * (2, 0) -> (0, 1)
     * (1, 0) -> (0, 2)
     * <p>
     * (1, 1) -> (1, 2)
     * <p>
     * 变化之前(i, j) => 变化之后（j, n-1-i)
     */
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int rStart = 0, rEnd = n - 1;
        int cStart = 0, cEnd = n - 1;
        while (cEnd > cStart && rEnd > rStart) {
            for (int i = cStart; i < cEnd; i++) {
                int tlNum = matrix[rStart][i];
                int trNum = matrix[i][n - 1 - rStart];
                int drNum = matrix[n - 1 - rStart][n - 1 - i];
                int dlNum = matrix[n - 1 - i][rStart];

                matrix[i][n - 1 - rStart] = tlNum;
                matrix[n - 1 - rStart][n - 1 - i] = trNum;
                matrix[n - 1 - i][rStart] = drNum;
                matrix[rStart][i] = dlNum;
            }
            rStart++;
            cStart++;
            cEnd--;
            rEnd--;
        }
    }

    public static void main(String[] args) {
        Solution_23 solution_23 = new Solution_23();
        int[][] matrix = new int[][]{
                {5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}
        };
        solution_23.rotate(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }
}
