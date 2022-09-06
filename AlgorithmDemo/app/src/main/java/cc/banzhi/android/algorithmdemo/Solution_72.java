package cc.banzhi.android.algorithmdemo;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

/**
 * @program: AlgorithmDemo
 * @description: 力扣 692. 前K个高频单词
 * @author: zoufengli01
 * @create: 2022/8/15 10:21
 **/
@RequiresApi(api = Build.VERSION_CODES.N)
public class Solution_72 {

    public List<String> topKFrequent(String[] words, int k) {
        if (words == null || words.length < k) return null;
        if (k <= 0) return null;

        HashMap<String, Integer> map = new HashMap<>();
        for (String word : words) {
            int num = getMapValue(word, map);
            map.put(word, ++num);
        }

        Queue<Map.Entry<String, Integer>> queue = new PriorityQueue<>((o1, o2) -> {
            if (o1.getValue().equals(o2.getValue())) {
                return o2.getKey().compareTo(o1.getKey());
            } else {
                return o1.getValue() - o2.getValue();
            }
        });
        Set<Map.Entry<String, Integer>> set = map.entrySet();
        for (Map.Entry<String, Integer> entry : set) {
            queue.add(entry);
            if (queue.size() > k) {
                queue.poll();
            }
        }

        List<String> list = new ArrayList<>(k);
        while (!queue.isEmpty()) {
            list.add(queue.poll().getKey());
        }

        Collections.reverse(list);

        return list;
    }

    private int getMapValue(String key, HashMap<String, Integer> map) {
        Integer num = map.get(key);
        return num == null ? 0 : num;
    }

    public static void main(String[] args) {
        Solution_72 solution_72 = new Solution_72();
        System.out.println(solution_72.topKFrequent(new String[]{"i", "love", "leetcode", "i", "love", "coding"}, 2));
    }
}
