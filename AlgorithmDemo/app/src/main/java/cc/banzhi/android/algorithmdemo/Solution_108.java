package cc.banzhi.android.algorithmdemo;

import java.util.Arrays;

/**
 * @program: AlgorithmDemo
 * @description: 荷兰国旗问题
 * 给一个数组，小于num的放在数组左边，等于放在中间，大于放在右边
 * @author: zoufengli01
 * @create: 2022/8/23 11:19
 **/
public class Solution_108 {

    public int[] partition(int[] arr, int num) {
        int left = 0, right = arr.length - 1;
        int pointer = 0;
        while (pointer <= right) {
            int temp = arr[pointer];
            if (temp < num) {
                if (left != pointer) {
                    left++;
                    arr[pointer] = arr[left];
                    arr[left] = temp;
                }
                pointer++;
            } else if (temp > num) {
                arr[pointer] = arr[right];
                arr[right] = temp;
                right--;
            } else {
                pointer++;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        Solution_108 solution_108 = new Solution_108();
        System.out.println(Arrays.toString(solution_108.partition(
                new int[]{0, 1, 2, 2, 1, 1, 1, 0, 2, 0, 1}, 2)));
    }
}
