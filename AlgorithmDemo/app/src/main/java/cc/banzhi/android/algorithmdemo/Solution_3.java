package cc.banzhi.android.algorithmdemo;

/**
 * @program: AlgorithmDemo
 * @description: 快速排序
 * @author: zoufengli01
 * @create: 2022/7/25 18:06
 **/
public class Solution_3 {

    public void quickSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            // 默认最小值位置
            int min = i;
            // 找出最小值
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            // 交换
            if (i != min) {
                int temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 43, 45, 221, 654, 34, 6, 1, 64, 7, 86};

        Solution_3 solution_3 = new Solution_3();
        solution_3.quickSort(arr);

        for (int item : arr) {
            System.out.println("Solution_3：" + item);
        }
    }
}
