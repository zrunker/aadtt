package cc.banzhi.android.algorithmdemo;

/**
 * @program: AlgorithmDemo
 * @description: 力扣 剑指 Offer 53 - II. 0～n-1中缺失的数字
 * @author: zoufengli01
 * @create: 2022/8/25 10:44
 **/
public class Solution_111 {
    private int res = -1;

    public int missingNumber(int[] nums) {
        findNum(nums, 0, nums.length - 1);
        return res;
    }

    private void findNum(int[] nums, int left, int right) {
        if (left < right && res == -1) {
            int mid = left + (right - left) / 2;

            findNum(nums, left, mid);
            findNum(nums, mid + 1, right);

            res = findNumItem(nums, left, right);
        }
    }

    private int findNumItem(int[] nums, int left, int right) {
        while (left <= right) {
            if (nums[left++] != left - 1) {
                return left - 1;
            }
        }
        return -1;
    }

    public int missingNumber2(int[] nums) {
        int index = 0;
        while (index < nums.length) {
            if (nums[index++] != index - 1) {
                return index - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution_111 solution_111 = new Solution_111();
        int res = solution_111.missingNumber(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 9});
        System.out.println(res);
    }
}
