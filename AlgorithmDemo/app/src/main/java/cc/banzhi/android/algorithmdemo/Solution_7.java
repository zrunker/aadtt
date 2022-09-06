package cc.banzhi.android.algorithmdemo;

/**
 * @program: AlgorithmDemo
 * @description: 剑指 Offer 58 - I. 翻转单词顺序
 * @author: zoufengli01
 * @create: 2022/7/27 15:24
 **/
public class Solution_7 {
    public String reverseWords(String s) {
        if (s == null || "".equals(s) || s.length() <= 1) {
            return s;
        }
        String[] arr = s.split(" ");
        if (arr.length <= 1) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = arr.length - 1; i >= 0; i--) {
            String item = arr[i];
            if (item == null || "".equals(item)) {
                continue;
            }
            sb.append(item).append(" ");
        }
        return sb.toString().trim();
    }

    public static void main(String[] args) {
        Solution_7 solution_7 = new Solution_7();
        System.out.println(solution_7.reverseWords("the sky is blue"));
    }
}
