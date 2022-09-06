package cc.banzhi.android.algorithmdemo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @program: AlgorithmDemo
 * @description: 力扣 剑指 Offer II 015. 字符串中的所有变位词
 * @author: zoufengli01
 * @create: 2022/8/5 18:58
 **/
public class Solution_27 {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();

        HashMap<Character, Integer> windows = new HashMap<>(),
                needs = new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            int num = getMapValue(c, needs);
            needs.put(c, ++num);
        }
        int left = 0, right = 0, valid = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            if (needs.containsKey(c)) {
                int num = getMapValue(c, windows);
                windows.put(c, ++num);
                if (getMapValue(c, windows) == getMapValue(c, needs)) {
                    valid++;
                }
            }
            while (right - left >= p.length()) {
                // 结果
                if (valid == needs.size()) {
                    res.add(left);
                }

                char d = s.charAt(left);
                left++;
                if (needs.containsKey(d)) {
                    int num = getMapValue(d, windows);
                    if (num == getMapValue(d, needs)) {
                        valid--;
                    }
                    windows.put(d, --num);
                }
            }
        }
        return res;
    }

    private int getMapValue(Character key,
                            HashMap<Character, Integer> map) {
        Integer num = map.get(key);
        return num == null ? 0 : num;
    }

    public static void main(String[] args) {
        Solution_27 solution_27 = new Solution_27();
        System.out.println(solution_27.findAnagrams("cbaebabacd", "abc"));
    }
}
