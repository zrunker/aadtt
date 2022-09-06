package cc.banzhi.android.algorithmdemo;

import java.util.HashMap;

/**
 * @program: AlgorithmDemo
 * @description: 力扣 76. 最小覆盖子串
 * @author: zoufengli01
 * @create: 2022/8/1 16:25
 **/
public class Solution_24 {

    public String minWindow(String s, String t) {
        String res = s;
        HashMap<Character, Integer> windowMap = new HashMap<>(),
                needMap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            int num = getMapValue(c, needMap);
            needMap.put(c, ++num);
        }

        int left = 0, right = 0, valid = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            if (needMap.containsKey(c)) {
                int num = getMapValue(c, windowMap);
                windowMap.put(c, ++num);
                if (getMapValue(c, windowMap) == getMapValue(c, needMap)) {
                    valid++;
                }
            }

            while (valid == needMap.size()) {
                if (right - left < res.length()) {
                    res = s.substring(left, right);
                }
                char d = s.charAt(left);
                left++;
                if (needMap.containsKey(d)) {
                    int num = getMapValue(d, windowMap);
                    if (num == getMapValue(d, needMap)) {
                        valid--;
                    }
                    windowMap.put(d, --num);
                }
            }
        }
        return s.equals(res) ? "" : res;
    }

    private int getMapValue(Character key,
                            HashMap<Character, Integer> map) {
        Integer num = map.get(key);
        return num == null ? 0 : num;
    }

    public static void main(String[] args) {
        Solution_24 solution_24 = new Solution_24();
        System.out.println(solution_24.minWindow("ADOBECODEBANC", "ABC"));
    }
}
