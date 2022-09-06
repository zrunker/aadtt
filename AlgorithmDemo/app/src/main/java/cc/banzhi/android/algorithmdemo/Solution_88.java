package cc.banzhi.android.algorithmdemo;

/**
 * @program: AlgorithmDemo
 * @description: 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 * @author: zoufengli01
 * @create: 2022/8/18 15:08
 **/
public class Solution_88 {

    // 利用Integer.toBinaryString方法
    public int numberOf1(int n) {
        String s = Integer.toBinaryString(n);
        char[] chars = s.toCharArray();
        int count = 0;
        for (char c : chars) {
            if ('1' == c) {
                count++;
            }
        }
        return count;
    }

    // 利用&运算
    public int numberOf12(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = n & (n - 1);
        }
        return count;
    }

    public static void main(String[] args) {
        Solution_88 solution_88 = new Solution_88();
        System.out.println(solution_88.numberOf1(23));
    }
}
