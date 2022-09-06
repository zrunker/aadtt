package cc.banzhi.android.algorithmdemo;

/**
 * @program: AlgorithmDemo
 * @description: 力扣 72. 编辑距离
 * @author: zoufengli01
 * @create: 2022/7/31 08:45
 **/
public class Solution_17 {
    /**
     * 动态规划（从小推大，自低向上），双状态（word1中字符个数，word2中字符个数）
     * <p>
     * 1. 在word1后面插入一个字符。
     * 2. 在word2后面插入一个字符。
     * 3. 修改word1或word2最后一个字符。
     * - 最后一个字符相同，不需要进行任何操作。
     * - 最后一个字符不同，则修改。
     */
    public int minDistance(String word1, String word2) {
        if (word1 == null || word2 == null || word1.equals(word2)) {
            return 0;
        }
        int m = word1.length();
        int n = word2.length();

        // 有一个字符串为空串，""
        if (m * n == 0) {
            return m + n;
        }

        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j]));
                }
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {
        Solution_17 solution_17 = new Solution_17();
        System.out.println(solution_17.minDistance("horse", "ros"));
    }
}
