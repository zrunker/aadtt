package cc.banzhi.android.algorithmdemo;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @program: AlgorithmDemo
 * @description: 力扣 剑指 Offer II 109. 开密码锁
 * @author: zoufengli01
 * @create: 2022/8/8 16:45
 **/
public class Solution_36 {

    private String up(String s, int j) {
        char[] chs = s.toCharArray();
        char c = chs[j];
        if (c == '9') {
            chs[j] = '0';
        } else {
            chs[j] += 1;
        }
        return new String(chs);
    }

    private String down(String s, int j) {
        char[] chs = s.toCharArray();
        char c = chs[j];
        if (c == '0') {
            chs[j] = 9;
        } else {
            chs[j] -= 1;
        }
        return new String(chs);
    }

    public int openLock(String[] deadends, String target) {
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>(Arrays.asList(deadends));

        queue.offer("0000");
        visited.add("0000");
        int step = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String item = queue.poll();
                if (item == null) continue;
                if (target.equals(item)) {
                    return step;
                }
                for (int j = 0; j < 4; j++) {
                    String up = up(item, j);
                    String down = down(item, j);

                    if (!visited.contains(up)) {
                        queue.offer(up);
                        visited.add(up);
                    }
                    if (!visited.contains(down)) {
                        queue.offer(down);
                        visited.add(down);
                    }
                }
            }
            step++;
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution_36 solution_36 = new Solution_36();
        System.out.println(solution_36.openLock(new String[]{"0201", "0101", "0102", "1212", "2002"}, "0202"));
    }
}
