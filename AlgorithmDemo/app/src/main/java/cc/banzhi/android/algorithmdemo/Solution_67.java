package cc.banzhi.android.algorithmdemo;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @program: AlgorithmDemo
 * @description: 前K大的数
 * @author: zoufengli01
 * @create: 2022/8/14 23:28
 **/
public class Solution_67 {

    public int[] topk(int[] nums, int k) {
        if (nums == null || nums.length < k) return null;

        // 定义优先队列，默认小顶堆
        Queue<Integer> queue = new PriorityQueue<>();

        for (int num : nums) {
            queue.add(num);
            if (queue.size() > k) {
                queue.poll();
            }
        }

        int[] res = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            res[i] = queue.poll();
        }

        return res;
    }

    public static void main(String[] args) {
        Solution_67 solution_67 = new Solution_67();
        System.out.println(Arrays.toString(solution_67.topk(new int[]{0, 1, 2, 1, 3, 4}, 4)));
    }

}
