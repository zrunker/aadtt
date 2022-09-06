package cc.banzhi.android.algorithmdemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * @program: AlgorithmDemo
 * @description: 力扣 剑指 Offer 38. 字符串的排列
 * @author: zoufengli01
 * @create: 2022/8/5 16:25
 **/
public class Solution_25 {
    private final Set<String> set = new HashSet<>();

    public String[] permutation(String s) {
        List<String> data = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            data.add(i + "" + s.charAt(i));
        }
        backTrack2(data, new LinkedList<>());

//        backTrack(s, new LinkedList<>());

        String[] res = new String[set.size()];
        int i = 0;
        for (String item : set) {
            res[i++] = item;
        }
        return res;
    }

    private void backTrack(String s, LinkedList<Character> list) {
        if (list.size() == s.length()) {
            StringBuilder sb = new StringBuilder();
            for (Character item : list) {
                sb.append(item);
            }
            set.add(sb.toString());
            return;
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ('$' == c) {
                continue;
            }
            list.add(c);

            String newStr = s.substring(0, i) + '$' + s.substring(i + 1);
            backTrack(newStr, list);

            list.removeLast();
        }
    }

    private void backTrack2(List<String> data, LinkedList<String> list) {
        if (list.size() == data.size()) {
            StringBuilder sb = new StringBuilder();
            for (String item : list) {
                sb.append(item.substring(item.length() - 1));
            }
            set.add(sb.toString());
            return;
        }

        for (int i = 0; i < data.size(); i++) {
            String item = data.get(i);
            if (list.contains(item)) {
                continue;
            }
            list.add(item);

            backTrack2(data, list);

            list.removeLast();
        }
    }

    public static void main(String[] args) {
        Solution_25 solution_25 = new Solution_25();
        System.out.println(Arrays.toString(solution_25.permutation("abc")));
    }
}
