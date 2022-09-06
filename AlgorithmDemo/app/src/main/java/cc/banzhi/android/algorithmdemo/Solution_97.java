package cc.banzhi.android.algorithmdemo;

/**
 * @program: AlgorithmDemo
 * @description: 力扣 541. 反转字符串 II
 * @author: zoufengli01
 * @create: 2022/8/19 15:57
 **/
public class Solution_97 {

    public String reverseStr(String s, int k) {
        if (s == null || "".equals(s)) return s;

        int n = s.length();
        char[] chars = s.toCharArray();
        for (int i = 0; i < n; i += 2 * k) {
            // 计算剩余数量
            int num = n - 1 - i;
            if (num < k) {
                reverse(chars, i, n - 1);
            } else if (num >= k && num < 2 * k) {
                reverse(chars, i, i + k - 1);
            } else {
                reverse(chars, i, i + k - 1);
            }
        }

        return new String(chars);
    }

    private void reverse(char[] chars, int left, int right) {
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;

            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        Solution_97 solution_97 = new Solution_97();
        System.out.println(solution_97.reverseStr("abcdefg", 2));
    }

}
