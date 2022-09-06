package cc.banzhi.android.algorithmdemo;

import java.util.LinkedList;

/**
 * @program: AlgorithmDemo
 * @description: 力扣 剑指 Offer 62. 圆圈中最后剩下的数字
 * @author: zoufengli01
 * @create: 2022/8/21 00:56
 **/
public class Solution_102 {

    // 约瑟夫环公式
    public int lastRemaining(int n, int m) {
        if (n < 1 || m < 1) {
            return -1;
        }
        int last = 0;
        for (int i = 2; i <= n; i++) {
            last = (last + m) % i;
        }
        return last;
    }

    // 环形链表
    public int lastRemaining2(int n, int m) {
        if (n < 1 || m < 1) {
            return -1;
        }
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }

        int last = 0;
        while (list.size() != 1) {
            // 要删除的位置：(last + m - 1) % n
            last = (last + m - 1) % list.size();
            list.remove(last);
        }
        return list.getFirst();
    }

    public static void main(String[] args) {
        Solution_102 solution_102 = new Solution_102();
        System.out.println(solution_102.lastRemaining(5, 3));
    }
}
