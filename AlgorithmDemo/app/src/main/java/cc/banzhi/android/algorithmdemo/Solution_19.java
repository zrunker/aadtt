package cc.banzhi.android.algorithmdemo;

/**
 * @program: AlgorithmDemo
 * @description: 力扣 322. 零钱兑换
 * @author: zoufengli01
 * @create: 2022/7/31 17:26
 **/
public class Solution_19 {

    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0 || amount <= 0) {
            return -1;
        }
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            int min = -1;
            for (int coin : coins) {
                int temp = i - coin;
                if (temp >= 0) {
                    min = min == -1 ? dp[temp] + 1 : Math.min(dp[temp] + 1, min);
                }
            }
            dp[i] = min;
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        Solution_19 solution_19 = new Solution_19();
        System.out.println(solution_19.coinChange(new int[]{1, 2, 5}, 11));
    }
}
