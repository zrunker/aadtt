package cc.banzhi.android.algorithmdemo;

import java.util.Arrays;

/**
 * @program: AlgorithmDemo
 * @description: 力扣 剑指 Offer 21. 调整数组顺序使奇数位于偶数前面
 * @author: zoufengli01
 * @create: 2022/8/19 10:12
 **/
public class Solution_94 {

    public int[] exchange(int[] nums) {
        if (nums == null || nums.length <= 1) return nums;

        int left = 0, right = nums.length - 1;
        while (left < right) {
            int num = nums[left];
            if (num % 2 == 0) {
                nums[left] = nums[right];
                nums[right] = num;
                right--;
            } else {
                left++;
            }
        }

        return nums;
    }

    public static void main(String[] args) {
        Solution_94 solution_94 = new Solution_94();
        System.out.println(Arrays.toString(solution_94.exchange(new int[]{1, 2, 3, 4})));
    }
}
