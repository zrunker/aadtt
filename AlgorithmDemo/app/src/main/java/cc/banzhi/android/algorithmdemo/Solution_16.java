package cc.banzhi.android.algorithmdemo;

/**
 * @program: AlgorithmDemo
 * @description: 力扣 剑指 Offer II 089. 房屋偷盗
 * @author: zoufengli01
 * @create: 2022/7/30 21:21
 **/
public class Solution_16 {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int[] dp = new int[nums.length + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        dp[2] = Math.max(nums[0], nums[1]);
        for (int i = 3; i < dp.length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i - 1], dp[i - 1]);
        }
        return dp[nums.length];
    }

    public static void main(String[] args) {
        Solution_16 solution_16 = new Solution_16();
        System.out.println(solution_16.rob(new int[]{1, 2, 3, 1}));
    }
}
