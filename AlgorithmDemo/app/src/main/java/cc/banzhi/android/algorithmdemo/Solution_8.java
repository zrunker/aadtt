package cc.banzhi.android.algorithmdemo;

/**
 * @program: AlgorithmDemo
 * @description: 剑指 Offer 67. 把字符串转换成整数
 * @author: zoufengli01
 * @create: 2022/7/27 15:35
 **/
public class Solution_8 {
    public int strToInt(String str) {
        if (str == null || "".equals(str)) {
            return 0;
        }
        str = str.trim();
        if (str.length() <= 0) {
            return 0;
        }

        int sign = 1;
        int index = 0;
        char temp = str.charAt(index);
        if (temp == '+') {
            index++;
        } else if (temp == '-') {
            sign = -1;
            index++;
        }

        long t = 0;
        for (; index < str.length(); index++) {
            char item = str.charAt(index);
            if (item >= '0' && item <= '9') {
                t = t * 10 + (item - '0');
            } else {
                break;
            }
        }

        t *= sign;
        if (t >= Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        if (t <= Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        return (int) t;
    }

    public static void main(String[] args) {
        Solution_8 solution_8 = new Solution_8();
        System.out.println(solution_8.strToInt("42"));
    }
}
