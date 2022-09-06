package cc.banzhi.android.algorithmdemo;

/**
 * @program: AlgorithmDemo
 * @description: 归并排序
 * @author: zoufengli01
 * @create: 2022/7/25 15:47
 **/
public class Solution_2 {

    public void mergeSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        int[] temp = new int[arr.length];
        sort(arr, 0, arr.length - 1, temp);
    }

    private void sort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            // 先拆分
            sort(arr, left, mid, temp);
            sort(arr, mid + 1, right, temp);
            // 再合并
            merge(arr, left, mid, right, temp);
        }
    }

    private void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left;
        int j = mid + 1;
        int t = 0;
        while (i <= mid && j <= right) {
            if (arr[i] < arr[j]) {
                temp[t++] = arr[i++];
            } else {
                temp[t++] = arr[j++];
            }
        }
        while (i <= mid) {
            temp[t++] = arr[i++];
        }
        while (j <= right) {
            temp[t++] = arr[j++];
        }

        t = 0;
        while (left <= right) {
            arr[left++] = temp[t++];
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 43, 45, 221, 654, 34, 6, 1, 64, 7, 86};

        Solution_2 solution_2 = new Solution_2();
        solution_2.mergeSort(arr);

        for (int item : arr) {
            System.out.println("Solution_2：" + item);
        }
    }
}
