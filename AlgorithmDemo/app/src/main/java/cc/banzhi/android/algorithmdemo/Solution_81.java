package cc.banzhi.android.algorithmdemo;

/**
 * @program: AlgorithmDemo
 * @description: 力扣 122. 买卖股票的最佳时机 II
 * @author: zoufengli01
 * @create: 2022/8/17 01:01
 **/
public class Solution_81 {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) return 0;
        int profit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            int diff = prices[i + 1] - prices[i];
            if (diff > 0) {
                profit += diff;
            }
        }
        return profit;
    }

    public static void main(String[] args) {
        Solution_81 solution_81 = new Solution_81();
        System.out.println(solution_81.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }
}
