package cc.banzhi.android.algorithmdemo;

/**
 * @program: AlgorithmDemo
 * @description: 力扣 7. 整数反转
 * @author: zoufengli01
 * @create: 2022/8/7 08:12
 **/
public class Solution_31 {

    public int reverse(int x) {
        if (-10 < x && x < 10) {
            return x;
        }
        int res = 0;
        while (x != 0) {
            res = res * 10 + x % 10;
            if (res < Integer.MIN_VALUE / 10 || res > Integer.MAX_VALUE / 10) {
                return 0;
            }
            x = x / 10;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution_31 solution_31 = new Solution_31();
        System.out.println(solution_31.reverse(-123));
    }
}
