package cc.banzhi.android.algorithmdemo;

/**
 * @program: AlgorithmDemo
 * @description: 力扣 剑指 Offer 16. 数值的整数次方
 * @author: zoufengli01
 * @create: 2022/8/20 15:29
 **/
public class Solution_100 {

    public double myPow(double x, int n) {
        if (n == 0) return 1;
        double res = 1;
        int absN = Math.abs(n);
//        for (int i = 0; i < absN; i++) {
//            res *= x;
//        }
        res = myPowItem(x, absN);
        return n > 0 ? res : 1 / res;
    }

    private double myPowItem(double x, int n) {
        if (n == 0) return 1;
        double num = myPowItem(x, n / 2);
        if (n % 2 == 0) {// 偶数
            return num * num;
        } else {// 奇数
            return x * num * num;
        }
    }

    public static void main(String[] args) {
        Solution_100 solution_100 = new Solution_100();
        System.out.println(solution_100.myPow(2.00000, 10));
    }
}
