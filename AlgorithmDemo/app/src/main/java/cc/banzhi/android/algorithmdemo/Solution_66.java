package cc.banzhi.android.algorithmdemo;

import java.util.HashMap;

/**
 * @program: AlgorithmDemo
 * @description: 力扣 149. 直线上最多的点数
 * @author: zoufengli01
 * @create: 2022/8/14 17:11
 **/
public class Solution_66 {

    // 暴力求解，注意：重合、横线、竖线这三种情况比较特殊
    public int maxPoints(int[][] points) {
        if (points == null || points.length == 0) return 0;
        if (points.length == 1) return 1;

        int maxNum = 0;
        int length = points.length;
        for (int i = 0; i < length; i++) {
            int x = points[i][0];
            int y = points[i][1];
            HashMap<Double, Integer> map = new HashMap<>();
            int overlap = 0;
            for (int j = 0; j < length; j++) {
                if (i == j) {
                    continue;
                }

                int x1 = points[j][0];
                int y1 = points[j][1];

                if (x == x1 && y == y1) {// 重合
                    overlap++;
                    continue;
                }

                double rate;
                if (x == x1) {// 竖线
                    rate = Integer.MIN_VALUE;
                } else {
                    rate = (y - y1) * 1.0d / (x - x1);
                }

                Integer num = map.get(rate);
                // 原点，num=1
                if (num == null) num = 1;
                num++;
                map.put(rate, num);

                maxNum = Math.max(maxNum, num + overlap);
            }
        }

        return maxNum;
    }

    public static void main(String[] args) {
        Solution_66 solution_66 = new Solution_66();
        System.out.println(solution_66.maxPoints(new int[][]{
                {1, 1}, {2, 2}, {3, 3}
        }));
    }
}
