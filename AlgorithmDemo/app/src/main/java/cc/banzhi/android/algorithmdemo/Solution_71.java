package cc.banzhi.android.algorithmdemo;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

/**
 * @program: AlgorithmDemo
 * @description: 力扣 347. 前 K 个高频元素
 * @author: zoufengli01
 * @create: 2022/8/15 09:46
 **/
@RequiresApi(api = Build.VERSION_CODES.N)
public class Solution_71 {

    public int[] topKFrequent(int[] nums, int k) {
        if (nums == null || nums.length < k) return null;
        if (k <= 0) return null;

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int item : nums) {
            int num = getMapValue(item, map);
            map.put(item, ++num);
        }

        Queue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>((o1, o2) ->
                o1.getValue() - o2.getValue());
        Set<Map.Entry<Integer, Integer>> set = map.entrySet();
        for (Map.Entry<Integer, Integer> entry : set) {
            queue.add(entry);
            if (queue.size() > k) {
                queue.poll();
            }
        }

        int[] res = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            res[i] = queue.poll().getKey();
        }

        return res;
    }

    private int getMapValue(int key, HashMap<Integer, Integer> map) {
        Integer num = map.get(key);
        return num == null ? 0 : num;
    }

    public static void main(String[] args) {
        Solution_71 solution_71 = new Solution_71();
        System.out.println(Arrays.toString(solution_71.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2)));
    }
}
