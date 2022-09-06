package cc.banzhi.android.algorithmdemo;

/**
 * @program: AlgorithmDemo
 * @description: 力扣 70. 爬楼梯
 * @author: zoufengli01
 * @create: 2022/7/30 20:11
 **/
public class Solution_15 {
    // n = 0，0
    // n = 1，1
    // n = 2, 2
    // n，f(n-1) + f(n - 2)
    public int climbStairs(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i < dp.length; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Solution_15 solution_15 = new Solution_15();
        System.out.println(solution_15.climbStairs(20));
    }
}
