package cc.banzhi.android.algorithmdemo;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: AlgorithmDemo
 * @description: 力扣 139. 单词拆分
 * @author: zoufengli01
 * @create: 2022/7/29 08:57
 **/
public class Solution_11 {

    // 回溯
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || "".equals(s)) {
            return true;
        }
        for (int i = 0; i < s.length(); i++) {
            String temp = s.substring(0, i + 1);
            if (!wordDict.contains(temp)) {
                continue;
            }
            String newStr = s.substring(i + 1);
            if (wordBreak(newStr, wordDict)) {
                return true;
            }
        }
        return false;
    }

    // 动态规划
    public boolean wordBreak2(String s, List<String> wordDict) {
        if (s == null || "".equals(s)) {
            return true;
        }
        // 长度为n的单词 有n + 1个切割点 比如: _l_i_n_t_
        boolean[] dp = new boolean[s.length() + 1];
        // 默认空字符串为true
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        Solution_11 solution_11 = new Solution_11();
        ArrayList<String> dictList = new ArrayList<>();
        dictList.add("apple");
        dictList.add("pen");
        System.out.println(solution_11.wordBreak("applepenapple", dictList));
    }
}
