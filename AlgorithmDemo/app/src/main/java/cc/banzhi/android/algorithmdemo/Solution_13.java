package cc.banzhi.android.algorithmdemo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: AlgorithmDemo
 * @description: 力扣 46. 全排列
 * @author: zoufengli01
 * @create: 2022/7/29 19:35
 **/
public class Solution_13 {
    private final List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return null;
        }
        backTrack(nums, new LinkedList<>());
        return res;
    }

    // 回溯
    private void backTrack(int[] nums, LinkedList<Integer> trackList) {
        if (nums.length == trackList.size()) {
            res.add(new ArrayList<>(trackList));
            return;
        }
        for (int item : nums) {
            if (trackList.contains(item)) {
                continue;
            }
            trackList.add(item);
            backTrack(nums, trackList);
            trackList.removeLast();
        }
    }

    public static void main(String[] args) {
        Solution_13 solution_13 = new Solution_13();
        System.out.println(solution_13.permute(new int[]{1, 2, 3}));
    }
}
