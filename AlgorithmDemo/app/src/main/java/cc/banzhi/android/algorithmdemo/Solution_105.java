package cc.banzhi.android.algorithmdemo;

/**
 * @program: AlgorithmDemo
 * @description: 牛客网 局部最小值位置
 * @author: zoufengli01
 * @create: 2022/8/22 23:10
 **/
public class Solution_105 {

    public int getLessIndex(int[] arr) {
        if (arr == null || arr.length <= 1) return -1;
        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                if (arr[i] < arr[i + 1]) return i;
                continue;
            }
            if (i == arr.length - 1) {
                if (arr[i] < arr[i - 1]) return i;
                continue;
            }
            int pre = arr[i - 1];
            int num = arr[i];
            int next = arr[i + 1];
            if (pre > num && next > num) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution_105 solution_105 = new Solution_105();
        System.out.println(solution_105.getLessIndex(new int[]{2, 54, 22, 65, 7, 3, 4, 23}));
    }
}
