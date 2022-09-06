package cc.banzhi.android.algorithmdemo;

/**
 * @program: AlgorithmDemo
 * @description: “之”字形打印矩阵
 * @author: zoufengli01
 * @create: 2022/8/23 19:23
 **/
public class Solution_110 {

    /**
     * 给定一个矩阵matrix，按照“之”字形的方式打印矩阵，例如：
     * <p>
     * 1        2        3        4
     * 5        6        7        8
     * 9        10       11       12
     * <p>
     * “之”字形打印的结果为：1,2,5,9,6,3,4,7,10,11,8,12
     * <p>
     * 要求：额外空间复杂度为O（1）
     */
    public void printMatrixZigZag(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return;

        int rows = matrix.length - 1;
        int cols = matrix[0].length - 1;

        // (tR, tC)左上角坐标，先从左向右，然后从上向下变化
        int tR = 0, tC = 0;
        // (bR, bC)右下角坐标，先从上向下，然后从左向右变化
        int bR = 0, bC = 0;

        boolean isUp = true;
        while (tR != rows + 1) {
            print(tR, tC, bR, bC, isUp, matrix);

            tR = tC == cols ? tR + 1 : tR;
            tC = tC == cols ? tC : tC + 1;

            bC = bR == rows ? bC + 1 : bC;
            bR = bR == rows ? bR : bR + 1;

            isUp = !isUp;
        }

    }

    // (0, 0)
    // (0, 1)、(1，0)
    // (2, 0) (1, 1) (0, 2)
    // (0, 3) (1, 2) (2, 1)
    private void print(int tR, int tC,
                       int bR, int bC,
                       boolean isUp, int[][] matrix) {
        if (isUp) {
            // 从下往上
            // bR不断减小，以至于接近tR
            while (bR != tR - 1) {
                System.out.println(matrix[bR--][bC++]);
            }
        } else {
            // 从上往下
            // tR不断增加，以至于接近bR
            while (tR != bR + 1) {
                System.out.println(matrix[tR++][tC--]);
            }
        }
    }

    public static void main(String[] args) {
        Solution_110 solution_110 = new Solution_110();
        solution_110.printMatrixZigZag(new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        });
    }
}
