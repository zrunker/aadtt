package cc.banzhi.android.algorithmdemo;

/**
 * @program: AlgorithmDemo
 * @description: 力扣 69. x 的平方根
 * @author: zoufengli01
 * @create: 2022/8/13 20:21
 **/
public class Solution_63 {

    public int mySqrt(int x) {
        if (x < 0) return Integer.MIN_VALUE;
        if (x <= 1) return x;
        int left = 2, right = x - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid == x / mid) {
                return mid;
            } else if (mid < x / mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if (left < x / left) {
            return left;
        }
        return right;
    }

    public static void main(String[] args) {
        Solution_63 solution_63 = new Solution_63();
        System.out.println(solution_63.mySqrt(4));
    }
}
