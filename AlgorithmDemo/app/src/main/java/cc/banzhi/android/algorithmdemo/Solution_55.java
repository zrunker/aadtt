package cc.banzhi.android.algorithmdemo;

/**
 * @program: AlgorithmDemo
 * @description: 力扣 剑指 Offer 42. 连续子数组的最大和
 * @author: zoufengli01
 * @create: 2022/8/10 12:00
 **/
public class Solution_55 {

    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return Integer.MIN_VALUE;
        if (nums.length == 1) return nums[0];

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int temp = nums[i];
            dp[i] = dp[i - 1] > 0 ? dp[i - 1] + temp : temp;
            res = Math.max(res, dp[i]);
        }

        return res;
    }

    public int maxSubArray2(int[] array) {
        if (array == null || array.length <= 0) return Integer.MIN_VALUE;
        if (array.length == 1) return array[0];

        int res = array[0];
        for (int i = 1; i < array.length; i++) {
            array[i] += Math.max(array[i - 1], 0);
            res = Math.max(array[i], res);
        }

        return res;
    }

    public static void main(String[] args) {
        Solution_55 solution_55 = new Solution_55();
        System.out.println(solution_55.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }
}
