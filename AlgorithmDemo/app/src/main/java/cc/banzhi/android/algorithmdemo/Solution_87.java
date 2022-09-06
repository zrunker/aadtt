package cc.banzhi.android.algorithmdemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: AlgorithmDemo
 * @description: 力扣 56. 合并区间
 * @author: zoufengli01
 * @create: 2022/8/18 10:29
 **/
public class Solution_87 {

    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return null;

        // 以开始节点排序
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);

        List<int[]> merged = new ArrayList<>();
        for (int[] interval : intervals) {
            int start = interval[0], end = interval[1];
            if (merged.size() == 0 || merged.get(merged.size() - 1)[1] < start) {
                merged.add(interval);
            } else {
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], end);
            }
        }

        return merged.toArray(new int[merged.size()][]);
    }

    public static void main(String[] args) {
        Solution_87 solution_87 = new Solution_87();
        System.out.println(Arrays.deepToString(solution_87.merge(new int[][]{
                {1, 3}, {2, 6}, {8, 10}, {15, 18}
        })));
    }
}
