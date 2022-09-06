package cc.banzhi.android.algorithmdemo;

/**
 * @program: AlgorithmDemo
 * @description: 力扣 27. 移除元素
 * @author: zoufengli01
 * @create: 2022/8/16 09:29
 **/
public class Solution_76 {

    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length <= 0) return 0;

        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i];
            if (val != temp) {
                nums[index++] = temp;
            }
        }

        return index;
    }

    public static void main(String[] args) {
        Solution_76 solution_76 = new Solution_76();
        System.out.println(solution_76.removeElement(new int[]{3, 2, 2, 3}, 3));
    }
}
