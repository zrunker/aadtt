package cc.banzhi.android.algorithmdemo;

/**
 * @program: AlgorithmDemo
 * @description: 力扣 80. 删除有序数组中的重复项 II
 * @author: zoufengli01
 * @create: 2022/8/16 11:11
 **/
public class Solution_78 {

    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length <= 0) return 0;
        if (nums.length <= 2) return nums.length;

        int preIndex = 0;
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[preIndex] != nums[i]) {
                nums[++preIndex] = nums[i];
                count = 1;
            } else {
                count++;
                if (count == 2) {
                    nums[++preIndex] = nums[i];
                }
            }
        }
        return preIndex + 1;
    }

    public static void main(String[] args) {
        Solution_78 solution_78 = new Solution_78();
        System.out.println(solution_78.removeDuplicates(new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3}));
    }

}
