package cc.banzhi.android.algorithmdemo;

/**
 * @program: AlgorithmDemo
 * @description: 力扣 152. 乘积最大子数组
 * @author: zoufengli01
 * @create: 2022/7/31 15:17
 **/
public class Solution_18 {

    // 暴力求解
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = 0;
        for (int i = nums.length - 1; i > 0; i--) {
            for (int j = 0; j <= i; j++) {
                int temp = nums[j];
                for (int k = j + 1; k <= i; k++) {
                    temp *= nums[k];
                }
                if (temp > max) {
                    max = temp;
                }
            }
        }
        return max;
    }

    // 动态规划，需要缓存两个结果数组，计算每一项的最大最小值
    public int maxProduct2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] min = new int[nums.length];
        int[] max = new int[nums.length];
        int res = nums[0];
        min[0] = res;
        max[0] = res;

        for (int i = 1; i < nums.length; i++) {
            int temp = nums[i];
            // 注意，如果当前项等于0，那么当前项的最大值或最小值都为0
            if (temp > 0) {
                max[i] = Math.max(temp, max[i - 1] * temp);
                min[i] = Math.min(temp, min[i - 1] * temp);
            } else if (temp < 0) {
                max[i] = Math.max(temp, min[i - 1] * temp);
                min[i] = Math.min(temp, max[i - 1] * temp);
            } else {
                min[i] = temp;
                max[i] = temp;
            }
            res = Math.max(res, max[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution_18 solution_18 = new Solution_18();
        System.out.println(solution_18.maxProduct2(new int[]{2, 3, -2, 4}));
    }
}
