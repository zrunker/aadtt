package cc.banzhi.android.algorithmdemo;

/**
 * @program: AlgorithmDemo
 * @description: 力扣 704. 二分查找
 * @author: zoufengli01
 * @create: 2022/8/12 11:13
 **/
public class Solution_56 {

    public int search(int[] nums, int target) {
        if (nums == null || nums.length <= 0) return -1;
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int temp = nums[mid];
            if (temp == target) {
                return mid;
            } else if (temp < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution_56 solution_56 = new Solution_56();
        System.out.println(solution_56.search(new int[]{-1, 0, 3, 5, 9, 12}, 9));
    }
}
