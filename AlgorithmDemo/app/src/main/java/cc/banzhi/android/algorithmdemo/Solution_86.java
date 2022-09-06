package cc.banzhi.android.algorithmdemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: AlgorithmDemo
 * @description: 给定两个数组，在第二个数组中，找出比第一个数组每个位置都大的数。
 * @author: zoufengli01
 * @create: 2022/8/18 10:16
 **/
public class Solution_86 {

    public int[] maxNums(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) return null;
        int max = Integer.MIN_VALUE;
        for (int num : nums1) {
            max = Math.max(num, max);
        }
        List<Integer> list = new ArrayList<>();
        for (int num : nums2) {
            if (num > max) {
                list.add(num);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution_86 solution_86 = new Solution_86();
        System.out.println(Arrays.toString(solution_86.maxNums(
                new int[]{34, 45, 65, 23, 12, 45},
                new int[]{56, 23, 64, 76, 87, 23, 34})));
    }
}
