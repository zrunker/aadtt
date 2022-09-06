package cc.banzhi.android.algorithmdemo;

import java.util.HashMap;

/**
 * @program: AlgorithmDemo
 * @description: 力扣 525. 连续数组
 * @author: zoufengli01
 * @create: 2022/8/14 00:20
 **/
public class Solution_64 {

    public int findMaxLength(int[] nums) {
        if (nums == null || nums.length <= 1) return 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int maxLen = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                count--;
            } else {
                count++;
            }
            if (map.containsKey(count)) {
                maxLen = Math.max(maxLen, i - map.get(count));
            } else {
                map.put(count, i);
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        Solution_64 solution_64 = new Solution_64();
        System.out.println(solution_64.findMaxLength(new int[]{0, 1}));
    }
}
