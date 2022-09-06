package cc.banzhi.android.algorithmdemo;

import java.util.HashMap;

/**
 * @program: AlgorithmDemo
 * @description: 力扣 567. 字符串的排列
 * @author: zoufengli01
 * @create: 2022/8/5 17:37
 **/
public class Solution_26 {

    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> windows = new HashMap<>(),
                needs = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            int num = getMapValue(c, needs);
            needs.put(c, ++num);
        }

        int left = 0, right = 0;
        int valid = 0;
        while (right < s2.length()) {
            char c = s2.charAt(right);
            right++;
            if (needs.containsKey(c)) {
                int num = getMapValue(c, windows);
                windows.put(c, ++num);
                if (getMapValue(c, windows) == getMapValue(c, needs)) {
                    valid++;
                }
            }

            while (right - left >= s1.length()) {
                // 判断结果
                if (valid == needs.size()) {
                    return true;
                }

                char d = s2.charAt(left);
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

        return false;
    }

    private int getMapValue(Character key,
                            HashMap<Character, Integer> map) {
        Integer num = map.get(key);
        return num == null ? 0 : num;
    }

    public static void main(String[] args) {
        Solution_26 solution_26 = new Solution_26();
        System.out.println(solution_26.checkInclusion("ab", "eidbaooo"));
    }
}
