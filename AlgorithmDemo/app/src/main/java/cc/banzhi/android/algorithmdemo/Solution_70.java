package cc.banzhi.android.algorithmdemo;

/**
 * @program: AlgorithmDemo
 * @description: 剑指 Offer II 076. 数组中的第 k 大的数字
 * @author: zoufengli01
 * @create: 2022/8/15 09:30
 **/
public class Solution_70 {

    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length < k) return Integer.MIN_VALUE;
        if (k <= 0) return Integer.MIN_VALUE;

        for (int i = 0; i < k; i++) {
            int min = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[min] < nums[j]) {
                    min = j;
                }
            }
            int temp = nums[i];
            nums[i] = nums[min];
            nums[min] = temp;
        }

        return nums[k - 1];
    }

    public static void main(String[] args) {
        Solution_70 solution_70 = new Solution_70();
        System.out.println(solution_70.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
    }
}
