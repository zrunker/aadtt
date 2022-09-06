package cc.banzhi.android.algorithmdemo;

import java.util.Arrays;

/**
 * @program: AlgorithmDemo
 * @description: 数组partition调整使数组的左部分单调有序。
 * 给定一个有序数组arr，调整使得数组的左部分无重复元素且有序，右边部分不要求。
 * 如数组arr[]={1,2,2,2,3,3,4,5,6,9,9} ;调整过后可以为：[1, 2, 3, 4, 5, 6, 9, 2, 3, 2, 9] 。
 * @author: zoufengli01
 * @create: 2022/8/23 10:00
 **/
public class Solution_107 {

    public void noRepeat(int[] arr) {
        if (arr == null || arr.length <= 1) return;
        int left = 0, right = 1;
        while (right < arr.length) {
            if (arr[left] != arr[right]) {
                left++;
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
            right++;
        }
    }

    public static void main(String[] args) {
        Solution_107 solution_107 = new Solution_107();
        int[] nums = new int[]{1, 2, 2, 2, 3, 3, 4, 5, 6, 9, 9};
        solution_107.noRepeat(nums);
        System.out.println(Arrays.toString(nums));
    }
}
