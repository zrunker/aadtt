package cc.banzhi.android.algorithmdemo;

/**
 * @program: AlgorithmDemo
 * @description: 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 * @author: zoufengli01
 * @create: 2022/8/19 09:45
 **/
public class Solution_93 {

    public int rectCover(int n) {
        if (n < 1) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;
        int[] dp = new int[n];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i < n; i++) {
            dp[i] = dp[i - 2] + dp[i - 1];
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        Solution_93 solution_93 = new Solution_93();
        System.out.println(solution_93.rectCover(8));
    }
}
