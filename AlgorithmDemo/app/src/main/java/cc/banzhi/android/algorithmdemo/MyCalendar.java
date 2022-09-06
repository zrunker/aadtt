package cc.banzhi.android.algorithmdemo;

import java.util.TreeMap;

/**
 * @program: AlgorithmDemo
 * @description: 力扣 729. 我的日程安排表 I
 * @author: zoufengli01
 * @create: 2022/8/16 23:49
 **/
class MyCalendar {
    private final TreeMap<Integer, Integer> treeMap;

    public MyCalendar() {
        treeMap = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        Integer preStart = treeMap.floorKey(start), nextStart = treeMap.ceilingKey(start);
        if ((preStart == null || treeMap.get(preStart) <= start) &&
                (nextStart == null || end <= nextStart)) {
            treeMap.put(start, end);
            return true;
        }
        return false;
    }
}
