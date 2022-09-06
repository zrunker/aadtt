package cc.banzhi.android.algorithmdemo;

/**
 * @program: AlgorithmDemo
 * @description: 力扣 42. 接雨水
 * @author: zoufengli01
 * @create: 2022/7/31 18:44
 **/
public class Solution_20 {

    // 当前柱子，左边的最大柱子高度 lh
    // 当前柱子，右边的最大柱子高度 rh
    // 当前柱子的接水量，Math.min(lh, rh) - 当前柱子的高度
    public int trap(int[] height) {
        int[] lhs = new int[height.length];
        int lmaxH = 0;
        for (int i = 0; i < height.length; i++) {
            lmaxH = Math.max(lmaxH, height[i]);
            lhs[i] = lmaxH;
        }

        int[] rhs = new int[height.length];
        int rmaxH = 0;
        for (int i = height.length - 1; i >= 0; i--) {
            rmaxH = Math.max(rmaxH, height[i]);
            rhs[i] = rmaxH;
        }

        int[] dp = new int[height.length];
        for (int i = 0; i < height.length; i++) {
            int temp = Math.min(lhs[i], rhs[i]) - height[i];
            dp[i] = Math.max(temp, 0);
        }

        int res = 0;
        for (int j : dp) {
            res += j;
        }

        return res;
    }

    public static void main(String[] args) {
        Solution_20 solution_20 = new Solution_20();
        System.out.println(solution_20.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }
}
