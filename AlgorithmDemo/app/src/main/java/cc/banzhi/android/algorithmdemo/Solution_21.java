package cc.banzhi.android.algorithmdemo;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: AlgorithmDemo
 * @description: 力扣 54. 螺旋矩阵
 * @author: zoufengli01
 * @create: 2022/8/1 08:50
 **/
public class Solution_21 {

    // 右，下，左，上 循环往复
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length <= 0) {
            return null;
        }

        List<Integer> res = new ArrayList<>();

        int rows = matrix.length;
        int cols = matrix[0].length;

        int rStart = 0, rEnd = rows - 1;
        int cStart = 0, cEnd = cols - 1;
        while (res.size() < rows * cols && rStart <= rEnd && cStart <= cEnd) {
            right(rStart, cStart, cEnd, matrix, res);
            rStart++;
            down(cEnd, rStart, rEnd, matrix, res);
            cEnd--;
            left(rEnd, cStart, cEnd, matrix, res);
            rEnd--;
            up(cStart, rStart, rEnd, matrix, res);
            cStart++;
        }

        return res;
    }

    private void right(int row, int start, int end, int[][] matrix, List<Integer> res) {
        for (int i = start; i <= end; i++) {
            res.add(matrix[row][i]);
        }
    }

    private void down(int col, int start, int end, int[][] matrix, List<Integer> res) {
        for (int i = start; i <= end; i++) {
            res.add(matrix[i][col]);
        }
    }

    private void left(int row, int start, int end, int[][] matrix, List<Integer> res) {
        for (int i = end; i >= start; i--) {
            res.add(matrix[row][i]);
        }
    }

    private void up(int col, int start, int end, int[][] matrix, List<Integer> res) {
        for (int i = end; i >= start; i--) {
            res.add(matrix[i][col]);
        }
    }

    public static void main(String[] args) {
        Solution_21 solution_21 = new Solution_21();
        System.out.println(solution_21.spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}));
    }
}
