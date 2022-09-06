package cc.banzhi.android.algorithmdemo;

/**
 * @program: AlgorithmDemo
 * @description: 力扣 剑指 Offer 11. 旋转数组的最小数字
 * @author: zoufengli01
 * @create: 2022/8/18 16:03
 **/
public class Solution_91 {

    public int minArray(int[] numbers) {
        if (numbers == null || numbers.length == 0) return Integer.MIN_VALUE;

        int left = 0, right = numbers.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int num = numbers[right];
            if (numbers[mid] < num) {
                right = mid;
            } else if (numbers[mid] > num) {
                left = mid + 1;
            } else {
                right--;
            }
        }

        return numbers[left];
    }

    public static void main(String[] args) {
        Solution_91 solution_91 = new Solution_91();
        System.out.println(solution_91.minArray(new int[]{3, 4, 5, 1, 2}));
    }
}
