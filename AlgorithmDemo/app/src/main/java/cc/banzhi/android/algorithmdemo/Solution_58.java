package cc.banzhi.android.algorithmdemo;

import java.util.Arrays;

/**
 * @program: AlgorithmDemo
 * @description: 反转数组
 * @author: zoufengli01
 * @create: 2022/8/12 12:10
 **/
public class Solution_58 {

    public void reverse(int[] nums) {
        if (nums == null || nums.length <= 1) return;
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;

            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        Solution_58 solution_58 = new Solution_58();
        int[] nums = new int[]{1, 2, 3, 4, 5};
        solution_58.reverse(nums);
        System.out.println(Arrays.toString(nums));
    }
}
