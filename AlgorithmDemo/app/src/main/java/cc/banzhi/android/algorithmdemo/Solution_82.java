package cc.banzhi.android.algorithmdemo;

/**
 * @program: AlgorithmDemo
 * @description: 主元素
 * - 给定一个整型数组，找出主元素，它在数组中的出现次数严格大于数组元素个数的二分之一(可以假设数组非空，且数组中总是存在主元素)。请设计时间复杂度为 O(N) 、空间复杂度为 O(1) 的解决方案。
 * @author: zoufengli01
 * @create: 2022/8/17 01:11
 **/
public class Solution_82 {

    public int majorityElement(int[] nums) {
        int count = 0;
        int majorElem = 0;
        for (int item : nums) {
            if (count == 0) {
                majorElem = item;
            }
            if (majorElem == item) {
                count++;
            } else {
                count--;
            }
        }
        return majorElem;
    }

    public static void main(String[] args) {
        Solution_82 solution_82 = new Solution_82();
        System.out.println(solution_82.majorityElement(new int[]{1, 2, 5, 9, 5, 9, 5, 5, 5}));
    }
}
