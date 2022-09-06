package cc.banzhi.android.algorithmdemo;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @program: AlgorithmDemo
 * @description: 力扣 1.两数之和
 * @author: zoufengli01
 * @create: 2022/8/12 11:31
 **/
public class Solution_57 {

    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length <= 0) return null;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int item = nums[i];
            if (map.containsKey(item)) {
                Integer num = map.get(item);
                if (num != null) {
                    return new int[]{num, i};
                }
            }
            map.put(target - item, i);
        }
        return null;
    }

    public int[] twoSum2(int[] nums, int target) {
        if (nums == null || nums.length <= 0) return null;
        // 快排
        for (int i = 0; i < nums.length; i++) {
            int min = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[min]) {
                    min = j;
                }
            }
            if (i == min) {
                int temp = nums[i];
                nums[i] = nums[min];
                nums[min] = temp;
            }
        }

        // 前后指针
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int temp = nums[left] + nums[mid];
            if (temp == target) {
                return new int[]{left, mid};
            } else if (temp < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Solution_57 solution_57 = new Solution_57();
        System.out.println(Arrays.toString(solution_57.twoSum(new int[]{2, 7, 11, 15}, 9)));
    }
}
