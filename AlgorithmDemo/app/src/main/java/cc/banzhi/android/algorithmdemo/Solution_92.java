package cc.banzhi.android.algorithmdemo;

/**
 * @program: AlgorithmDemo
 * @description: 力扣 62. 不同路径
 * @author: zoufengli01
 * @create: 2022/8/18 16:41
 **/
public class Solution_92 {

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        Solution_92 solution_92 = new Solution_92();
        System.out.println(solution_92.uniquePaths(3, 7));
    }
}
