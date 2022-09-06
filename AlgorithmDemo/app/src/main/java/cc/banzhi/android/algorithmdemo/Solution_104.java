package cc.banzhi.android.algorithmdemo;

import java.util.Arrays;

/**
 * @program: AlgorithmDemo
 * @description: 牛客网 自然数数组的排序
 * @author: zoufengli01
 * @create: 2022/8/22 22:17
 **/
public class Solution_104 {

    private void naturalNumSort(int[] arr) {
        if (arr == null || arr.length <= 1) return;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != i + 1) {
                int temp = arr[i];
                arr[i] = arr[temp - 1];
                arr[temp - 1] = temp;
            }
        }
    }

    public static void main(String[] args) {
        Solution_104 solution_104 = new Solution_104();
        int[] nums = new int[]{2, 1, 4, 5, 3};
        solution_104.naturalNumSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
