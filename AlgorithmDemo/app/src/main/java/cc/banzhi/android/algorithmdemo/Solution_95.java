package cc.banzhi.android.algorithmdemo;

import java.util.HashMap;

/**
 * @program: AlgorithmDemo
 * @description: 力扣 剑指 Offer 50. 第一个只出现一次的字符
 * @author: zoufengli01
 * @create: 2022/8/19 10:30
 **/
public class Solution_95 {

    public char firstUniqChar(String s) {
        if (s == null || "".equals(s)) return ' ';
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int num = getMapValue(c, map);
            map.put(c, ++num);
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (getMapValue(c, map) == 1) {
                return c;
            }
        }
        return ' ';
    }

    private int getMapValue(Character key, HashMap<Character, Integer> map) {
        Integer num = map.get(key);
        return num == null ? 0 : num;
    }

    public static void main(String[] args) {
        Solution_95 solution_95 = new Solution_95();
        System.out.println(solution_95.firstUniqChar("abaccdeff"));
    }
}
