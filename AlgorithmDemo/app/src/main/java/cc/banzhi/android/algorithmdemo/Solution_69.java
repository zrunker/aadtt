package cc.banzhi.android.algorithmdemo;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @program: AlgorithmDemo
 * @description: 力扣 剑指 Offer 40. 最小的k个数
 * @author: zoufengli01
 * @create: 2022/8/15 00:24
 **/
@RequiresApi(api = Build.VERSION_CODES.N)
public class Solution_69 {

    public int[] getLeastNumbers(int[] arr, int k) {
        if (arr == null || arr.length < k) return null;

        // 构建大顶堆
        Queue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int j : arr) {
            queue.add(j);
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
        Solution_69 solution_69 = new Solution_69();
        System.out.println(Arrays.toString(solution_69.getLeastNumbers(new int[]{3, 2, 1}, 2)));
    }
}
