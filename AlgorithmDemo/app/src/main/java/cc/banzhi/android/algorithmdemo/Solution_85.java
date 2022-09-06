package cc.banzhi.android.algorithmdemo;

/**
 * @program: AlgorithmDemo
 * @description: 力扣 剑指 Offer 04. 二维数组中的查找
 * @author: zoufengli01
 * @create: 2022/8/18 00:45
 **/
public class Solution_85 {

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) return false;

        int rows = matrix.length;
        int cols = matrix[0].length;

        // 起点
        int row = 0;
        int col = cols - 1;
        while (row < rows && col >= 0) {
            int num = matrix[row][col];
            if (num == target) {
                return true;
            } else if (num < target) {
                row++;
            } else {
                col--;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Solution_85 solution_85 = new Solution_85();
        System.out.println(solution_85.findNumberIn2DArray(new int[][]{
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        }, 5));
    }
}
