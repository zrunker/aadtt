package cc.banzhi.android.algorithmdemo;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: AlgorithmDemo
 * @description: 力扣 293. 翻转游戏
 * @author: zoufengli01
 * @create: 2022/7/27 11:22
 **/
public class Solution_6 {

    public List<String> generatePossibleNextMoves(String s) {
        if (s == null || "".equals(s)) {
            return null;
        }
        List<String> result = new ArrayList<>();
        for (int i = -1; (i = s.indexOf("++", i + 1)) >= 0; ) {
            result.add(s.substring(0, i) + "--" + s.substring(i + 2));
        }
        return result;
    }

    public static void main(String[] args) {
        Solution_6 solution_6 = new Solution_6();
        List<String> result = solution_6.generatePossibleNextMoves("-++--+_+_+--+_++--+_++--+--_+++_");

        for (String item : result) {
            System.out.println(item);
        }
    }
}
