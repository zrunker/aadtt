package cc.banzhi.android.algorithmdemo;

import java.util.Arrays;

/**
 * @program: AlgorithmDemo
 * @description: 力扣 66. 加一
 * @author: zoufengli01
 * @create: 2022/8/16 01:30
 **/
public class Solution_75 {

    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length <= 0) return digits;

        int carries = 1;
        for (int i = digits.length - 1; i >= 0 && carries > 0; i--) {
            int num = digits[i] + carries;
            digits[i] = num % 10;
            carries = num / 10;
        }
        if (carries == 0) {
            return digits;
        }
        int[] res = new int[digits.length + 1];
        res[0] = 1;
        System.arraycopy(digits, 0, res, 1, digits.length);
        return res;
    }

    public static void main(String[] args) {
        Solution_75 solution_75 = new Solution_75();
        System.out.println(Arrays.toString(solution_75.plusOne(new int[]{
                9, 8, 7, 6, 5, 4, 3, 2, 1, 0})));
    }
}
