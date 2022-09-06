package cc.banzhi.android.algorithmdemo;

/**
 * @program: AlgorithmDemo
 * @description: 力扣 剑指 Offer 10- II. 青蛙跳台阶问题
 * @author: zoufengli01
 * @create: 2022/8/18 15:40
 **/
public class Solution_90 {

    public int numWays(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i < dp.length; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
            // dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000007;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Solution_90 solution_90 = new Solution_90();
        System.out.println(solution_90.numWays(2));
    }
}
