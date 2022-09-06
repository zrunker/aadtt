package cc.banzhi.android.algorithmdemo;

/**
 * @program: AlgorithmDemo
 * @description: 冒泡排序
 * @author: zoufengli01
 * @create: 2022/8/7 17:16
 **/
public class Solution_32 {

    public void bubbleSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                if (i != j && arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 43, 45, 221, 654, 34, 6, 1, 64, 7, 86};

        Solution_32 solution_32 = new Solution_32();
        solution_32.bubbleSort(arr);

        for (int item : arr) {
            System.out.println("Solution_32：" + item);
        }
    }
}
