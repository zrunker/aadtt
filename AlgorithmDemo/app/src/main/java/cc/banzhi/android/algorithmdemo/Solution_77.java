package cc.banzhi.android.algorithmdemo;

/**
 * @program: AlgorithmDemo
 * @description: 力扣 26. 删除有序数组中的重复项
 * @author: zoufengli01
 * @create: 2022/8/16 10:31
 **/
public class Solution_77 {

    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length <= 0) return 0;

        int preIndex = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[preIndex] != nums[i]) {
                nums[++preIndex] = nums[i];
            }
        }
        return preIndex + 1;
    }

    public static void main(String[] args) {
        Solution_77 solution_77 = new Solution_77();
        System.out.println(solution_77.removeDuplicates(new int[]{1, 1, 2}));
    }
}
