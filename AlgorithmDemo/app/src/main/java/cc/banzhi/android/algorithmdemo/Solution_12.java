package cc.banzhi.android.algorithmdemo;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: AlgorithmDemo
 * @description: 力扣 140. 单词拆分 II
 * @author: zoufengli01
 * @create: 2022/7/29 11:52
 **/
public class Solution_12 {
    private final List<List<String>> res = new ArrayList<>();

    // 回溯
    public List<String> wordBreak(String s, List<String> wordDict) {
        if (s == null || "".equals(s)) {
            return null;
        }
        backTrack(s, wordDict, new ArrayList<>());
        List<String> list = new ArrayList<>();
        for (List<String> item : res) {
            StringBuilder result = new StringBuilder();
            for (String str : item) {
                result.append(str).append(" ");
            }
            list.add(result.toString().trim());
        }
        return list;
    }

    private void backTrack(String s, List<String> wordDict, List<String> trackList) {
        if (s == null || "".equals(s)) {
            res.add(new ArrayList<>(trackList));
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            String temp = s.substring(0, i + 1);
            if (!wordDict.contains(temp)) {
                continue;
            }
            trackList.add(temp);

            String newStr = s.substring(i + 1);
            backTrack(newStr, wordDict, trackList);

            trackList.remove(temp);
        }
    }

    public static void main(String[] args) {
        Solution_12 solution_12 = new Solution_12();
        ArrayList<String> list = new ArrayList<>();
        list.add("apple");
        list.add("pen");
        list.add("applepen");
        list.add("pine");
        list.add("pineapple");
        System.out.println(solution_12.wordBreak("pineapplepenapple", list));
    }
}
