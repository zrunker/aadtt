package cc.banzhi.android.algorithmdemo;

import java.util.HashMap;

/**
 * @program: AlgorithmDemo
 * @description: 力扣 面试题 17.10. 主要元素
 * @author: zoufengli01
 * @create: 2022/8/17 17:54
 **/
public class Solution_83 {

    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int majorSize = nums.length / 2 + 1;
        for (int item : nums) {
            int num = getMapValue(item, map);
            map.put(item, ++num);
            if (num >= majorSize) {
                return item;
            }
        }
        return -1;
    }

    private int getMapValue(int key, HashMap<Integer, Integer> map) {
        Integer num = map.get(key);
        return num == null ? 0 : num;
    }

    public static void main(String[] args) {
        Solution_83 solution_83 = new Solution_83();
        System.out.println(solution_83.majorityElement(new int[]{1, 2, 5, 9, 5, 9, 5, 5, 5}));
    }
}
