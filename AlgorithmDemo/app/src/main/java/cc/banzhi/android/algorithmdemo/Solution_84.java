package cc.banzhi.android.algorithmdemo;

import java.util.Arrays;

/**
 * @program: AlgorithmDemo
 * @description: 年龄排序
 * - 一个公司有几万名在职员工，请设计一个排序算法，对公司所有员工的年龄进行排序，要求时间效率O ( n ) O(n)O(n)。可以使用辅助内存，但使用辅助空间不得超过O ( 1 ) O(1)O(1)
 * @author: zoufengli01
 * @create: 2022/8/18 00:14
 **/
public class Solution_84 {

    public void ageSort(int[] ages) {
        int[] bucket = new int[101];
        Arrays.fill(bucket, 0);
        for (int item : ages) {
            bucket[item]++;
        }
        int index = 0;
        for (int i = 0; i < bucket.length; i++) {
            int item = bucket[i];
            for (int j = 0; j < item; j++) {
                ages[index++] = i;
            }
        }
    }

    public static void main(String[] args) {
        Solution_84 solution_84 = new Solution_84();
        int[] ages = new int[]{
                23, 54, 65, 23, 12, 34, 52, 24, 45, 64, 23, 32, 13
        };
        solution_84.ageSort(ages);
        System.out.println(Arrays.toString(ages));
    }
}
