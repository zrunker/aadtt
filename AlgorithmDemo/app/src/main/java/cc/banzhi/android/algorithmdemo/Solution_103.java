package cc.banzhi.android.algorithmdemo;

import java.util.Arrays;

/**
 * @program: AlgorithmDemo
 * @description: 力扣 581. 最短无序连续子数组
 * @author: zoufengli01
 * @create: 2022/8/22 09:15
 **/
public class Solution_103 {

    public int findUnsortedSubarray(int[] nums) {
        if (nums == null || nums.length <= 1) return 0;
        if (isSorted(nums)) return 0;

        // 发现比左侧最大值小
        int right = -1;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (max > nums[i]) {
                right = i;
            } else {
                max = nums[i];
            }
        }

        // 发现比右侧最小值大
        int left = -1;
        int min = Integer.MAX_VALUE;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] < min) {
                left = i;
            } else {
                min = nums[i];
            }
        }

        return right == -1 ? 0 : right - left + 1;
    }

    private boolean isSorted(int[] nums) {
        int pre = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < pre) {
                return false;
            } else {
                pre = nums[i];
            }
        }
        return true;
    }

    public int findUnsortedSubarray2(int[] nums) {
        if (nums == null || nums.length <= 1) return 0;
        if (isSorted(nums)) return 0;

        // 复制，排序
        int[] newNums = new int[nums.length];
        System.arraycopy(nums, 0, newNums, 0, nums.length);
        Arrays.sort(newNums);

        // 取左侧
        int left = -1;
        for (int i = 0; i < newNums.length; i++) {
            if (nums[i] != newNums[i]) {
                left = i;
                break;
            }
        }

        // 取右侧
        int right = -1;
        for (int i = newNums.length - 1; i >= 0; i--) {
            if (nums[i] != newNums[i]) {
                right = i;
                break;
            }
        }

        return right == -1 ? 0 : right - left + 1;
    }

    public static void main(String[] args) {
        Solution_103 solution_103 = new Solution_103();
        System.out.println(solution_103.findUnsortedSubarray(new int[]{2, 6, 4, 8, 10, 9, 15}));
    }

}
