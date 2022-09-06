package cc.banzhi.android.algorithmdemo;

import java.util.HashSet;
import java.util.Set;

/**
 * @program: AlgorithmDemo
 * @description: 力扣 1044. 最长重复子串
 * @author: zoufengli01
 * @create: 2022/7/23 11:32
 **/
public class Solution_1 {
    private final Set<String> set = new HashSet<>();

    public String longestDupSubstring(String s) {
        if (s == null || s.equals("") || s.length() <= 1) {
            return "";
        }
        String maxStr = "";
        // 穷举字符串中所有子串
        for (int i = s.length(); i > 0; i--) {
            for (int j = 0; j < i; j++) {
                String subStr = s.substring(j, i);
                if (set.contains(subStr)) {
                    maxStr = subStr.length() - maxStr.length() > 0 ? subStr : maxStr;
                } else {
                    set.add(subStr);
                }
            }
        }
        return maxStr;
    }

    public static void main(String[] args) {
        Solution_1 solution_1 = new Solution_1();
        solution_1.longestDupSubstring("banana");
    }
}
