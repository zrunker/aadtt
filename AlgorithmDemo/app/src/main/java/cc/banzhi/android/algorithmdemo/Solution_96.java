package cc.banzhi.android.algorithmdemo;

/**
 * @program: AlgorithmDemo
 * @description: 力扣 344. 反转字符串
 * @author: zoufengli01
 * @create: 2022/8/19 15:43
 **/
public class Solution_96 {

    public void reverseString(char[] s) {
        if (s == null || s.length <= 1) return;
        int left = 0, right = s.length - 1;
        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;

            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        Solution_96 solution_96 = new Solution_96();
        char[] s = new char[]{'h', 'e', 'l', 'l', 'o'};
        solution_96.reverseString(s);
        System.out.println(s);
    }
}
