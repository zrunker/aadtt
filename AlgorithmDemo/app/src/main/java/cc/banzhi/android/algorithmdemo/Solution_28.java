package cc.banzhi.android.algorithmdemo;

/**
 * @program: AlgorithmDemo
 * @description: 落单的数：
 * - 给出 2 * n + 1个数字，除其中一个数字之外其他每个数字均出现两次，找到这个数字。
 * @author: zoufengli01
 * @create: 2022/8/5 19:10
 **/
public class Solution_28 {

    public int singleNumber(int[] arr) {
        if (arr == null || arr.length <= 0) {
            return Integer.MIN_VALUE;
        }
        if (arr.length == 1) {
            return arr[0];
        }
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            res ^= arr[i];
        }
        return res;
    }

    public static void main(String[] args) {
        Solution_28 solution_28 = new Solution_28();
        int[] arr = new int[]{0, 22, 22, 24, 34, 8, 0, 8, 34};
        System.out.println(solution_28.singleNumber(arr));
    }
}
