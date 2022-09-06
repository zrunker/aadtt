package cc.banzhi.android.algorithmdemo;

/**
 * @program: AlgorithmDemo
 * @description: 力扣 121. 买卖股票的最佳时机
 * @author: zoufengli01
 * @create: 2022/8/17 00:49
 **/
public class Solution_80 {

    public int maxProfit(int[] prices) {
        // 买入最小值
        int min = Integer.MAX_VALUE;
        int profit = Integer.MIN_VALUE;
        for (int item : prices) {
            min = Math.min(min, item);
            profit = Math.max(profit, item - min);
        }
        return profit;
    }

    public static void main(String[] args) {
        Solution_80 solution_80 = new Solution_80();
        System.out.println(solution_80.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }
}
