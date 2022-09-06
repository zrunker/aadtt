package cc.banzhi.android.algorithmdemo;

import java.util.HashSet;
import java.util.Set;

/**
 * @program: AlgorithmDemo
 * @description: 力扣 剑指 Offer 61. 扑克牌中的顺子
 * @author: zoufengli01
 * @create: 2022/8/21 00:30
 **/
public class Solution_101 {

    public boolean isStraight(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

        for (int item : nums) {
            if (item == 0) continue;

            if (set.contains(item)) return false;
            set.add(item);

            min = Math.min(min, item);
            max = Math.max(max, item);
        }

        return max - min < 5;
    }

    public static void main(String[] args) {
        Solution_101 solution_101 = new Solution_101();
        System.out.println(solution_101.isStraight(new int[]{1, 2, 3, 4, 5}));
    }
}
