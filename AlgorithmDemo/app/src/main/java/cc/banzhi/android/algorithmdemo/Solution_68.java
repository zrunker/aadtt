package cc.banzhi.android.algorithmdemo;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @program: AlgorithmDemo
 * @description: 前K大的数 II
 * @author: zoufengli01
 * @create: 2022/8/15 00:03
 **/
public class Solution_68 {
    private final Queue<Integer> minHeap;
    private final int maxSize;

    public Solution_68(int k) {
        minHeap = new PriorityQueue<>();
        maxSize = k;
    }

    public void add(int num) {
        minHeap.add(num);
        if (minHeap.size() > maxSize) {
            minHeap.poll();
        }
    }

    public int[] topk() {
        if (minHeap.size() != maxSize) return null;
        int[] nums = new int[maxSize];
        int index = maxSize - 1;
        for (Integer val : minHeap) {
            nums[index--] = val;
        }
        return nums;
    }

    public static void main(String[] args) {
        Solution_68 solution_68 = new Solution_68(4);
        solution_68.add(0);
        solution_68.add(1);
        solution_68.add(2);
        solution_68.add(1);
        solution_68.add(2);
        solution_68.add(3);
        System.out.println(Arrays.toString(solution_68.topk()));
    }
}
