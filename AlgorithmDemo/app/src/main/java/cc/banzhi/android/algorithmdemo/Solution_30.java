package cc.banzhi.android.algorithmdemo;

import java.util.HashMap;

/**
 * @program: AlgorithmDemo
 * @description: 力扣 剑指 Offer 48. 最长不含重复字符的子字符串
 * @author: zoufengli01
 * @create: 2022/8/6 22:43
 **/
public class Solution_30 {

    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> windows = new HashMap<>();
        int left = 0, right = 0;
        int maxLen = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            int num = getMapValue(c, windows);
            if (num == 0) {
                maxLen = Math.max(right - left, maxLen);
            }
            windows.put(c, ++num);
            while (getMapValue(c, windows) > 1) {
                char d = s.charAt(left);
                left++;
                int num1 = getMapValue(d, windows);
                if (num1 > 0) {
                    windows.put(d, --num1);
                }
            }
        }
        return maxLen;
    }

    private int getMapValue(Character key,
                            HashMap<Character, Integer> map) {
        Integer num = map.get(key);
        return num == null ? 0 : num;
    }

    public static void main(String[] args) {
        Solution_30 solution_30 = new Solution_30();
        System.out.println(solution_30.lengthOfLongestSubstring("abcabcbb"));
    }
}
