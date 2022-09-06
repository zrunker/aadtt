package cc.banzhi.android.algorithmdemo;

import java.util.Arrays;

/**
 * @program: AlgorithmDemo
 * @description: 牛客网 不包含本位置值的累乘数组
 * @author: zoufengli01
 * @create: 2022/8/22 23:28
 **/
public class Solution_106 {

    public int[] product(int[] arr) {
        if (arr == null || arr.length == 0) return null;

        int[] res = new int[arr.length];
        Arrays.fill(res, 0);

        long all = 1;
        int zeroCount = 0;
        for (int num : arr) {
            if (num != 0) {
                all *= num;
            } else {
                zeroCount++;
            }
        }

        if (zeroCount > 1) {
            return res;
        } else if (zeroCount == 1) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == 0) {
                    res[i] = (int) all;
                    break;
                }
            }
        } else {
            for (int i = 0; i < arr.length; i++) {
                res[i] = (int) (all / arr[i]);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Solution_106 solution_106 = new Solution_106();
        System.out.println(Arrays.toString(solution_106.product(new int[]{2, 3, 1, 4})));
    }
}
